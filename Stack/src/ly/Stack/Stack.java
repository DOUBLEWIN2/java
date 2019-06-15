package ly.Stack;

public interface Stack <T> {
    //入栈
    void push(T t);
    //出栈
    T pop();
    //返回栈顶元素
    T peek();
    //返回当前栈中元素的个数
    int getSize();
    //判断栈中是否有元素
    boolean isEmpty();
}
