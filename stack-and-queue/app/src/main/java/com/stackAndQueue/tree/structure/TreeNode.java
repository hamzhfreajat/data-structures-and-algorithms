package com.stackAndQueue.tree.structure;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public List<TreeNode> children = new LinkedList<>();

    public TreeNode(int data){
        val = data;
    }

    TreeNode(int data,List<TreeNode> child){
        val = data;
        children = child;
    }
}
