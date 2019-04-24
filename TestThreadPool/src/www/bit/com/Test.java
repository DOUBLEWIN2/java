package www.bit.com;

import java.util.concurrent.*;

//自定义一个线程池,实现Runnable接口
//class MyThread implements Runnable{
//    @Override
//    public void run() {
//        for (int i=0;i<10;i++){
//            System.out.println("当前线程"+Thread.currentThread().getName()
//                    +"执行"+i+"次");
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        //实例化对象
//        MyThread myThread=new MyThread();
//        //LinkedBlockingQueue时无界阻塞队列，可以不设置keepAliveTime
//        ExecutorService executorService=new
//                ThreadPoolExecutor(3,6,
//                0, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
//        for (int i=0;i<5;i++){
//            execute只能接收Runnable对象
//            executorService.execute(myThread);
//        }
//        //关闭线程池
//        executorService.shutdown();
//    }
//}

//自定义一个线程池，实现Callable接口，可以有返回值
//class MyThread implements Callable<String> {
//    @Override
//    public  String call() {
//        for (int i=0;i<10;i++){
//            System.out.println("当前线程"+Thread.currentThread().getName()
//                    +"执行"+i+"次");
//        }
//        return "程序执行结束";
//    }
//}
//public class Test {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        //实例化对象
//        MyThread myThread=new MyThread();
//        //LinkedBlockingQueue时无界阻塞队列，可以设置keepAliveTime为0
//        ExecutorService executorService=new
//                ThreadPoolExecutor(3,6,
//                0, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>());
//        for (int i=0;i<5;i++){
//           Future future= executorService.submit(myThread);
//           //调用Future接口的get方法会阻塞线程，直到取得线程执行完毕后的返回值
//            System.out.println(future.get());
//        }
//        //关闭线程池
//        executorService.shutdown();
//    }
//}

//固定大小线程池FixedThreadPool
//class MyThread implements Runnable{
//    @Override
//    public void run() {
//        for (int i=0;i<10;i++){
//            System.out.println("当前线程"+Thread.currentThread().getName()
//                    +"执行"+i+"次");
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        //实例化对象
//        MyThread myThread=new MyThread();
//        //核心线程池大小为3
//        ExecutorService executorService=Executors.newFixedThreadPool(3);
//        for (int i=0;i<5;i++){
//            //execute只能接收Runnable对象
//            executorService.execute(myThread);
//        }
//        //关闭线程池
//        executorService.shutdown();
//    }
//}

//单线程池newSingleThreadExecutor
//class MyThread implements Runnable{
//    @Override
//    public void run() {
//        for (int i=0;i<10;i++){
//            System.out.println("当前线程"+Thread.currentThread().getName()
//                    +"执行"+i+"次");
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        //实例化对象
//        MyThread myThread=new MyThread();
//        ExecutorService executorService=Executors.newSingleThreadExecutor();
//        for (int i=0;i<5;i++){
//            //execute只能接收Runnable对象
//            executorService.execute(myThread);
//        }
//        //关闭线程池
//        executorService.shutdown();
//    }
//}
//缓存线程池
//class MyThread implements Runnable{
//    @Override
//    public void run() {
//        for (int i=0;i<10;i++){
//            System.out.println("当前线程"+Thread.currentThread().getName()
//                    +"执行"+i+"次");
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) throws InterruptedException {
//        //实例化对象
//        MyThread myThread=new MyThread();
//        //当提交任务速度大于线程执行任务的速度，会不停创建新的线程，大小无界
//        ExecutorService executorService=Executors.newCachedThreadPool();
//        for (int i=0;i<10;i++){
//            //execute只能接收Runnable对象
//            executorService.execute(myThread);
//        }
//        //关闭线程池
//        executorService.shutdown();
//    }
//}

//定时器调度池
//class MyThread implements Runnable{
//    @Override
//    public void run() {
//        for (int i=0;i<10;i++){
//            System.out.println("当前线程"+Thread.currentThread().getName()
//                    +"执行"+i+"次");
//        }
//    }
//}
//public class Test {
//    public static void main(String[] args) throws InterruptedException {
//        //实例化对象
//        MyThread myThread=new MyThread();
//
//        ScheduledExecutorService scheduledExecutorService=
//                Executors.newScheduledThreadPool(3);
//        for (int i=0;i<5;i++){
//            //延迟两秒执行
//            //scheduledExecutorService.schedule(myThread,
//             //      2000,TimeUnit.MILLISECONDS);
//            //延迟两秒执行且每隔三秒执行一次
//            scheduledExecutorService.scheduleAtFixedRate(myThread,
//                   2000,3000,TimeUnit.MILLISECONDS);
//        }
//        //关闭线程池
//        scheduledExecutorService.shutdown();
//    }
//}