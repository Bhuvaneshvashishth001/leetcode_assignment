class Solution {
    List<String> list;
    public void helper(String s,int idx,String str){
        if(idx == s.length()){
            list.add(str);
            return;
        }
        if(!Character.isDigit(s.charAt(idx))){
            char a = Character.toUpperCase(s.charAt(idx));
            char b = Character.toLowerCase(s.charAt(idx));
            helper(s,idx+1,str+a);
            helper(s,idx+1,str+b);
        }
        else{
            helper(s,idx+1,str+s.charAt(idx));
        }
    }
    public List<String> letterCasePermutation(String s) {
        list = new ArrayList<>();
        helper(s,0,"");
        return list;
    }
}