class Solution {
    public void par(List<String> ans,String str,int open,int close,int n){
        if(open == n && close == n){
            ans.add(str);
            return;
        }
        if(close<open){
            par(ans,str+")",open,close+1,n);
        }
        if(open<n){
            par(ans,str+"(",open+1,close,n);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        par(ans,"",0,0,n);
        return ans;
    }
}