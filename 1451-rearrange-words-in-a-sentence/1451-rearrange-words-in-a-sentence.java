class Solution {
    class Pair{
        String str;
        int len;
        int idx;
        public Pair(String str,int len,int idx){
            this.str = str;
            this.len = len;
            this.idx = idx;
        }
    }
    public String arrangeWords(String text) {
        String arr[] = text.split(" ");
        int n = arr.length;
        PriorityQueue<Pair> queue = new PriorityQueue<>((a,b)->(a.len==b.len)?a.idx-b.idx:a.len-b.len);
        for(int i=0;i<n ;i++){
            queue.add(new Pair(arr[i],arr[i].length(),i));
        }
        StringBuilder ans=new StringBuilder();
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            ans.append(p.str).append(" ");
        }
        ans.setLength(ans.length()-1);
        ans.setCharAt(0,Character.toUpperCase(ans.charAt(0)));
        for(int i=1;i<ans.length();i++){
            ans.setCharAt(i,Character.toLowerCase(ans.charAt(i)));
        }
        return ans.toString().trim();
    }
}