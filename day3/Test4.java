// 1.创建一个Test类，包含有一个public权限的int型成员变量与一个char类型的成员变量，观察在main方法中的初始值。

// class Test{
//     public int i;
//     public char c;
//     public void getTest(){
//         System.out.println("整型变量: "+i+"\t"+"字符型变量: "+c);
//     }
// }
// public class Test4{
//     public static void main(String[] args){
//         Test test = new Test();
//         test.getTest();                                                                                                                                
//     }
// }

// 2.编写一个程序，展示无论你创建了某个特定类的多少个对象，这个类的某个特定的static成员变量只有一个属性。 

// class Person{
//     public String name;
//     public int age;
//     public static String country;
// }
// public class Test4{
//     public static void main(String[] args){
//         Person per1 = new Person();
//         per1.name = "张三";
//         per1.age = 18;
//         per1.country = "中国";
//         Person per2 = new Person();
//         per2.name = "李四";
//         per2.age = 20;
//         per2.country = "韩国";
//         //韩国为全局数据区
//         System.out.println(per1.name+"\t"+per1.age+"\t"+per1.country);
//         System.out.println(per2.name+"\t"+per2.age+"\t"+per2.country);
//     } 
// }


// 3.一个斐波那契数列是由数字1、1、2、3、5、8、13、21、34等等组成的，
// 其中每一个数字(从第三个数字起)都是前两个数字的和。创建一个方法，接受一个整数参数，
// 并显示从第一个元素开始总共由该参数指定的个数所构成的所有斐波那契数字。
// 例如，如果运行 java Fibonacci 5(Fibonacci为类名)，那么输出应该是1、1、2、3、5。 

// class Fibonacci{
//     public static int Fibonacci(int n){
//         if(n<3){
//             return 1;
//         }else{
//             return Fibonacci(n-1)+Fibonacci(n-2);
//         }
//     }
// }
// public class Test4{
//     public static void main(String[] args){
//         int i = 6;
//         Fibonacci fib  = new Fibonacci();
//         for(i=1;i<=6;i++){
//             System.out.print(fib.Fibonacci(i));
//             System.out.print("  ");
//         }
       
//     }
// }
// 4.创建一个带默认构造方法（即无参构造）的类，
// 在构造方法中打印一条消息"Hello Constructor";
// 再为这个类添加一个重载构造方法，令其接收一个字符串参数,
// 并在这个有参构造方法中把"Hello Constructor"和接收的参数一起打印出来。 

class Test{
    public Test(){   //无参构造<1>
        System.out.println("Hello Constructor");
    }
    public Test(String name){
        this();//调用本类无参构造<1>
        System.out.println(name);
    }
}
public class Test4{
    public static void main(String[] args){
        Test test = new Test("张三");
        
    }
}