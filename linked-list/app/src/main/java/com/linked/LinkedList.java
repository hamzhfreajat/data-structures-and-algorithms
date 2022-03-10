package com.linked;

public class LinkedList<T>{
    Node<T> head ;
    Node<T> tail ;

    public LinkedList(){
        this.head = null;
        this.tail = null;
    }


    public void insert (T value){
        Node<T> newNode =  new Node<>(value);
        newNode.next = this.head;
        if(this.head == null){
            this.tail = newNode;
        }else{
            newNode.next.previous = newNode;
        }
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

    public void append(T value) {
        Node pointer = this.head;
        if (pointer == null){
            insert(value);
        }
        while (pointer != null) {
            if (pointer.next == null) {
                Node newNode = new Node(value);
                pointer.next = newNode;
                newNode.next = null;
                break;
            }
            pointer = pointer.next;
        }
//        Node<T> current = this.tail;
//        Node<T> newNode = new Node<>(value);
//        newNode.previous = current ;
//        current.next = newNode;
//        this.tail = newNode;
    }
    public void insertBefore( T index, T value){
        Node<T> current = this.head;
        if(index == this.head.value){
            insert(value);
        }
        while (current.next != null) {
            Node<T> newNode = new Node<>(value);
            if(current.next.value == index){
                newNode.next = current.next;
                current.next = newNode;
                break;
            }
            current = current.next;

        }
    }

    public void insertAfter( T index, T value){
        Node current = this.head;
        Node newNode = new Node(value);
        if(this.tail.value == index){
            append(value);
        }
        while (current != null) {
            if(current.value == index){
                newNode.next = current.next;
                current.next = newNode;
                break;
            }
            current = current.next;
        }
    }
    public T kthFromEnd(int k){
        int counter = 0 ;
        Node current = this.tail;
        try{
            while (true){
                if (counter == k) return (T) current.value;
                current = current.previous;
                counter++;
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
            return (T) "Element not found";
        }
    }



    @Override
    public String toString() {
        Node pointer = this.head;
        String out = "";
        while (pointer != null){
            out +="{ "+ pointer.value+" } -> ";
            pointer = pointer.next;
        }
        out +="{ NULL }";
        return out;
    }
}
