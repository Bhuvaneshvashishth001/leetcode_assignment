class Solution {
    public int distributeCandies(int[] arr) {
        int n = arr.length;
        int eat = n/2;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(arr[i]);
        }
        if(eat<=set.size()){
            return eat;
        }
        return set.size();
    }
}