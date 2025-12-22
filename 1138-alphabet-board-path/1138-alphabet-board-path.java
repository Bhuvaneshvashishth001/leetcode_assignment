class Solution {
    class Pair{
        int row;
        int col;
        public Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
    public static String add(String str,int trick,int len_r,int len_c){
        if(trick ==0){
            for(int j=0;j<len_c;j++){
                str = str+"L";
            }
            for(int i=0;i<len_r;i++){
                str = str+"D";
            }
        }
        else if(trick ==1){
            for(int i=0;i<len_r;i++){
                str = str+"D";
            }
            for(int j=0;j<len_c;j++){
                str = str+"L";
            }
        }
        if(trick ==2){
            for(int i=0;i<len_r;i++){
                str = str+"D";
            }
            for(int j=0;j<len_c;j++){
                str = str+"R";
            }
        }
        if(trick ==3){
            for(int i=0;i<len_r;i++){
                str = str+"U";
            }
            for(int j=0;j<len_c;j++){
                str = str+"R";
            }
        }
        if(trick ==4){
            for(int i=0;i<len_r;i++){
                str = str+"U";
            }
            for(int j=0;j<len_c;j++){
                str = str+"L";
            }
        }
        if(trick ==5){
            for(int i=0;i<len_c;i++){
                str = str+"L";
            }
        }
        if(trick ==6){
            for(int i=0;i<len_c;i++){
                str = str+"R";
            }
        }
        if(trick == 7){
            for(int i=0;i<len_r;i++){
                str = str+"U";
            }
        }
        if(trick == 8){
            for(int i=0;i<len_r;i++){
                str = str+"D";
            }
        }
        return str;
    }
    public String alphabetBoardPath(String target) {
        HashMap<Character,Pair> map = new HashMap<>();
        char ch = 'a';
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                map.put(ch,new Pair(i,j));
                ch++;
            }
        }
        map.put('z',new Pair(5,0));
        int start[] = {0,0};
        int n = target.length();
        String ans = "";
        int len_r = 0;
        int len_c = 0;
        for(int i=0;i<n;i++){
            Pair p = map.get(target.charAt(i));
            int r = p.row;
            int c = p.col;
            int trick =0;
            if(r==5 && c==0){
                len_r = Math.abs(r-start[0]);
                len_c = Math.abs(start[1]-c);
                trick = 0;
                ans = ans+add("",trick,len_r,len_c);
                start[0] = r;
                start[1] = c;
                ans = ans+"!";
            }
            else if(r<5 && r>=0 && c<5 && c>=0 && r>start[0] && c<start[1]){
                len_r = Math.abs(r-start[0]);
                len_c = Math.abs(start[1]-c);
                trick = 1;
                ans = ans+add("",trick,len_r,len_c);
                start[0] = r;
                start[1] = c;
                ans = ans+"!";
            }
            else if(r<5 && r>=0 && c<5 && c>=0 && r>start[0] && c>start[1] ){
                len_r = Math.abs(r-start[0]);
                len_c = Math.abs(start[1]-c);
                trick =2;
                ans = ans+add("",trick,len_r,len_c);
                start[0] = r;
                start[1] = c;
                ans = ans+"!";
            }
            else if(r<5 && r>=0 && c<5 && c>=0 && r<start[0] && c>start[1]){
                len_r = Math.abs(r-start[0]);
                len_c = Math.abs(start[1]-c);
                trick = 3;
                ans = ans+add("",trick,len_r,len_c);
                start[0] = r;
                start[1] = c;
                ans = ans+"!";
            }
            else if(r<5 && r>=0 && c<5 && c>=0 && r<start[0] && c<start[1]){
                len_r = Math.abs(r-start[0]);
                len_c = Math.abs(start[1]-c);
                trick = 4;
                ans = ans+add("",trick,len_r,len_c);
                start[0] = r;
                start[1] = c;
                ans = ans+"!";
            }
            else if(r<5 && r>=0 && c<5 && c>=0 && r== start[0] && c!=start[1] &&c<start[1]){
                len_r = Math.abs(r-start[0]);
                len_c = Math.abs(start[1]-c);
                trick = 5;
                ans = ans+add("",trick,len_r,len_c);
                start[0] = r;
                start[1] = c;
                ans = ans+"!";
            }
            else if(r<5 && r>=0 && c<5 && c>=0 && r== start[0] && c!=start[1] &&c>start[1]){
                len_r = Math.abs(r-start[0]);
                len_c = Math.abs(start[1]-c);
                trick = 6;
                ans = ans+add("",trick,len_r,len_c);
                start[0] = r;
                start[1] = c;
                ans = ans+"!";
            }
            else if(r<5 && r>=0 && c<5 && c>=0 && r<start[0] && c==start[1]){
                len_r = Math.abs(r-start[0]);
                len_c = Math.abs(start[1]-c);
                trick = 7;
                ans = ans+add("",trick,len_r,len_c);
                start[0] = r;
                start[1] = c;
                ans = ans+"!";
            }
            else if(r<5 && r>=0 && c<5 && c>=0 && r>start[0] && c==start[1]){
                len_r = Math.abs(r-start[0]);
                len_c = Math.abs(start[1]-c);
                trick = 8;
                ans = ans+add("",trick,len_r,len_c);
                start[0] = r;
                start[1] = c;
                ans = ans+"!";
            }
            else{
                if(r<5 && r>=0 && c<5 && c>=0){
                    ans = ans+"!";
                }
            }
        }
        return ans;
    }
}