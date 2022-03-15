package com.stackAndQueue.queue.data;

public class QueueNode <T>{
    private T value;
    private QueueNode<T> next ;

    public QueueNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public QueueNode<T> getNext() {
        return next;
    }

    public void setNext(QueueNode<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "QueueNode{" +
                "value=" + value +
                ", next=" + next +
                '}';
    }
}
