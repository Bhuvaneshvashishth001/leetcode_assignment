class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        int count = 0;
        boolean flag = false;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            int freq = entry.getValue();
            if(freq%2 ==0){
                count += freq;
            }
            else{
                count += ((freq/2)*2);
                if(!flag){
                    count+=1;
                    flag = true;
                }
            }
        }
        return count;
    }
}