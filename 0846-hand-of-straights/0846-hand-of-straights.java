class Solution {
    public boolean isNStraightHand(int[] arr, int k) {

        int n = arr.length;

        if (n % k != 0) {
            return false;
        }

        Arrays.sort(arr);

        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : arr) {

            if (map.get(num) == 0) {
                continue;
            }

            for (int j = 0; j < k; j++) {

                int current = num + j;

                if (map.getOrDefault(current, 0) == 0) {
                    return false;
                }

                map.put(current, map.get(current) - 1);
            }
        }

        return true;
    }
}