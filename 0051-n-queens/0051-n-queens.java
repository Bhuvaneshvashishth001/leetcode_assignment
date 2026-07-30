class Solution {

    public static ArrayList<String> generate(byte[][] board, int n) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    sb.append("Q");
                } else {
                    sb.append(".");
                }
            }
            list.add(sb.toString());
        }

        return list;
    }

    public static boolean issafe(byte[][] board, int row, int col, int n) {

        int row1 = row;
        int col1 = col;

        while (row1 >= 0 && col1 >= 0) {
            if (board[row1][col1] == 1)
                return false;
            row1--;
            col1--;
        }

        row1 = row;
        col1 = col;

        while (col1 >= 0) {
            if (board[row1][col1] == 1)
                return false;
            col1--;
        }

        row1 = row;
        col1 = col;

        while (row1 < n && col1 >= 0) {
            if (board[row1][col1] == 1)
                return false;
            row1++;
            col1--;
        }

        return true;
    }

    public static void helper(byte[][] board, int col,
                              List<List<String>> result, int n) {

        if (col >= n) {
            result.add(generate(board, n));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (issafe(board, row, col, n)) {
                board[row][col] = 1;
                helper(board, col + 1, result, n);
                board[row][col] = 0;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();
        byte[][] board = new byte[n][n];

        helper(board, 0, result, n);

        return result;
    }
}