class Solution {
    public static void Combinations(int arr[],int target,int sum,int idx,List<Integer> ans,List<List<Integer>> res){
        if(sum == target){
            res.add(new ArrayList<>(ans));
            return;
        }
        if(idx>=arr.length || sum>target){
            return;
        }
        if(sum<=target){
            ans.add(arr[idx]);
            Combinations(arr,target,sum+arr[idx],idx,ans,res);
            ans.remove(ans.size()-1);
        }
        Combinations(arr,target,sum,idx+1,ans,res);
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Combinations(arr,target,0,0,ans,res);
        return res;
    }
}