class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!isValidHelper(board, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isValidHelper(char[][] board, int i, int j) {
        char val = board[i][j];

        // Check row
        for (int k = 0; k < 9; k++) {
            if (k != j && board[i][k] == val) {
                return false;
            }
        }

        // Check column
        for (int l = 0; l < 9; l++) {
            if (l != i && board[l][j] == val) {
                return false;
            }
        }

        // Check 3x3 box
        int boxRow = i - (i % 3);
        int boxCol = j - (j % 3);
        for (int m = boxRow; m < boxRow + 3; m++) {
            for (int n = boxCol; n < boxCol + 3; n++) {
                if ((m != i || n != j) && board[m][n] == val) {
                    return false;
                }
            }
        }

        return true;
    }
}