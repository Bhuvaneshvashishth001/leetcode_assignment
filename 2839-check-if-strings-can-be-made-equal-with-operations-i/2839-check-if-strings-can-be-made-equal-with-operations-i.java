class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        int n = s1.length();
        HashSet<Character> o = new HashSet<>();
        HashSet<Character> e = new HashSet<>();
        for(int i=0;i<4;i++){
            if(i%2 ==0){
                e.add(s1.charAt(i));
            }
            else{
                o.add(s1.charAt(i));
            }
        }
        for(int i=0;i<4;i++){
            if(i%2 == 0){
                e.remove(s2.charAt(i));
            }
            else{
                o.remove(s2.charAt(i));
            }
        }
        return o.size() == 0 && e.size() ==0;
    }
}