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

    public void Append(T value) {
        Node pointer = this.head;
        while (pointer != null) {
            if (pointer.next == null) {
                Node newNode = new Node(value);
                pointer.next = newNode;
                newNode.next = null;
                break;
            }
            pointer = pointer.next;
        }
    }
    public void insertBefore( int index, int value){
        Node current = this.head;
        while (current.next != null) {
            Node newNode = new Node(value);
            int val = (int) current.next.value;
            if(val == index){
                newNode.next = current.next;
                current.next = newNode;
                break;
            }
            current = current.next;

        }
    }

    public void insertAfter( int index, int value){
        Node current = this.head;
        Node newNode = new Node(value);
        while (current != null) {
            int val = (int) current.value;
            if(val == index){
                newNode.next = current.next;
                current.next = newNode;
                break;
            }
            current = current.next;
        }
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
