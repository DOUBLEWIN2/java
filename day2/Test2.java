public class Test2{
    public static void main(String[] args){
        for(int i=1 ;i<10;i++){
            for(int j=1 ;j<=i; j++){
                 System.out.print(i+"*"+j+"="+(i*j)+"  ");
            }
            System.out.println();
        }
    }
}

// public class Test2{
//     public static void main(String[] args){
//         long ret=Factorial(20);
//         System.out.println(ret);
//     }
//     public static long Factorial(long num){
//         if(num==1){
//             return 1;
//         }else{
//           return num*Factorial(num-1);
//         }
//     }
// }