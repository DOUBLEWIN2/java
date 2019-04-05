

import java.io.*;
import java.util.Scanner;

public class Test{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入数据");
        //hasNext方法返回值为boolean
        if (scanner.hasNext()){
            System.out.println(scanner.next());
        }
        scanner.close();
    }
}
//   public static void main(String[] args) throws Exception {
//        String sourceFilePath="E:\\File\\至尊宝.jpg";
//        String destFilePath="E:\\File\\紫霞仙子.jpg";
//        copyFile(sourceFilePath,destFilePath);
//    }
//    public static void copyFile(String sourceFilePath,
//                                String destFilePath) throws Exception {
//        File sourceFile=new File(sourceFilePath);
//        File destFile =new File(destFilePath);
//        InputStream inputStream=new FileInputStream(sourceFile);
//        OutputStream outputStream=new FileOutputStream(destFile);
//        int len=0;
//        byte[] buff=new byte[1024];
//        long start=System.currentTimeMillis();
//        //read()读取单个字节
//        while((len=inputStream.read(buff))!=-1){
//            outputStream.write(buff,0,len);
//        }
//        long end=System.currentTimeMillis();
//        System.out.println("总耗时："+(end-start)+"毫秒");
//    }
//    public static void main(String[] args) throws IOException {
//////    String string="hello";
//////    ByteArrayInputStream byteArrayInputStream=
//////            new ByteArrayInputStream(string.getBytes());
//////    ByteArrayOutputStream byteArrayOutputStream=
//////            new ByteArrayOutputStream();
//////    int len=0;
//////    while((len=byteArrayInputStream.read())!=-1){
//////        byteArrayOutputStream.write(Character.toUpperCase(len));
//////    }
//////    System.out.println(byteArrayOutputStream);
//////    byteArrayInputStream.close();
//////    byteArrayOutputStream.close();
//////}