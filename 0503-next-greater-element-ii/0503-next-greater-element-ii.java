class Solution { 
    public int[] nextGreaterElements(int[] nums) { 
        int n = nums.length; 
        ArrayDeque <Integer> stack = new ArrayDeque<>(); 
        int map[] = new int[n]; 
        for(int i=2*n-1; i>=0 ;i--){ 
            while(!stack.isEmpty() && nums[i%n]>=stack.peek()){ 
                stack.pop(); 
            } 
            if(i<n){ 
                if(stack.isEmpty()){ 
                    map[i] = -1; 
                } 
                else{ 
                    map[i] = stack.peek(); 
                }
            }
            stack.push(nums[i%n]); 
        } 
        return map; 
    } 
}