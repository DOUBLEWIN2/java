// //Java数组章节练习题
public class Test1{
    public static void main(String[] args){
    int[] data = new int[]{10,5,34,7,10};
    int[] data1 =new int[]{1,2,3};
    int max=arrayMaxElement(data);
    System.out.println(max);
    int min=arrayMinElement(data);
    System.out.println(min);
    int sum=arrayElementSum(data);
    System.out.println(sum);
    int[] c=arrayJoin(data,data1);
    printArray(c);
    int[] sub=arraySub(data,1,3);
    printArray(sub);
    printReversal(data);
    }
//     //1.计算数组中最大值
    public static int arrayMaxElement(int[] arr){
          //TODO 
          int max=arr[0];
         for(int i =0;i < arr.length;i++){
            if(max <= arr[i]){ 
               max = arr[i];
            }
        }
        return max;
    }
//     //2.计算数组中最小值
    public static int arrayMinElement(int[] a){
//         //TODO
          int min=a[0];
          for(int i=0;i<a.length;i++){
              if(min>=a[i]){
                  min=a[i];
              }
          }
          return min;
        }
//     //3.计算数组值之和
 public static int arrayElementSum(int[] b){
//         //TODO 
      int sum=0;
      for(int i=0;i<b.length;i++){
          sum += b[i];
      }
      return sum;
    }

//     //4.数组拼接
//     // A {1,3,5,7,9} B {2,4,6,8,10} -> {1,3,5,7,9,2,4,6,8,10}
public static int[] arrayJoin(int[] a, int[] b){
//         //TODO
      int[] c=new int[a.length+b.length];
      for(int i=0;i<a.length;i++){
          c[i]=a[i];
      }
      for(int i=0;i<b.length;i++){
          c[a.length+i]=b[i];
      }
      return c;
    }

//     //5.数组截取
//     //[start, end)
//     // A {1,3,5,7,9} ->(A,1,3) > {3,5}
    public static int[] arraySub(int[] data, int start , int end){
//         //TODO
       int[] sub=new int[end-start];
       int j=0;
     for(int i=start;i<end;i++){
        sub[j]=data[i];
        j++;
     }
     return sub;
    }


        
//     }
    
//     //6.数组打印
  public static void printArray(int[] d){
//         //TODO
       for(int i=0;i<d.length;i++){
          System.out.print(d[i]+",");
        }
        System.out.println();
    }

//     //7.数组反转
//     // 比如：[1,2,3,4] => [4,3,2,1]
     public static void printReversal(int[] data2){
//         //TODO
      int left=0;
      int right=data2.length-1;
      while(left<right){
          int temp=0;
          temp=data2[left];
          data2[left]=data2[right];
          data2[right]=temp;
          left++;
          right--;
      }
      for(int i=0;i<data2.length;i++){
          System.out.print(data2[i]+",");
      }
      System.out.println();
    }
}
    