package com.stackAndQueue.tree.data;

public class BTNode<T> {

    private int data;

    private BTNode<T> left;
    private BTNode<T> right;

    public BTNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public BTNode<T> getLeft() {
        return left;
    }

    public void setLeft(BTNode<T> left) {
        this.left = left;
    }

    public BTNode<T> getRight() {
        return right;
    }

    public void setRight(BTNode<T> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "BTNode{" +
                "data=" + data +
                ", left=" + left +
                ", right=" + right +
                '}';
    }


}