class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int min = arr[0];
        int max = 0;
        int pro =0;
        for(int i=1;i<n;i++){
            if(arr[i]>max && arr[i]>min){
                max = arr[i];
            }
            else if(arr[i]<min){
                min = arr[i];
                max =0;
            }
            pro = Math.max(pro,max-min);
        }
        return pro;
    }
}