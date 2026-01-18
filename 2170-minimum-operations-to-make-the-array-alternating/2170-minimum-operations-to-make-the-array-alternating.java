class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> odd = new HashMap<>();
        HashMap<Integer,Integer> even = new HashMap<>();
        int o= 0;
        int e = 0;
        for(int i=0;i<n;i++){
            if(i%2 ==0){
                odd.put(nums[i],odd.getOrDefault(nums[i],0)+1);
                o++;
            }
            else{
                even.put(nums[i],even.getOrDefault(nums[i],0)+1);
                e++;
            }
        }
        ArrayList<Map.Entry<Integer,Integer>> list1 = new ArrayList<>(odd.entrySet());
        ArrayList<Map.Entry<Integer,Integer>> list2 = new ArrayList<>(even.entrySet());
        list1.sort((a,b)->b.getValue() - a.getValue());
        list2.sort((a,b)->b.getValue() - a.getValue());
        int ans = Integer.MAX_VALUE;
        if(!list1.isEmpty() && !list2.isEmpty() && !list1.get(0).getKey().equals(list2.get(0).getKey())){
            ans = Math.min(ans,o-(list1.get(0).getValue())+(e-list2.get(0).getValue()));
        }
        else{
            if(list1.size()>1){
                ans = Math.min(ans,(o-list1.get(1).getValue())+(e-list2.get(0).getValue()));
            }
            if(list2.size()>1){
                ans = Math.min(ans,(o- list1.get(0).getValue())+(e- list2.get(1).getValue()));
            }
        }
        return ans==Integer.MAX_VALUE ? Math.min(e,o):ans;
    }
}