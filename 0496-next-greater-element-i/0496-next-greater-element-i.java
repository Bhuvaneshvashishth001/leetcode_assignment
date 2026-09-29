class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=m-1;i>=0;i--){
            while(!stack.isEmpty() && nums2[i] >= stack.peek()){
                stack.pop();
            }
            if(!stack.isEmpty()){
                int val = stack.peek();
                map.put(nums2[i],val);
            }
            else{
                map.put(nums2[i],-1);
            }
            stack.push(nums2[i]);
        }
        int ans[] = new int[n];
        for(int i=0;i<n;i++){
            if(map.containsKey(nums1[i])){
                ans[i] = map.get(nums1[i]);
            }
            else{
                ans[i] =-1;
            }
        }
        return ans;
    }
}