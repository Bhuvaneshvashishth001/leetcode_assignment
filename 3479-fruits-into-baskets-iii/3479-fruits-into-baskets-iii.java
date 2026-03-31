class Solution {
    int seg[];

    public void buildST(int i,int l,int r,int arr[]){
        if(l==r){
            seg[i] = l;
            return;
        }
        int mid = (l+r)/2;
        buildST(2*i+1,l,mid,arr);
        buildST(2*i+2,mid+1,r,arr);
        int left = seg[2*i+1];
        int right = seg[2*i+2];

        if(arr[left] >= arr[right]){
            seg[i] = left;
        }
        else{
            seg[i] = right;
        }
    }
    public int findFirstGreater(int i,int l,int r,int t,int arr[]){
        if(arr[seg[i]] < t){
            return -1;
        } 
        if(l == r){
            return l;
        }
        int mid = (l + r) / 2;
        int left = findFirstGreater(2*i+1, l, mid, t, arr);
        if (left != -1){
            return left;
        }
        return findFirstGreater(2*i+2, mid+1, r, t, arr);
    }
    public void update(int i,int l,int r,int idx,int arr[]){
        if(l==r){
            arr[idx] = -1; 
            return;
        }
        int mid = (l+r)/2;
        if(idx <= mid){
            update(2*i+1,l,mid,idx,arr);
        }
        else{
            update(2*i+2,mid+1,r,idx,arr);
        }
        int left = seg[2*i+1];
        int right = seg[2*i+2];
        if(arr[left] >= arr[right]){
            seg[i] = left;
        }
        else{
            seg[i] = right;
        }
    }
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = baskets.length;
        seg = new int[4*n];
        buildST(0,0,n-1,baskets);
        int count = 0;
        for(int i=0;i<fruits.length;i++){
            int idx = findFirstGreater(0,0,n-1,fruits[i],baskets);
            if(idx == -1){
                count++;
            }
            else{
                update(0,0,n-1,idx,baskets);
            }
        }
        return count;
    }
}