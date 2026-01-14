class Solution {
    public static int subpart(int arr[] ,int k){
        int i=0,j=0;
        int n =arr.length;
        int count=0;
        HashMap <Integer,Integer> map = new HashMap <>();
        while(j<n){
            map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            while(map.size()>k){
                map.put(arr[i] , map.get(arr[i])-1);
                if(map.get(arr[i])==0){
                    map.remove(arr[i]);
                }
                i++;
            }
            count+=(j-i+1);
            j++;
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subpart(nums,k) - subpart(nums,k-1);
    }
}