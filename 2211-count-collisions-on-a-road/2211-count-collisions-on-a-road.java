class Solution {
    public int countCollisions(String dir) {
        int ans = 0;
        int r =0;
        boolean stop = false;
        for(int i=0;i<dir.length();i++){
            if(dir.charAt(i) =='R'){
                r++;
            }
            else if(dir.charAt(i) =='S'){
                ans+=r;
                r=0;
                stop = true;
            }
            else{
                if(r>0){
                    ans += (r+1);
                    r=0;
                    stop = true;
                }
                else if(stop){
                    ans+=1;
                }
            }
        }
        return ans;
    }
}