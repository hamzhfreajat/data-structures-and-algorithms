package com.stackAndQueue.tree.structure;

import com.stackAndQueue.queue.structure.Queue;
import com.stackAndQueue.tree.data.BTNode;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class BinaryTree<T extends Comparable<T>> {
    public enum TraversalOrder {
        INORDER,
        PREORDER,
        POSTORDER
    }
    private BTNode root;
    private ArrayList<Integer> arrayList;

    public BTNode getRoot() {
        return root;
    }

    public void setRoot(BTNode root) {
        this.root = root;
    }
    public ArrayList traverse(BinaryTree.TraversalOrder order) {
        arrayList = new ArrayList<Integer>();
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

    // Helping by https://www.geeksforgeeks.org/find-maximum-or-minimum-in-binary-tree/
    public int findMax(BTNode<Integer> node)
    {
        if (node == null)
            return 0;

        int max = node.getData();
        int leftResult = findMax(node.getLeft());
        int rightResult = findMax(node.getRight());

        if (leftResult > max)
            max = leftResult;

        if (rightResult > max)
            max = rightResult;

        return max;
    }



    ArrayList<Integer> inOrder(BTNode<T> root)
    {
        if (root == null)
            return arrayList;

        inOrder(root.getLeft());
        arrayList.add(root.getData());
        inOrder(root.getRight());
        return null;
    }


    ArrayList<Integer> preOrder(BTNode<T> root)
    {
        if (root == null)
            return arrayList;

        arrayList.add(root.getData());
        preOrder(root.getLeft());
        preOrder(root.getRight());
        return null;
    }

    ArrayList<Integer> postOrder(BTNode<T> root)
    {
        if (root == null)
            return arrayList;
        postOrder(root.getLeft());
        postOrder(root.getRight());
        arrayList.add(root.getData());
        return null;
    }



   public ArrayList<Integer> treeBreadthFirst() {
        ArrayList<Integer> arrayList= new ArrayList<>();
        if (root != null) {
            Queue<BTNode> queue = new Queue<>();
            queue.enqueue(root);
            BTNode node;
            while (!queue.empty()) {
                node = queue.peek();
                queue.dequeue();
                arrayList.add(node.getData());
                if (node.getLeft() != null) {
                    queue.enqueue(node.getLeft());
                }

                if (node.getRight() != null) {
                    queue.enqueue(node.getRight());
                }
            }
        } else {
            throw new NoSuchElementException("The BT is empty");
        }
        return arrayList;
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