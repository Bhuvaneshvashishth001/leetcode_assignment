class Solution {
    class Pair{
        String w;
        int step;
        public Pair(String w,int step){
            this.w = w;
            this.step = step;
        }
    }
    public int ladderLength(String s, String e, List<String> wordList) {
        Queue<Pair> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        if(!set.contains(e)){
            return 0;
        }
        queue.add(new Pair(s,1));
        set.remove(s);
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            String word = p.w;
            int steps = p.step;
            for(int i=0;i<word.length();i++){
                for(char j= 'a' ;j<='z';j++){
                    char arr[] = word.toCharArray();
                    arr[i] = j;
                    String str = new String(arr);
                    if(set.contains(str)){
                        if(str.equals(e)){
                            return steps+1;
                        }
                        queue.add(new Pair(str,steps+1));
                    } 
                    set.remove(str);
                } 
            }
        }
        return 0;
    }
}