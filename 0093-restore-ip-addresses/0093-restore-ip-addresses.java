class Solution {
    public void restore(int idx,String sb,int points,String s,List<String> ans){
        
        if(points > 4){
            return;
        }
        if(points == 4 && idx < s.length()){
            return;
        }
        if(idx > s.length()){
            return;
        }
        if(points == 4 && idx == s.length()){
            ans.add(sb.substring(0,sb.length()-1));
            return;
        }
        String str = "";
        for(int i=idx;i<s.length();i++){
            str += s.charAt(i);
            if(str.length()>1 && str.charAt(0) == '0'){
                break;
            }
            if(Integer.parseInt(str) <= 255){
                restore(i+1,sb+str+".",points+1,s,ans);
            }
            else{
                break;
            }
        }
    } 
    public List<String> restoreIpAddresses(String s) {
        List<String> ans  = new ArrayList<>();
        restore(0,"",0,s,ans);
        return ans;
    }
}