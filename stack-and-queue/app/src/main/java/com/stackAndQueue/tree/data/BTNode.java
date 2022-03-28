package com.stackAndQueue.tree.data;

public class BTNode<T> {

    private T data;

    private BTNode left;
    private BTNode right;

    public BTNode(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
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