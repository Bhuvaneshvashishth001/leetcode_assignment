class Solution {
    public boolean isPalindrome(String str){
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        if(str.equals(sb.toString())){
            return true;
        }
        return false;
    }
    public void helper(String s,int idx,List<String> list,List<List<String>> ans){
        if(idx >= s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        String  str = "";
        for(int i=idx;i<s.length();i++){
            str += s.charAt(i);
            if(isPalindrome(str)){
                list.add(str);
                helper(s,i+1,list,ans);
                list.remove(list.size()-1);
            }         
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        helper(s,0,list,ans);
        return ans;
    }
}