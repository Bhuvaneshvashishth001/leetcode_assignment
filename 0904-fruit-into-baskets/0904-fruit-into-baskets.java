class Solution {
    public int totalFruit(int[] fruits) {
        int  i =0;
        int  j =0;
        int n = fruits.length;
        int maxPick = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(j<n){
            while(!map.containsKey(fruits[j]) && map.size() >= 2){
                map.put(fruits[i],map.get(fruits[i])-1);
                if(map.get(fruits[i])==0){
                    map.remove(fruits[i]);
                }
                i++;
            }
            map.put(fruits[j],map.getOrDefault(fruits[j],0)+1);
            maxPick = Math.max(maxPick,j-i+1);
            j++;
        }
        return maxPick;
    }
}