package neetCode250;
/*
 * Invert a Binary Tree
Solved

You are given the root of a binary tree root. Invert the binary tree and return its root.

Example 1:

Input: root = [1,2,3,4,5,6,7]

Output: [1,3,2,7,6,5,4]

Example 2:

Input: root = [3,2,1]

Output: [3,1,2]

 */

public class InvertaBinaryTree {
    public TreeNode invertTree(TreeNode root) {

        if (root == null){
            return root;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
