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
class Solution {
    public int diameter(TreeNode root,int max[]){
        if(root.left == null && root.right == null){
            return 0;
        }
        int left = 0;
        int right = 0;
        if(root.left != null){
            left = 1+diameter(root.left,max);
        }
        if(root.right != null){
            right = 1+diameter(root.right,max);
        }
        max[0] = Math.max(max[0],left+right);
        return Math.max(left,right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int max[] = new int[1];
        int d = diameter(root,max);
        return max[0];
    }
}