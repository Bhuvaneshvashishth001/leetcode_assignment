class NumArray {
    int seg[];
    int n;
    public void Bst(int i,int l,int r,int nums[]){
        if(l == r){
            seg[i] = nums[l];
            return;
        }
        int mid = (l+r)/2;
        Bst(2*i+1,l,mid,nums);
        Bst(2*i+2,mid+1,r,nums);
        seg[i] = seg[2*i+1]+seg[2*i+2];
    }
    public NumArray(int[] nums) {
        n = nums.length;
        seg = new int[4*n];
        Bst(0,0,n-1,nums);
    }
    
    public void update(int index, int val) {
        updated(0,0,n-1,index,val);
    }

    public void updated(int i,int l,int r,int idx,int val){
        if(l == r){
            seg[i] = val;
            return;
        }
        int mid = (l+r)/2;
        if(idx<= mid){
            updated(2*i+1,l,mid,idx,val);
        }
        else{
            updated(2*i+2,mid+1,r,idx,val);
        }
        seg[i] = seg[2*i+1]+seg[2*i+2];
    }
    
    public int sumRange(int left, int right) {
        return findSum(0,0,n-1,left,right);
    }

    public int findSum(int i,int l,int r,int left,int right){
        if(l>right || r<left){
            return 0;
        }
        if(l>=left && r<= right){
            return seg[i];
        }
        int mid = (l+r)/2;
        int first = findSum(2*i+1,l,mid,left,right);
        int second = findSum(2*i+2,mid+1,r,left,right);
        return first+second;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */