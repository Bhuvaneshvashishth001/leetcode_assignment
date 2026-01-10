class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> lastRain = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if(rains[i] > 0){
                int lake = rains[i];
                ans[i] = -1;
                if (lastRain.containsKey(lake)) {
                    Integer dryDay = dryDays.ceiling(lastRain.get(lake) + 1);
                    if (dryDay == null) return new int[0];
                    ans[dryDay] = lake;
                    dryDays.remove(dryDay);
                }
                lastRain.put(lake, i);
            } 
            else{
                dryDays.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}
