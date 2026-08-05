class Solution {
    public void all(List<List<Integer>>ans,List<Integer> list,int idx,int arr[]){
        if(idx == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
            list.add(arr[idx]);
            all(ans,list,idx+1,arr);
            list.remove(list.size()-1);
            int temp1 = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp1;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        all(ans,list,0,nums);
        return ans;
    }
}