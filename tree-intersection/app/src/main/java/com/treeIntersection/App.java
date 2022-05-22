/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.treeIntersection;


import com.treeIntersection.data.Node;

import com.treeIntersection.structure.HashMap;
import com.treeIntersection.structure.TreeIntersection;


import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class App {




    public static void main(String[] args) {
        TreeIntersection<Integer> treeIntersection1 = new TreeIntersection<>();
        treeIntersection1.add(15);
        treeIntersection1.add(20);
        treeIntersection1.add(3);
        treeIntersection1.add(4);
        treeIntersection1.add(5);
        treeIntersection1.add(40);


        TreeIntersection<Integer> treeIntersection2 = new TreeIntersection<>();
        treeIntersection2.add(15);
        treeIntersection2.add(20);
        treeIntersection2.add(7);
        treeIntersection2.add(9);
        treeIntersection2.add(40);

        treeIntersection(treeIntersection1 , treeIntersection2);

    }



    public static Set<String> treeIntersection(TreeIntersection<Integer> treeIntersection1 , TreeIntersection<Integer> treeIntersection2 ){
        HashMap<String , Integer> hashtable = new HashMap<>();
        Node<Integer>  root =   treeIntersection1.getRoot();
        Node<Integer>  root2 =   treeIntersection2.getRoot();
        addInOrder(root , hashtable);
        addInOrder(root2 , hashtable);

        return findDuplicate(hashtable);

    }

    private static void addInOrder(Node<Integer> root , HashMap<String , Integer> hashtable) {

        if (root == null) return;
        
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        
        while (current != null || stack.size() > 0)
        {

            while (current !=  null)
            {
                stack.push(current);
                current = current.getLeftNode();
            }

            current = stack.pop();

            if(hashtable.get(current.getData().toString()) == null)
            {
                hashtable.set(current.getData().toString(), 1);
            }
            else
            {
                hashtable.set(current.getData().toString(), hashtable.get(current.getData().toString())+1);
            }

            current = current.getRightNode();
        }

    }




    private static Set<String> findDuplicate(HashMap<String , Integer> hashMap){
        Set<String> set = hashMap.findDuplicate();
        return set ;
    }



}