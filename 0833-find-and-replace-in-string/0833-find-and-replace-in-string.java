class Solution {
    public String findReplaceString(String s, int[] indices, String[] source, String[] targets) {
        int n = indices.length;
        int m = s.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < m){
            boolean replaced = false;
            for(int k = 0; k < n; k++){
                int idx = indices[k];
                String src = source[k];
                if(i == idx &&i+src.length()<= m && s.substring(i,i+src.length()).equals(src)){
                    sb.append(targets[k]);
                    i += src.length();
                    replaced = true;
                    break;
                }
            }
            if(!replaced){
                sb.append(s.charAt(i));
                i++;
            }
        }
        return sb.toString();
    }
}
