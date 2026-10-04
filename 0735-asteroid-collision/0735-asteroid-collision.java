class Solution {
    public int[] asteroidCollision(int[] arr) {
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            if(arr[i]>= 0){
                stack.push(i);
            }
            else{
                boolean found = false;
                boolean tie = false;
                if(stack.isEmpty() || arr[stack.peek()]<0){
                    stack.push(i);
                }
                else{
                    while(!stack.isEmpty() && arr[stack.peek()] >0 && Math.abs(arr[i])>=arr[stack.peek()]){
                        if(Math.abs(arr[i]) > arr[stack.peek()]){
                            found = true;
                        }
                        if(Math.abs(arr[i]) == arr[stack.peek()]){
                            tie = true;
                            stack.pop();
                            break;
                        }
                        stack.pop();
                    }
                    if((tie == false) && ((found && stack.isEmpty())  || (!stack.isEmpty() && arr[stack.peek()] <0 && found))){
                        stack.push(i);
                        found = false;
                    }
                }
            }
        }   
        int ans[] = new int[stack.size()];
        for(int i=ans.length-1;i>=0;i--){
            ans[i] = arr[stack.pop()];
        }
        return ans;
    }
}