package com.stackAndQueue.tree.structure;

import com.stackAndQueue.queue.structure.Queue;
import com.stackAndQueue.tree.data.BTNode;
import com.stackAndQueue.tree.data.Node;

import java.util.ArrayList;

public class BinaryTree<T extends Comparable<T>> {
    public enum TraversalOrder {
        INORDER,
        PREORDER,
        POSTORDER
    }
    private BTNode root;
    private ArrayList<T> arrayList;

    public BTNode getRoot() {
        return root;
    }

    public void setRoot(BTNode root) {
        this.root = root;
    }
    public ArrayList traverse(BinaryTree.TraversalOrder order) {
        arrayList = new ArrayList<>();
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
        return arrayList;
    }


    ArrayList inOrder(BTNode<T> root)
    {
        if (root == null)
            return arrayList;

        inOrder(root.getLeft());
        arrayList.add(root.getData());
        inOrder(root.getRight());
        return null;
    }


    ArrayList<T> preOrder(BTNode<T> root)
    {
        if (root == null)
            return arrayList;

        arrayList.add(root.getData());
        preOrder(root.getLeft());
        preOrder(root.getRight());
        return null;
    }

    ArrayList<T> postOrder(BTNode<T> root)
    {
        if (root == null)
            return arrayList;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        arrayList.add(root.getData());
        return null;
    }



    public void levelOrderTraversalLoop() {
        if (root != null) {
            Queue<BTNode> queue = new Queue<>();
            queue.enqueue(root);
            BTNode node;
            while (!queue.empty()) {
                node = queue.peek();
                queue.dequeue();
                System.out.print(node.getData() + " => ");
                if (node.getLeft() != null) {
                    queue.enqueue(node.getLeft());
                }

                if (node.getRight() != null) {
                    queue.enqueue(node.getRight());
                }
            }
        } else {
            System.out.println("Tree empty");
        }
    }



//    public void levelOrderTraversalRecursive() {
//        if (root != null) {
//            Queue<BTNode> queue = new Queue<>();
//            queue.enqueue(root);
//            levelOrderTraversalRecursive(queue);
//        } else {
//            System.out.println("Tree is empty");
//        }
//    }


}