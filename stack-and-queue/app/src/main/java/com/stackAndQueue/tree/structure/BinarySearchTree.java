package com.stackAndQueue.tree.structure;

import com.stackAndQueue.tree.data.BinaryNode;
import com.stackAndQueue.tree.data.Node;

public class BinarySearchTree<T extends Comparable<T>> {

    public enum TraversalOrder {
        INORDER,
        PREORDER,
        POSTORDER
    }

    private Node<T> root;

    public Node<T> getRoot() {
        return root;
    }

    private int size;

    public void add(T data) {
        if (isTreeEmpty()) {
            root = new BinaryNode<>(data);
            size++;
        } else {
            add(data, root);
        }
    }

    private void add(T data, Node<T> root) {
       if (data.compareTo(root.getData())< 0 ){
           if (root.getLeftNode() != null){
               add(data , root.getLeftNode());
           }else {
               Node<T> newNode = new BinaryNode<>(data);
               root.setLeftNode(newNode);
               size++;
           }
       } else if (data.compareTo(root.getData())> 0){
           if (root.getRightNode() != null){
               add(data , root.getRightNode());
           }else {
               Node<T> newNode = new BinaryNode<>(data);
               root.setRightNode(newNode);
               size++;
           }
       }
    }

    public void traverse(TraversalOrder order) {
        switch (order) {
            case INORDER:
                inOrder(root);
                break;
            case PREORDER:
                preOrder(root);
                break;
            case POSTORDER:
                postOrder(root);
                break;
            default:
        }
    }

    private void inOrder(Node<T> treeNode) {
        if (treeNode == null) { // base case
            return;
        }

        inOrder(treeNode.getLeftNode()); // left

        printNode(treeNode); // root

        inOrder(treeNode.getRightNode()); // right
    }

    private void preOrder(Node<T> treeNode) {
        if (treeNode == null) {
            return;
        }

        printNode(treeNode);

        preOrder(treeNode.getLeftNode());

        preOrder(treeNode.getRightNode());
    }

    private void postOrder(Node<T> treeNode) {
        if (treeNode == null) {
            return;
        }

        postOrder(treeNode.getLeftNode());

        postOrder(treeNode.getRightNode());

        printNode(treeNode);
    }

    private void printNode(Node<T> node) {
        System.out.println(node.getData());
    }

    public int size() {
        return size;
    }

    public boolean isTreeEmpty() {
        return root == null;
    }

    public boolean contains(T searchTerm) {
        root = containsHelper(searchTerm , root);
        if (root!= null)
            return true;
        else
            return false;
    }

    private Node containsHelper(T searchTerm, Node<T> root) {

        if (root==null || searchTerm.compareTo(root.getData()) == 0)
            return root;
        if (searchTerm.compareTo(root.getData()) <  0 )
            return containsHelper(searchTerm , root.getLeftNode());

        return containsHelper(searchTerm , root.getRightNode());
    }


}