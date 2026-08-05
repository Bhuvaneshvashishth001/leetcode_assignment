class Solution {
    public void all(List<List<Integer>>ans,List<Integer> list,int idx,int arr[]){
        if(idx == arr.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=idx;i<arr.length;i++){
            int temp = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp;
            list.add(arr[idx]);
            all(ans,list,idx+1,arr);
            list.remove(list.size()-1);
            int temp1 = arr[idx];
            arr[idx] = arr[i];
            arr[i] = temp1;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        all(ans,list,0,nums);
        return ans;
    }
}