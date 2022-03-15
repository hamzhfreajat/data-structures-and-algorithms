package com.stackAndQueue.stack.data;

public class StackNode <T> {
    private T value;
    private StackNode<T> next ;

    public StackNode(T value) {
        this.value = value;
    }



    public StackNode getNext() {
        return next;
    }

    public T getValue() {
        return value;
    }

    public void setNext(StackNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
