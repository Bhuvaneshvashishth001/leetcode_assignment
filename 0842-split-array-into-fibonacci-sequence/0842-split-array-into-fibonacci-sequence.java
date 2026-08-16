class Solution {

    public static boolean fibonacci(int idx,
                                    List<Integer> ans,
                                    String nums) {

        if (idx == nums.length()) {
            return ans.size() >= 3;
        }

        String str = "";

        for (int i = idx; i < nums.length(); i++) {

            str += nums.charAt(i);

            // Leading zero
            if (str.length() > 1 && str.charAt(0) == '0') {
                return false;
            }

            // Prevent number overflow
            if (str.length() > 10 ||
                (str.length() == 10 &&
                 str.compareTo("2147483647") > 0)) {
                break;
            }

            int val = Integer.parseInt(str);

            // First two numbers
            if (ans.size() < 2) {

                ans.add(val);

                if (fibonacci(i + 1, ans, nums)) {
                    return true;
                }

                ans.remove(ans.size() - 1);
            }

            // Fibonacci condition
            else {

                long sum = (long) ans.get(ans.size() - 1)
                         + (long) ans.get(ans.size() - 2);

                if (sum == val) {

                    ans.add(val);

                    if (fibonacci(i + 1, ans, nums)) {
                        return true;
                    }

                    ans.remove(ans.size() - 1);
                }
            }
        }

        return false;
    }

    public static List<Integer> splitIntoFibonacci(String num) {

        List<Integer> ans = new ArrayList<>();

        fibonacci(0, ans, num);

        return ans;
    }
}