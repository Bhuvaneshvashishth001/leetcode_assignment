class Solution {
    public void helper(int n,int k,char str[],List<String> list,char prev,String ans){
        if(ans.length() == n){
            list.add(ans);
            return;
        }
        for(int i=0;i<3;i++){
            if(str[i] != prev){
                helper(n,k,str,list,str[i],ans+str[i]);
            }
        }
    }
    public String getHappyString(int n, int k) {
        char str[] = {'a','b','c'};
        List<String> list = new ArrayList<>();
        helper(n,k,str,list,'z',"");
        return list.size()>=k ? list.get(k-1):"";
    }
}