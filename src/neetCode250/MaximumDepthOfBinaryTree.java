package neetCode250;
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

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root){
        // root is empty / null
        if (root == null){
            return 0;
        }

        // need to calculate going down the left and right path of the tree
        int leftPathDepth = maxDepth(root.left);
        int rightPathDepth = maxDepth(root.right);

        // see which path is longer / yields more ( we don't need to know the path just the depth)
        int maxOfLeftAndRight = Math.max(leftPathDepth, rightPathDepth);

        return maxOfLeftAndRight + 1;
    }
}
