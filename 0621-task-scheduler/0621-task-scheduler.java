class Solution {
    public int leastInterval(char[] tasks, int n) {
        int m = tasks.length;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<m;i++){
            map.put(tasks[i],map.getOrDefault(tasks[i],0)+1);
        }
        int size = map.size();
        int matrix[][] = new int[size][1];
        int i=0;
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            matrix[i][0] = entry.getValue();
            i++;
        }
        Arrays.sort(matrix, (a, b) -> b[0] - a[0]);
        int maxFreq = matrix[0][0];
        int maxCount = 0;
        for (int j = 0; j < size; j++) {
            if (matrix[j][0] == maxFreq){
                maxCount++;
            }
        }
        int part = (maxFreq-1)*(n + 1)+maxCount;
        return Math.max(m, part);
    }
}