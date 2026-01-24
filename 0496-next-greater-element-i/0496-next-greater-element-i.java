class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int same[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(nums1[i] == nums2[j]){
                    same[i] = j;
                } 
            }
        }
        int nge[] = new int[m];
        Stack<Integer> stack = new Stack<>();
        for(int i=m-1;i>=0;i--){
            while(!stack.isEmpty() && nums2[stack.peek()] < nums2[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nge[i] =-1;
            }
            else{
                nge[i] = nums2[stack.peek()];
            }
            stack.push(i);
        }
        int ans[] = new int[n];
        for(int i=0;i<same.length;i++){
            ans[i] = nge[same[i]]; 
        }
        return ans;
    }
}