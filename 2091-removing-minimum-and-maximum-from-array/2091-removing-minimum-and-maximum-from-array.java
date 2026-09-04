class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int maxIdx = -1;
        for(int i=0;i<n;i++){
            if(max<nums[i]){
                max = nums[i];
                maxIdx = i;
            }
            if(min>nums[i]){
                min = nums[i];
                minIdx = i;
            }
        }
        if(maxIdx == minIdx){
            return 1;
        }
        int op1 = (minIdx<maxIdx) ? (minIdx-0+1)+(maxIdx-minIdx) : (maxIdx-0+1)+(minIdx-maxIdx) ;
        int op2 = (minIdx>maxIdx) ? (n-minIdx)+(minIdx-maxIdx) : (n-maxIdx)+(maxIdx-minIdx);
        int op3 = (minIdx-0+1)+(n-maxIdx);
        int op4 = (maxIdx-0+1)+(n-minIdx);
        return Math.min(op1,Math.min(op2,Math.min(op3,op4)));
    }
}