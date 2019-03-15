
//interface InterfaceA {
//        String S = "good ";
//        void f();
//        }
//
//abstract class ClassA {
//    abstract void g();
//}
//
//class ClassB extends ClassA implements InterfaceA {
//    //抽象类可以用implements实现接口
//    void g() {
//        System.out.print(S);
//    }
//
//    public void f() {
//        System.out.print(" "+ S);
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        ClassA a = new ClassB();
//        InterfaceA b = new ClassB();
//        a.g();
//        b.f();
//    }
//}
//good good

//2.编程题:
//        利用接口做参数，写个计算器，能完成加减乘除运算。
//        （1）定义一个接口Compute含有一个方法int computer(int n, int m)。
//        （2）设计四个类分别实现此接口，完成加减乘除运算。
//        （3）设计一个类UseCompute，类中含有方法：
//             public void useCom(Compute com, int one, int two)，
//            此方法能够用传递过来的对象调用computer方法完成运算，
//            并输出运算的结果。
//        （4）设计一个主类Test，调用UseCompute中的方法useCom来完成加减乘除运算。
//interface Compute{
//    int computer(int n,int m);
//}
//class Add implements Compute{
//    public int computer(int n,int m){
//        return  n+m;
//    }
//}
//class Sub implements Compute{
//    public int computer(int n,int m){
//        return n-m;
//    }
//}
//class Mul implements Compute{
//    @Override
//    public int computer(int n, int m) {
//        return m*n;
//    }
//}
//class Division implements Compute{
//    @Override
//    public int computer(int n, int m) {
//        return n/m;
//    }
//}
//class UseCompute {
//    //Compute com是父接口对象,通过子类向上转型得到
//    public void useCom(Compute com, int one, int two) {
//        System.out.println(com.computer(one,two));
//    }
//}
//
//public class Test{
//    public static void main(String[] args) {
//        Add add=new Add();
//        Sub sub =new Sub();
//        Mul mul =new Mul();
//        Division division=new Division();
//        UseCompute use =new UseCompute();
//              use.useCom(add,20,10);
//              use.useCom(sub,20,10);
//              use.useCom(mul,20,10);
//              use.useCom(division,20,10);
//        }
//
//    }

//        3.按如下要求编写Java程序：
//        （1）定义接口A，里面包含值为3.14的常量PI和抽象方法double area()。
//        （2）定义接口B，里面包含抽象方法void setColor(String c)。
//        （3）定义接口C，该接口继承了接口A和B，里面包含抽象方法void volume()。
//        （4）定义圆柱体类Cylinder实现接口C，该类中包含三个成员变量：底圆半径radius、
//        圆柱体的高height、颜色color。
//        （5）创建主类来测试类Cylinder。

//接口中abstract,public,final,static均可以省略
//interface A{
//    double PI=3.14;
//    double area();
//}
//interface B{
//    void setColor(String c);
//}
//interface C extends A,B{
//    void volume();
//}
//class Cylinder implements C{
//    private double radius=5;
//    private double height=6;
//    private String color;
//    public double area(){
//        return PI*radius*radius;
//    }
//
//    @Override
//    public void setColor(String color) {
//        this.color = color;
//    }
//
//    @Override
//    public void volume() {
//        System.out.println(PI*radius*radius*height);
//    }
//
//    public double getHeight() {
//        return height;
//    }
//
//    public double getRadius() {
//        return radius;
//    }
//
//    public void setRadius(double radius) {
//        this.radius = radius;
//    }
//
//    public void setHeight(double height) {
//        this.height = height;
//    }
//
//    public String getColor() {
//        return color;
//    }
//
//}
//public class Test{
//    public static void main(String[] args) {
//        Cylinder cylinder=new Cylinder();
//        cylinder.setColor("红");
//        System.out.println(cylinder.getColor());
//        System.out.println(cylinder.area());
//        cylinder.volume();
//    }
//}
//
//        5.(附加题-算法)
//        一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。
//        例如6=1＋2＋3.编程 找出1000以内的所有完数。
//完数除自身以外的因子
public class Test{
    public static void main(String[] args) {
        int i=1;
        for(;i<=1000;i++){
             if(isWanShu(i)){
                 System.out.println(i);
             }
        }
    }
    public static boolean isWanShu(int i) {
        int sum=0;
        if (i < 0 && i > 1000) {
            return false;
        } else {
            for (int n = i; n >1 ; n--) {
              if(i%n==0){
                   sum += i/n;
              }
            }
        }
            if(i==sum){
                return true;
            }else{
                return false;
            }
        }
    }



