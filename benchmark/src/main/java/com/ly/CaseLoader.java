package com.ly;

import com.ly.annotations.Benchmark;
import com.ly.annotations.Measurement;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

class CaseRunner{
    //默认配置
    private static  final int DEFAULT_ITERATIONS=10;
    private static  final int DEFAULT_GROUP=5;
    private final List<Case> caseList;
    public CaseRunner(List<Case> caseList){
        this.caseList = caseList;
    }
    public void run() throws InvocationTargetException, IllegalAccessException {
           for (Case bCase:caseList){
               int iterations=DEFAULT_ITERATIONS;
               int group=DEFAULT_GROUP;
               //先获取类级别的配置
               Measurement classMeasurement=bCase.getClass().getAnnotation(Measurement.class);
               if (classMeasurement!=null){
                   iterations=classMeasurement.iterations();
                   group=classMeasurement.group();
               }
               //找到对象中那些方法是需要测试的方法
               Method[] methods=bCase.getClass().getMethods();
               for (Method method:methods){
                   Benchmark benchmark=method.getAnnotation(Benchmark.class);
                   if (benchmark==null){
                       continue;
                   }
                   //获取方法级别的配置
                   Measurement methodMeasurement=method.getAnnotation(Measurement.class);
                   if (methodMeasurement!=null){
                       iterations=methodMeasurement.iterations();
                       group=methodMeasurement.group();
                   }
                   runCase(bCase,method,iterations,group);
               }
           }
    }
    private void runCase(Case bCase,Method method,int iterations,int group) throws InvocationTargetException, IllegalAccessException {
        System.out.println(method.getName());
        for (int i=0;i<group;i++){
            System.out.printf("第 %d 次实验",i);
            long t1=System.currentTimeMillis();
            for (int j=0;j<iterations;j++){
                method.invoke(bCase);
            }
            long t2=System.currentTimeMillis();
            System.out.printf("耗时：%d 毫秒%n",t2-t1);
        }
    }
}
public class CaseLoader {
    public CaseRunner load() throws IOException, ClassNotFoundException,
            IllegalAccessException, InstantiationException {
        String pkgDot="com.ly.cases";
        String pkg="com/ly/cases";
        List<String> classNameList=new ArrayList<String>();
        /**
         * 根据一个固定类，找到类加载器
         * 根据类加载器找到类文件所在的路径
         * 扫描路径的所有类文件
         */
        ClassLoader classLoader=this.getClass().getClassLoader();
        Enumeration<URL> urls=classLoader.getResources(pkg);
        while(urls.hasMoreElements()){
            URL url=urls.nextElement();

            String path = url.getPath();

            System.out.println(path);
            System.out.println(url.getProtocol());
            if (!url.getProtocol().equals("file")){
                //如果不是*.class文件，暂时不支持
                continue;
            }
            String dirName=URLDecoder.decode(url.getPath(),"UTF-8");
            File dir=new File(dirName);
            if (!dir.isDirectory()){
                continue;
            }
            //扫描该目录下的所有*.class 文件
            File[] files=dir.listFiles();
            if (files==null){
                continue;
            }
            for (File files1:files){
                String fileName=files1.getName();
                String className=fileName.substring(0,fileName.length()-6);
                classNameList.add(className);
            }
        }
        List<Case> caseList=new ArrayList<Case>();
        for (String className:classNameList){
            Class<?> cls=Class.forName(pkgDot+"."+className);
            if (hasInterface(cls,Case.class)){
                caseList.add((Case)cls.newInstance());
            }
        }
        return new CaseRunner(caseList);
    }
    private boolean hasInterface(Class<?> cls,Class<?> interF){
        Class<?>[] interfaces=cls.getInterfaces();
        for (Class<?> i:interfaces){
            if (i == interF){
                return true;
            }
        }
        return false;
    }
}
