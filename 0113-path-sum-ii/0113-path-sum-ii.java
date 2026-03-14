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
    public void path(TreeNode root,int sum,int target,List<Integer> list,List<List<Integer>> list1){
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.left == null && root.right == null && sum+root.val == target){
            list1.add(new ArrayList<>(list));
        }
        path(root.left,sum+root.val,target,list,list1);
        path(root.right,sum+root.val,target,list,list1);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> list1 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        path(root,0,target,list,list1);
        return list1;
    }
}