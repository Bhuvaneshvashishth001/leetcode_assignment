class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int i=0;
        int j=9;
        int n = s.length();
        Set<String> list = new HashSet<>();
        Set<String> set = new HashSet<>();
        if(s.length()<10){
            return new ArrayList<>();
        }
        set.add(s.substring(i,j+1));
        j++;
        while(j<n){
            String str = s.substring(i+1,j+1);
            if(set.contains(str)){
                list.add(str);
            }
            else{
                set.add(str);
            }
            i++;
            j++;
        }
        return new ArrayList<>(list);
    }
}