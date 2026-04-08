class Solution {
    public String convertToTitle(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 26) {
            num--;
            int rem = num % 26;
            sb.append((char) (65 + (rem)));
            num = num / 26;
        }
        sb.append((char) (65 + (num - 1)));
        return sb.reverse().toString();
    }
}