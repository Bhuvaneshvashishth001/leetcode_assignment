class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs.length;
        int m=strs[0].length();
        char board[][]=new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                board[i][j]=strs[i].charAt(j);
            }
        }
        boolean[] sorted=new boolean[n-1];
        int count=0;
        for(int i=0;i<m;i++){
            boolean bad=false;
            for(int j=0;j<n-1;j++){
                if(!sorted[j]){
                    if(board[j][i]>board[j+1][i]){
                        bad=true;
                        break;
                    }
                }
            }
            if(bad){
                count++;
            }else{
                for(int j=0;j<n-1;j++){
                    if(board[j][i]<board[j+1][i]){
                        sorted[j]=true;
                    }
                }
            }
        }
        return count;
    }
}
