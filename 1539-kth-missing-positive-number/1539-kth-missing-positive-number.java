class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int e = k+n;
        HashSet<Integer> set = new HashSet<>();
        for(int num:arr){
            set.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=e;i++){
            if(!set.contains(i)){
                list.add(i);
            }
        }
        return list.get(k-1);
    }
}