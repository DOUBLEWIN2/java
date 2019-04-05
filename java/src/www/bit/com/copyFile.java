package www.bit.com;

import java.io.*;

public class copyFile {
    public static void main(String[] args) throws IOException {
        /**
         * sourceFilePath 源文件路径
         * destFilePath 目标文件路径
         */
        String sourceFilePath="E:\\java软件\\jdk api 1.8.CHM";
        String destFilePath="E:\\Test1\\jdk1 api 1.8.CHM";
        copy(sourceFilePath,destFilePath);
    }
    public static void copy(String sourceFilePath,String destFilePath) throws IOException {
        //检测源文件路径是否存在
        checkArgumentNotEmpty(sourceFilePath,"source path must be not null");
        //检测目标路径是否存在
        checkArgumentNotEmpty(destFilePath,"dest path must be not null");
        //取得File对象
        File sourceFile=new File(sourceFilePath);
        //检测源文件是否是一个文件以及源文件不为空
        checkFile(sourceFile,"source must be exists and not be null");
        File destFile=new File(destFilePath);
        //检测目标文件的目录是否存在，若不存在建立多级父目录
        checkParentFile(destFile,"destParent must be exists");
        dataCopy(sourceFile,destFile);
    }
    private static void dataCopy(File source,File dest) throws IOException {
        InputStream inputStream=new FileInputStream(source);
        OutputStream outputStream=new FileOutputStream(dest);
        int len =0;
        byte[] buff =new byte[1024*1024];
        long start=System.currentTimeMillis();
        while((len=inputStream.read(buff))!=-1){
            outputStream.write(buff,0,len);
        }
        outputStream.close();
        inputStream.close();
        long end=System.currentTimeMillis();
        System.out.println("总耗时："+(end-start)+"毫秒");
    }
    /**
     *
     * 检测参数不为空，如果为空，抛出异常
     *
     * @param args 参数
     * @param msg 异常的提示信息
     */
    private static void checkArgumentNotEmpty(Object args,String msg){
          if(args==null){
              throw new NullPointerException(msg);
          }
          if(args instanceof CharSequence){
              if(((CharSequence)(args)).length()==0){
                  throw new NullPointerException(msg);
              }
          }
    }
    private static void checkFile(File file,String msg){
          if(!file.exists()||file.isDirectory()||file==null){
              throw new IllegalArgumentException(msg);
          }
    }
    private static void checkParentFile(File file,String msg){
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
    }

}
