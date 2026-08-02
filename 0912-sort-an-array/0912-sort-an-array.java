class Solution {
    public void merge(int low,int mid,int high,int arr[]){
        int left = low;
        int right = mid+1;
        int nums[] = new int[high-low+1];
        int k = 0;
        while(left <= mid && right <= high){
            if(arr[left]<= arr[right]){
                nums[k] = arr[left];
                left++;
            }
            else{
                nums[k] = arr[right];
                right++;
            }
            k++;
        }
        while(left<= mid){
            nums[k] = arr[left];
            left++;
            k++;
        }
        while(right <=high){
            nums[k] = arr[right];
            right++;
            k++;
        }
        for(int i=0;i<nums.length;i++){
            arr[low+i] = nums[i];
        }
    }
    public void mergeSort(int low,int high,int arr[]){
        if(low < high){
            int mid = (low+high)/2;
            mergeSort(low,mid,arr);
            mergeSort(mid+1,high,arr);
            merge(low,mid,high,arr);
        }
    }
    public int[] sortArray(int[] nums) {
        mergeSort(0,nums.length-1,nums);
        return nums;
    }
}