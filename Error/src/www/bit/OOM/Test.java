package www.bit.OOM;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 堆上产生OOM异常
 * -Xms20M设置最小值   -Xmx20M设置最大值
 * 最大最小设置值相等，也就是说内存不够时不允许扩展内存
 */
//class OOMClass{ }
//public class Test {
//    public static void main(String[] args) {
//        List<OOMClass> list=new ArrayList<>();
//        while (true) {
//            list.add(new OOMClass());
//        }
//    }
//}

/**
 * 写一个StackOverFlowError异常
 * -Xss设置为128k
 */
//class TestStack{
//   public int n=1;
//   public void fun(){
//       n++;
//       fun();
//   }
//}
//public class Test{
//    public static void main(String[] args) {
//        TestStack testStack=new TestStack();
//       try {
//           testStack.fun();
//       }catch (Throwable e){
//           e.printStackTrace();
//           System.out.println("栈深度"+testStack.n);
//       }
//    }
//}

//public class Test {
//    public static void main(String [] args){
//        System.out.println(new B().getValue());
////    }
//    static class A{
//        protected int value;
//        public A(int v) {
//            setValue(v); //10
//        }
//        public void setValue(int value){
//            this.value = value;
//        }
//        public int getValue(){
//            try{
//                value++;
//                return value;
//            } catch(Exception e){
//                System.out.println(e.toString());
//            } finally {
//                this.setValue(value);
//                System.out.println(value);
//            }
//            return value;
//        }
//    }
//    static class B extends A{
//        public B() {
//            super(5);
//            setValue(getValue() - 3);
//        }
//        public void setValue(int value){
//            super.setValue(2 * value);
//        }
//    }
//}

public class Test{
    private static Test test;
    public void isAlive(){
        System.out.println("我活着");
    }
    //覆写finalize方法
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method execute");
        test=this;

    }
    public static void main(String[] args) {
        test=new Test();
        test=null;
        System.gc();
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (test!=null){
            test.isAlive();
        }else{
            System.out.println("我死了");
        }
        test=null;
        System.gc();
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (test!=null){
            test.isAlive();
        }else{
            System.out.println("我死了");
        }

    }


}














