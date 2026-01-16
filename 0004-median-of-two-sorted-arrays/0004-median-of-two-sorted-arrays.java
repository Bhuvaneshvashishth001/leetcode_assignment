class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int arr[] = new int[n+m];
        int i=0;
        int j=0;
        int k=0;
        while(i<n && j<m){
            if(nums1[i] <= nums2[j]){
                arr[k] = nums1[i];
                i++;
            }
            else{
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i<n){
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while(j<m){
            arr[k] = nums2[j];
            j++;
            k++;
        }
        int len = arr.length;
        double ans= -1;
        if(arr.length%2 ==0){
            ans = (double)(arr[len/2]+arr[len/2-1])/2;
            return ans;
        }
        return (double)arr[arr.length/2];
    }
}