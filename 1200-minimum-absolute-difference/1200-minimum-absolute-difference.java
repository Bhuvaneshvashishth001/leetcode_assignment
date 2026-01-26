class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            min = Math.min(min,Math.abs(arr[i-1]-arr[i]));
        }
        List<List<Integer>> list = new ArrayList<>();
        for(int i=1;i<n;i++){
            if(Math.abs(arr[i]-arr[i-1]) == min){
                List<Integer> list1 = new ArrayList<>();
                list1.add(arr[i-1]);
                list1.add(arr[i]);
                list.add(list1);
            }
        }
        return list;
    }
}