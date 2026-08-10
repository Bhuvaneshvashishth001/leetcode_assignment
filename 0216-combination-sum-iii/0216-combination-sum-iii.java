class Solution {
    public static void helper(int idx,int k,int n,List<Integer> list,List<List<Integer>> ans,int sum){
        if(list.size() == k && sum == n){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<=9;i++){
            if(sum+i > n){
                return;
            }
            if(sum+i <= n){
                list.add(i);
                helper(i+1,k,n,list,ans,sum+i);
                list.remove(list.size()-1);
            }
        }
    }
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        helper(1,k,n,list,ans,0);
        return ans;
    }
}