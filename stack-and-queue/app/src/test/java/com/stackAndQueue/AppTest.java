/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.stackAndQueue;

import com.stackAndQueue.queue.data.QueueNode;
import com.stackAndQueue.queue.structure.PseudoQueue;
import com.stackAndQueue.queue.structure.Queue;
import com.stackAndQueue.stack.data.StackNode;
import com.stackAndQueue.stack.structure.Stack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    @Test
    public void pushIntoStack(){
        Stack<Integer> stack = new Stack<>();
        String actual = String.valueOf(stack.push(5));
        StackNode<Integer> newNode = new StackNode<>(5);
        String expected = String.valueOf(newNode);
        assertEquals(expected , actual);
    }
    @Test
    public void pushMultipleIntoStack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        String actual = String.valueOf(stack);
        String exp = "{ 3 } -> { 2 } -> { 1 } -> { NULL }";
        assertEquals(exp , actual);
    }

    @Test
    public void popOffStack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.out.println(stack);
        String actual = String.valueOf(stack);
        String exp = "{ 2 } -> { 1 } -> { NULL }";
        assertEquals(exp , actual);
    }
    @Test
    public void popEmptyStack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack);
        String actual = String.valueOf(stack);
        String exp = "{ NULL }";
        assertEquals(exp , actual);
    }
    @Test
    public void peekFromStack(){
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        int exp = 3 ;
        int actual = stack.peek();
        assertEquals(exp , actual);
    }

    @Test
    public void nullStack(){
        Stack<Integer> stack = new Stack<>();
        String exp = "{ NULL }";
        String actual = String.valueOf(stack);
        assertEquals(exp , actual);
    }

    @Test
    public void ExepPopStack(){

        Stack<Integer> stack = new Stack<>();
        Exception exception = assertThrows(Exception.class, () -> {
            stack.pop();
        });
        String exp = "The Stack is empty";
        String actual = exception.getMessage();
        assertEquals(exp , actual);
    }

    @Test
    public void ExepPeekStack(){
        Stack<Integer> stack = new Stack<>();
        Exception exception = assertThrows(Exception.class, () -> {
            stack.peek();
        });
        String exp = "The Stack is empty";
        String actual = exception.getMessage();
        assertEquals(exp , actual);
    }

    @Test
    public void pushIntoQueue(){
        Queue<Integer> queue = new Queue<>();
        String actual = String.valueOf(queue.enqueue(5));
        QueueNode<Integer> newNode = new QueueNode<>(5);
        String expected = String.valueOf(newNode);
        assertEquals(expected , actual);
    }
    @Test
    public void enqueueMultipleIntoQueue(){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        String actual = String.valueOf(queue);
        String exp = "{ 1 } -> { 2 } -> { 3 } -> { NULL }";
        assertEquals(exp , actual);
    }

    @Test
    public void dequeueOffQueue(){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        String actual = String.valueOf(queue);
        String exp = "{ 2 } -> { 3 } -> { NULL }";
        assertEquals(exp , actual);
    }
    @Test
    public void dequeueEmptyQueue(){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        String actual = String.valueOf(queue);
        String exp = "{ NULL }";
        assertEquals(exp , actual);
    }
    @Test
    public void peekFromQueue(){
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.peek());
        int exp = 1 ;
        int actual = queue.peek();
        assertEquals(exp , actual);
    }

    @Test
    public void nullQueue(){
        Queue<Integer> queue = new Queue<>();
        String exp = "{ NULL }";
        String actual = String.valueOf(queue);
        assertEquals(exp , actual);
    }

    @Test
    public void ExepdequeueQueue(){
        Queue<Integer> queue = new Queue<>();
        Exception exception = assertThrows(Exception.class, () -> {
            queue.dequeue();
        });
        String exp = "The Queue is empty";
        String actual = exception.getMessage();
        assertEquals(exp , actual);
    }

    @Test
    public void ExepPeekQueue(){
        Queue<Integer> queue = new Queue<>();
        Exception exception = assertThrows(Exception.class, () -> {
            queue.peek();
        });
        String exp = "The Queue is empty";
        String actual = exception.getMessage();
        assertEquals(exp , actual);
    }


    // Code challenge  11

    @Test
    public void happyPathTest (){
        PseudoQueue<Integer> queue  = new PseudoQueue<>();
        assertEquals(1 , queue.enqueue(1));
    }

    @Test
    public void expectedFailureTest(){
        PseudoQueue<Integer> queue  = new PseudoQueue<>();
        Exception exception = assertThrows(Exception.class, () -> {
            queue.dequeue();
        });
        String exep = exception.getMessage();
        assertEquals( "The Stack is empty",exep);
    }
    @Test
    public void edgeCaseTest(){
        PseudoQueue<Integer> queue  = new PseudoQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(4);
        assertEquals( 3, queue.dequeue());
    }


}
