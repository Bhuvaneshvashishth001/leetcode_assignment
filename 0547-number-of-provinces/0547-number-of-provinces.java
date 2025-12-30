class Solution {
    public static void dfs(int matrix[][],int visited[],int i){  
        for(int j=0;j<matrix.length ;j++){
            if(matrix[i][j]==1 && visited[j]==0){
                visited[j]=1;
                dfs(matrix,visited,j);
            }
        }
    }
    public int findCircleNum(int[][] matrix) {
        int n = matrix.length;
        int visited[] = new int[n];
        int count=0;
        for(int i=0 ;i<n ;i++){
            if(visited[i] != 1){
                dfs(matrix,visited,i);
                count++;
            }
        }
        return count;
    }
}