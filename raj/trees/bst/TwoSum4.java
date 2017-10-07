/**
 *
 */
package com.raj.trees.bst;

import java.util.Deque;
import java.util.LinkedList;

import com.raj.nodes.BinaryTreeNode;

/**
 * @author Raj
 * 
 * Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
Example 2:
Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
 */
public class TwoSum4 {

    public boolean checkPairWithSumK(BinaryTreeNode<Integer> root, int k) {
        if (null == root) {
            return false;
        }

        Deque<BinaryTreeNode<Integer>> stack1 = new LinkedList<>();
        Deque<BinaryTreeNode<Integer>> stack2 = new LinkedList<>();

        BinaryTreeNode<Integer> temp1 = root, temp2 = root;
        BinaryTreeNode<Integer> pop1 = null, pop2 = null;

        while (true) {
            if (temp1 != null || temp2 != null) {
                if (temp1 != null) {
                    stack1.push(temp1);
                    temp1 = temp1.left;
                }
                if (temp2 != null) {
                    stack2.push(temp2);
                    temp2 = temp2.right;
                }
            } else {
                if (stack1.isEmpty() || stack2.isEmpty()) {
                    return false;
                }

                pop1 = stack1.pop();
                pop2 = stack2.pop();
                if (pop1 == pop2) {
                    return false;
                }
                if (pop1.data + pop2.data > k) {
                    temp2 = pop2.left;
                    stack1.push(pop1);
                } else if (pop1.data + pop2.data < k) {
                    temp1 = pop1.right;
                    stack2.push(pop2);
                } else {
                    return true;
                }
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = tree.insert(tree.root, 15);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 16);
        tree.root = tree.insert(tree.root, 25);
        tree.inOrder(tree.root);
        System.out.println();
        TwoSum4 obj = new TwoSum4();

        int k = 26;
        boolean res = obj.checkPairWithSumK(tree.root, k);
        System.out.println(res);

        res = obj.checkPairWithSumK(tree.root, 16);
        System.out.println(res);
    }

}