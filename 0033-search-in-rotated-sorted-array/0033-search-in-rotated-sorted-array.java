class Solution {
    public int search(int[] arr, int target) {
        int n = arr.length;
        int start = 0;
        int  end= n-1;
        while(start <= end){
            int mid = start + (end-start);
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[end] >= arr[mid]){
                if(arr[mid]  <= target && arr[end] >= target){
                    start = mid+1;
                }
                else{
                    end = mid-1;
                }
            }
            else{
                if(arr[start] <= target && arr[mid] >= target){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }
        return -1;
    }
}