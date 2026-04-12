class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int arr[][] = new int[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr,(a,b) ->{
            return a[0]-b[0];
        });
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++){
            int first = i;
            int second = i+1;
            int third = i+2;
            if(arr[first][0] == arr[second][0] && arr[second][0] == arr[third][0]){
                ans = Math.min(ans,Math.abs(arr[first][1]-arr[second][1]) + Math.abs(arr[second][1]-arr[third][1]) + Math.abs(arr[first][1]- arr[third][1]));
            }
        }
        return ans == Integer.MAX_VALUE?-1:ans;
    }
}