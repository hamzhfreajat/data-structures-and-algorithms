package com.stackAndQueue.queue.structure;

import com.stackAndQueue.queue.data.QueueNode;

import java.util.NoSuchElementException;

public class AnimalShelter<T> {
    private QueueNode<Animal> front;
    private QueueNode<Animal> back ;


    public QueueNode<Animal> enqueue(Animal value){
        QueueNode<Animal> newQueueNode = new QueueNode<>(value);
        if(empty()){
            front = back = newQueueNode;
        }else {
            back.setNext(newQueueNode);
            back = newQueueNode;
        }
        return newQueueNode;
    }

    public QueueNode<Animal> dequeue(String pref){
        QueueNode<Animal> current1 = front;
        QueueNode<Animal> current2 = front;
        QueueNode<Animal> removed = null;
        int counter = 0 ;

        if (empty()){
            throw new NoSuchElementException("The Queue is empty");
        }else{
            while (current1 != null){

                if (current1.getNext() != null){
                    if(String.valueOf(current1.getNext().getValue()) == pref){
                        current2 = current2.getNext();
                        current1.setNext(current2.getNext());
                        current2.setNext(null);
                        counter++;
                        break;
                    }
                }else{
                    front = front.getNext();

                }

                current1 = current1.getNext();
                current2 = current2.getNext();
            }
            removed = front;
            if(counter == 0) return null;

        }
        return removed;
    }

    public boolean empty(){
        return front == null ;
    }


    @Override
    public String toString() {
        QueueNode<Animal> pointer = front;
        String out = "";
        while (pointer != null){
            out +="{ "+ pointer.getValue()+" } -> ";
            pointer = pointer.getNext();
        }
        out +="{ NULL }";
        return out;
    }
}
