class Solution {
    int seg[];
    public void Bst(int i,int l,int r,int arr[]){
        if(l==r){
            seg[i] = l;
            return;
        }
        int mid = (l+r)/2;
        Bst(2*i+1,l,mid,arr);
        Bst(2*i+2,mid+1,r,arr);
        int left = seg[2*i+1];
        int right = seg[2*i+2];
        if(arr[left] >= arr[right]){
            seg[i] = left;
        }
        else{
            seg[i] = right;
        }
    }
    public int findLeftMost(int i,int l,int r,int s,int t,int arr[]){
        if(r<s){
            return -1;
        }
        if(arr[seg[i]] <= t){
            return -1;
        }
        if(l==r){
            return l;
        }
        int mid = l+(r-l)/2;
        int left = findLeftMost(2*i+1,l,mid,s,t,arr);
        if(left != -1){
            return left;
        }
        return findLeftMost(2*i+2,mid+1,r,s,t,arr);
    }
    public int[] leftmostBuildingQueries(int[] arr, int[][] q) {
        int n = arr.length;
        seg = new int[4*n];
        Bst(0,0,n-1,arr);
        int m = q.length;
        int ans[] = new int[m];
        for(int i=0;i<m;i++){
            int u = q[i][0];
            int v = q[i][1];
            if(u == v){
                ans[i] = u;
                continue;
            }
            if(u < v && arr[u] < arr[v]){
                ans[i] = v;
                continue;
            }
            if(v < u && arr[v] < arr[u]){
                ans[i] = u;
                continue;
            }
            int s = Math.max(u,v);
            int target = Math.max(arr[u],arr[v]);
            int idx = findLeftMost(0,0,n-1,s,target,arr);
            ans[i] = idx;
        }
        return ans;
    }
}