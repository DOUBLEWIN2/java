

public class Test{
    public static void main(String[] args) {
        int[] data=new int[]{4,5,6,1,3,2};
        bubbleSort(data);
        print(data);
       System.out.println();
        insertSort(data);
        print(data);
    }
    //冒泡法排序
    public static void bubbleSort(int[] array){
        int n=array.length;
        //元素之间发生了交换就为true,没有发生就为false
        boolean flag=true;
        if(n<=1){
            return ;
        }else {
            for(int i=0;i<=n-1;i++){
                //设置每一次都是未排序状态
                flag=false;
                //每一次冒泡排序元素之间的两两交换
                for(int j=0;j<n-1-i;j++){
                    if(array[j]>array[j+1]){
                        int temp=array[j+1];
                        array[j+1]=array[j];
                        array[j]=temp;
                        flag=true;
                    }
                }
                //flag为false进入if语句
                if(!flag){
                    break;
                }
            }
        }
    }
    //插入排序法
    public static void insertSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            for(int i=1;i<=n-1;i++){
                int value=array[i];
                int j=i-1;
                for(;j>=0;j--){
                    if(array[j]>value){
                        array[j+1]=array[j];
                    }else {
                        break;
                    }
                }
                //循环进入if结束时j=-1,j+1相当于把一次比较后的最小值放到数组第一个位置
                array[j+1]=value;
            }
        }
    }
    public static void print(int[] array){
        //for-each循环for(数据类型  临时变量名称: 数组名称)
        //输出直接输出临时变量名称
        for(int i:array){
            System.out.print(i+" ");
        }
    }

}









