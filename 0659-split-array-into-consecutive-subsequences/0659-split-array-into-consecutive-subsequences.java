class Solution{
    public boolean isPossible(int[] nums){
        Map<Integer,Integer> m=new HashMap<>();
        Map<Integer,Integer> m1=new HashMap<>();
        for(int x:nums){
            m.put(x,m.getOrDefault(x,0)+1);
        }
        for(int x:nums){
            if(m.get(x)==0) continue;
            m.put(x,m.get(x)-1);
            if(m1.getOrDefault(x,0)>0){
                m1.put(x,m1.get(x)-1);
                m1.put(x+1,m1.getOrDefault(x+1,0)+1);
            }
            else if(m.getOrDefault(x+1,0)>0 && m.getOrDefault(x+2,0)>0){
                m.put(x+1,m.get(x+1)-1);
                m.put(x+2,m.get(x+2)-1);
                m1.put(x+3,m1.getOrDefault(x+3,0)+1);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
