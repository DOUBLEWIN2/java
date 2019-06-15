package ly.Stack.impl;

import ly.Stack.Stack;

public class LinkedStack<T> implements Stack<T> {
    //栈顶元素
    private Node top;
    private int currentSize;
    private class Node{
        private T t;
        private Node next;
        public Node(T t, Node next) {
            this.t = t;
            this.next = next;
        }
    }
    @Override
    public void push(T t) {
        Node newNode =new Node(t,null);
             if (top==null){
                 top=newNode;
             }else {
                 //头插
                 newNode.next=top;
                 top=newNode;
             }
             currentSize++;
    }

    @Override
    public T pop() {
        if (isEmpty()){
            System.err.println("栈为空");
            return null;
        }
        T result=top.t;
        top=top.next;
        currentSize--;
        return result;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            System.err.println("栈为空。。");
            return null;
        }
        return top.t;
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
