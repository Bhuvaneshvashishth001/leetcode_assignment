class Solution {
    public int totalFruit(int[] arr) {
        int n = arr.length;
        int i = 0;
        int maxCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int j = 0; j < n; j++) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
            while (map.size() > 2) {
                map.put(arr[i], map.get(arr[i]) - 1);
                if (map.get(arr[i]) == 0) {
                    map.remove(arr[i]);
                }
                i++;
            }
            maxCount = Math.max(maxCount, j - i + 1);
        }
        return maxCount;
    }
}