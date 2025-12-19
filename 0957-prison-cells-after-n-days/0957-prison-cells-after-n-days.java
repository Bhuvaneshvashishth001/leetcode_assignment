class Solution {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int m = cells.length;
        n=(n-1)%14+1;
        for(int i=1;i<=n;i++){
            int temp[] = new int[m];
            for(int j=1;j<m-1;j++){
                if(cells[j-1] == cells[j+1]){
                    temp[j] = 1;
                }
                else{
                    temp[j]=0;
                }
            }
            cells=temp;
        }
        return cells;
    }
}