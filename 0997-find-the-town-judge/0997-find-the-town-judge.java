class Solution {
    public int findJudge(int n, int[][] trust) {
        int indegree[] = new int[n+1];
        int outdegree[] = new int[n+1];
        if(trust.length ==0 && n==1){
            return 1;
        }
        for(int edge[] :trust){
            indegree[edge[1]]++;
            outdegree[edge[0]]++;
        }

        for(int i=0;i<=n;i++){
            if(indegree[i] == n-1 && outdegree[i] ==0){
                return i;
            }
        }
        return -1;
    }
}