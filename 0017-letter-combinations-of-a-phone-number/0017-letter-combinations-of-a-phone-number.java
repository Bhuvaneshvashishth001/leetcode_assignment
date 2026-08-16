class Solution {
    public void combinations(int idx,String str,Map<Character,String> map,List<String> ans,String sb){
        if(idx >= str.length()){
            ans.add(sb);
            return;
        }
        String letter = map.get(str.charAt(idx));
        for(int i=0;i<letter.length();i++){
            combinations(idx+1,str,map,ans,sb+letter.charAt(i));
        }
    }
    public List<String> letterCombinations(String digits) {
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> ans =new ArrayList<>();
        String sb = "";
        combinations(0,digits,map,ans,sb);
        return ans;
    }
}