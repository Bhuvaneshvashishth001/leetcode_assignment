class Solution {
    public static int sol(int n ,int idx,ArrayList<Integer> set){
        if(idx==n){
            return 1;
        }
        int count=0;
        for(int i=0;i<=9 ;i++){
            if(idx==0 && i==0 && n>1){
                continue;
            }
            if(!set.contains(i)){
                set.add(i);
                count += sol(n,idx+1,set);
                set.remove(set.size()-1);    
            }
        }
        return count+1;
    }
    public int countNumbersWithUniqueDigits(int n) {
        ArrayList<Integer> set = new ArrayList<>();
        if(n==1){
            return sol(n,0,set)-1;
        }
        return sol(n,0,set);
    }
}