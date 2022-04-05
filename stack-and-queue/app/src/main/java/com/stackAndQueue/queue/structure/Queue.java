package com.stackAndQueue.queue.structure;

import com.stackAndQueue.queue.data.QueueNode;

import java.util.NoSuchElementException;


public class Queue<T> {
    private QueueNode<T> front;
    private QueueNode<T> back ;
    private int size = 0;

    public Queue() {
    }

    public int getSize() {
        return size;
    }

    public QueueNode<T> enqueue(T value){
        QueueNode<T> newQueueNode = new QueueNode<>(value);
        size++;
        if(empty()){
            front = back = newQueueNode;
        }else {
            back.setNext(newQueueNode);
            back = newQueueNode;
        }
        return newQueueNode;
    }

    public QueueNode<T> dequeue(){
        QueueNode<T> removed;
        size--;
        if (empty()){
            throw new NoSuchElementException("The Queue is empty");
        }else{
            removed = front;
            front = front.getNext();
        }
        return removed;
    }

    public T peek(){
        if (empty()){
            throw new NoSuchElementException("The Queue is empty");
        }
        return front.getValue();
    }


    public boolean empty(){
        return front == null ;
    }

    @Override
    public String toString() {
        QueueNode<T> pointer = front;
        String out = "";
        while (pointer != null){
            out +="{ "+ pointer.getValue()+" } -> ";
            pointer = pointer.getNext();
        }
        out +="{ NULL }";
        return out;
    }

}
