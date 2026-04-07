class Solution {
    public String decodeCiphertext(String text, int rows) {
        int n = text.length();
        if (rows == 0) return "";
        StringBuilder str = new StringBuilder(); 
        int col = text.length() / rows;
        int temp = col;
        int idx = 0;
        while (temp > 0) {
            int k = idx;
            for (int i = 0; i < rows; i++) {
                int pos = col * i + k;
                if (pos < text.length()) {
                    str.append(text.charAt(pos)); 
                }
                k++;
            }
            idx++;
            temp--;
        }
        return str.toString().replaceAll("\\s+$", "");
    }
}