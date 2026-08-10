class Solution {
    public boolean isPalindrome(String str){
        StringBuilder sb = new StringBuilder(str);
        String s = sb.reverse().toString();
        if(s.equals(str)){
            return true;
        }
        return false;
    }
    public void palindromes(int idx,List<String> list,List<List<String>> ans,String s){
        if(idx >= s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }
        String str = "";
        for(int i = idx;i<s.length() ;i++){
            str += s.charAt(i);
            if(isPalindrome(str)){
                list.add(str);
                palindromes(i+1,list,ans,s);
                list.remove(list.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        palindromes(0,list,ans,s);
        return ans;
    }
}