class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list  = new ArrayList<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > n/3){
                list.add(entry.getKey());
            }
        }
        return list;
    }
}