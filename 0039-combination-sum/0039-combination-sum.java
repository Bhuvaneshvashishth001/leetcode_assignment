class Solution {
    public void combinations(List<List<Integer>> ans,List<Integer> list,int t,int idx,int arr[]){
        if(t == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(idx >= arr.length){
            return;
        }
        if(arr[idx]<=t){
            list.add(arr[idx]);
            combinations(ans,list,t-arr[idx],idx,arr);
            list.remove(list.size()-1);
        }
        combinations(ans,list,t,idx+1,arr);        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinations(ans,list,target,0,candidates);
        return ans;
    }
}