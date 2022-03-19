package com.stackAndQueue.queue.structure;

import com.stackAndQueue.queue.data.QueueNode;
import com.stackAndQueue.stack.data.StackNode;
import com.stackAndQueue.stack.structure.Stack;

public interface  queueInterface<T> {
    public T dequeue();
    public T enqueue(T value);
}
