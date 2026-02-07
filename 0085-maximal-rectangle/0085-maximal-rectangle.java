class Solution {
    int rows, cols;
    int maxArea = 0;
    char[][] mat;

    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;

        mat = matrix;
        rows = matrix.length;
        cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == '1') {
                    expandDown(i, j);
                }
            }
        }
        return maxArea;
    }

    // fix top-left at (r,c), expand downward
    void expandDown(int r, int c) {
        int minWidth = Integer.MAX_VALUE;

        for (int i = r; i < rows; i++) {
            if (mat[i][c] == '0') break;

            int width = expandRight(i, c);
            minWidth = Math.min(minWidth, width);

            int height = i - r + 1;
            maxArea = Math.max(maxArea, height * minWidth);
        }
    }

    // count continuous 1s to the right
    int expandRight(int r, int c) {
        int j = c;
        while (j < cols && mat[r][j] == '1') {
            j++;
        }
        return j - c;
    }
}
