package ly.Stack.impl;

import ly.Stack.Stack;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {
    private Object[] element;
    //设置最大栈最大容量
    private int maxSize;
    private int currentSize;


    public ArrayStack(int maxSize) {
        this.currentSize=0;
        this.element=new Object[maxSize];
        this.maxSize = maxSize;
    }
    @Override
    public void push(Object data) {
        if (currentSize==maxSize){
            //栈已满，扩容
            int oldSize=maxSize;
            int newSize=oldSize<<1;
            if (newSize>Integer.MAX_VALUE-8){
                throw new IllegalArgumentException("扩容超过最大容量。。。");
            }else {
                element=Arrays.copyOf(element,newSize);
            }
        }
        element[currentSize]=data;
        ++currentSize;
    }
    @Override
    public T pop() {
        if (isEmpty()){
            System.err.println("栈为空。。。");
            return null;
        }else {
            --currentSize;
        }
        return (T)element[currentSize];
    }

    @Override
    public T peek() {
        if (isEmpty()){
            System.err.println("栈为空。。。");
            return null;
        }
        return (T)element[currentSize-1];
    }

    @Override
    public int getSize() {
        return this.currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize==0;
    }
}
