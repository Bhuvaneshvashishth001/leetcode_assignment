class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null && subRoot != null){
            return false;
        }
        if(root != null && subRoot == null){
            return false;
        }
        if(root.val == subRoot.val){
            boolean check = isSame(root, subRoot);
            if(check) return true;
        }
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }
    public boolean isSame(TreeNode root, TreeNode subRoot){
        if(root == null && subRoot == null){
            return true;
        }
        if(root == null && subRoot != null){
            return false;
        }
        if(root != null && subRoot == null){
            return false;
        }
        if(root.val != subRoot.val){
            return false;
        }
        boolean left = isSame(root.left,subRoot.left);
        boolean right = isSame(root.right,subRoot.right);
        return left && right;
    }
}