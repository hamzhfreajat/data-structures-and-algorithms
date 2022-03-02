package com.linked;

public class LinkedList<T>{
    Node head ;

    public LinkedList(){
        this.head = null;
    }


    public void insert (T value){
        Node newNode =  new Node(value);
        newNode.next = this.head;
        this.head = newNode;
    }

    public boolean include(T value){
        Node pointer = this.head;
        Boolean bol = false;
        while (pointer != null){
            if (pointer.value == value) {
                bol = true;
                break;
            }
           pointer = pointer.next;
        }
        return bol;
    }


    @Override
    public String toString() {
        Node pointer = this.head;
        String out = "";
        while (pointer != null){
            System.out.println(pointer.value);
            out +="{ "+ pointer.value+" } -> ";
            pointer = pointer.next;
        }
        out +="{ NULL }";
        return out;
    }
}
