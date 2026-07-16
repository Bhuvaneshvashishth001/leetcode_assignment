class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int n = arr.length;
        int  i =0;
        int  j =0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while(j<n){
            sum += arr[j];
            while(sum >= target){
                minLen = Math.min(minLen,j-i+1);
                sum-=arr[i];
                i++;
            }
            j++;
        }
        return minLen == Integer.MAX_VALUE ?0:minLen;
    }
}