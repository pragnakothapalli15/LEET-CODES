class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[2 * n - 1];
        boolean[] antiDiag = new boolean[2 * n - 1];

        backtrack(0, n, board, cols, diag, antiDiag);

        return result;
    }

    private void backtrack(int row, int n, char[][] board,
                           boolean[] cols,
                           boolean[] diag,
                           boolean[] antiDiag) {

        if (row == n) {
            List<String> temp = new ArrayList<>();
            for (char[] r : board) {
                temp.add(new String(r));
            }
            result.add(temp);
            return;
        }

        for (int col = 0; col < n; col++) {

            int d = row - col + n - 1;
            int ad = row + col;

            if (cols[col] || diag[d] || antiDiag[ad]) {
                continue;
            }

            board[row][col] = 'Q';
            cols[col] = true;
            diag[d] = true;
            antiDiag[ad] = true;

            backtrack(row + 1, n, board, cols, diag, antiDiag);

            board[row][col] = '.';
            cols[col] = false;
            diag[d] = false;
            antiDiag[ad] = false;
        }
    }
}
