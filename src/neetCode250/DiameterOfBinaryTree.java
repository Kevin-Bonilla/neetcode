package neetCode250;
/*
Diameter of Binary Tree

The diameter of a binary tree is defined as the length of the longest path between any two nodes within the tree. The path does not necessarily have to pass through the root.

The length of a path between two nodes in a binary tree is the number of edges between the nodes. Note that the path can not include the same node twice.

Given the root of a binary tree root, return the diameter of the tree.

Example 1:

Input: root = [1,null,2,3,4,5]

Output: 3

Explanation: 3 is the length of the path [1,2,3,5] or [5,3,2,4].

Example 2:

Input: root = [1,2,3]

Output: 2

Constraints:

    1 <= number of nodes in the tree <= 100
    -100 <= Node.val <= 100

 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */


public class DiameterOfBinaryTree {
    // we are essentially counting how many edges are in the tree
    private int diameter = 0;

    public int depth(TreeNode root){
        //base case will be when the root is null
        if (root == null){
            return 0;
        }

        // need to find left depth and right depth and find the max of them both
        // do this by recusrively calling depth() for root.left and root.right
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);

        int maxDepth = Math.max(leftDepth, rightDepth);

        //find the max of both maxdepth and diameter
        // leftDepth + rightDepth (because each depth counts nodes, the edges = nodesLeft + nodesRight)
        diameter = Math.max(diameter, leftDepth + rightDepth);

        // + 1 bc we are counting our own current node
        return maxDepth + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        depth(root);
        return diameter;
    }
}
