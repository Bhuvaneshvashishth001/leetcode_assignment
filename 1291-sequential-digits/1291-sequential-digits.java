class Solution {
    public void sequence(int low,int high,int val,List<Integer> ans){
        if(val > high){
            return;
        }
        if(val >= low && val <= high){
            ans.add(val);
        }
        int last = val%10;
        if(last < 9){
            val = val*10+(last+1);
            sequence(low,high,val,ans);
        }
    }
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<=9;i++){
            sequence(low,high,i,ans);
        }
        Collections.sort(ans);
        return ans;
    }
}