class Solution {
    public static void permute(int idx,int arr[],List<Integer> list,Set<List<Integer>> ans){
        if(idx == arr.length){
            if(!ans.contains(list)){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i=idx;i<arr.length;i++){
            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
            list.add(arr[idx]);
            permute(idx+1,arr,list,ans);
            list.remove(list.size()-1);
            int temp1 = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp1;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        permute(0,nums,list,ans);
        return new ArrayList<>(ans);
    }
}