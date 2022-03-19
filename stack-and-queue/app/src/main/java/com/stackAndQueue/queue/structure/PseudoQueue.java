package com.stackAndQueue.queue.structure;

import com.stackAndQueue.queue.data.QueueNode;
import com.stackAndQueue.stack.data.StackNode;
import com.stackAndQueue.stack.structure.Stack;

import java.util.NoSuchElementException;

public class PseudoQueue<T> implements queueInterface<T>{
    private QueueNode<T> front;
    private QueueNode<T> back ;
    Stack<T> stack1 ;
    Stack<T> stack2 ;

    public PseudoQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public T dequeue(){
        stack2 = reverceStack(stack1);
        System.out.println(stack2);
        stack2.pop();
        stack1 = reverceStack(stack2);
        return stack2.peek();
    }

    public T enqueue(T value){
       stack1.push(value);
        return stack1.peek();
    }

    private Stack<T> reverceStack(Stack<T> stack){
        Stack<T> reverseStack = new Stack<>();
        StackNode<T> current = stack.getTop();
        while (current != null){
            reverseStack.push(current.getValue());
            current = current.getNext();
        }
        return reverseStack;
    }

    public boolean empty(){
        return front == null ;
    }


}
