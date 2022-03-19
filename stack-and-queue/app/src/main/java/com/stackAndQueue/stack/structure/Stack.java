package com.stackAndQueue.stack.structure;

import com.stackAndQueue.stack.data.StackNode;

import java.util.NoSuchElementException;

public class Stack <T>{
    private StackNode<T> top;

    public Stack() {
        this.top = null;
    }

    public StackNode<T> getTop() {
        return top;
    }

    public StackNode<T> push(T value){
        StackNode<T> newStackNode = new StackNode<>(value);
        if(empty()){
            top = newStackNode;
        }else {
          newStackNode.setNext(top);
          top = newStackNode;
        }
        return newStackNode;
    }

    public boolean empty(){
        return top == null;
    }

    public T peek(){
        if (empty()){
            throw new NoSuchElementException("The Stack is empty");
        }
        return top.getValue();
    }

    public StackNode<T> pop(){
        if (empty()){
          throw new NoSuchElementException("The Stack is empty");
        }
        StackNode<T> removed = top;
        top = top.getNext();
        removed = null;
        return top;
    }

    @Override
        public String toString() {
            StackNode<T> pointer = top;
            String out = "";
            while (pointer != null){
                out +="{ "+ pointer.getValue()+" } -> ";
                pointer = pointer.getNext();
            }
            out +="{ NULL }";
            return out;
        }
}
