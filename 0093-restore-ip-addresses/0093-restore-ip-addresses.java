class Solution {
    public static void helper(List<String>list,String str,String s,String ans,int point){
        if(point == 4 && s.length()==0){
            list.add(ans.substring(0,ans.length()-1));
            return;
        }
        if(point>4){
            return;
        }
        for(int idx =1;idx<=3 && idx<=s.length() ;idx++){
            str = s.substring(0,idx);
            if(str.length()>1 && (str.charAt(0) =='0' || Integer.parseInt(str)>255)){
                continue;
            }
            helper(list,str,s.substring(idx),ans+str+".",point+1);
        }
    }
    public List<String> restoreIpAddresses(String s) {
        List<String>list = new ArrayList<>();
        helper(list,"",s,"",0);
        return list;
    }
}