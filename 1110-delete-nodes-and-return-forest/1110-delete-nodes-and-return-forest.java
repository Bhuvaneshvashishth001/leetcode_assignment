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
    public void helper(TreeNode root,TreeNode par,HashSet<TreeNode> list,HashSet<Integer> set){
        if(root == null){
            return;
        }
        helper(root.left,root,list,set);
        helper(root.right,root,list,set);
        if(set.contains(root.val)){
            list.remove(root);
            if(root.left!=null){
                list.add(root.left);
            }
            if(root.right!=null){
                list.add(root.right);
            }
            if(par != null){
                if(par.left == root){
                    par.left = null;
                } 
                if(par.right == root){
                    par.right = null;
                }
            }
        }
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<TreeNode> list = new HashSet<>();
        list.add(root);
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<to_delete.length;i++){
            set.add(to_delete[i]);
        }
        helper(root,null,list,set);
        return new ArrayList<>(list);
    }
}