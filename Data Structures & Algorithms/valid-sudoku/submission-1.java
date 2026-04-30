class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] subGrids = new boolean[9][9];

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                int digit = board[i][j] - '1';
                int subgridIndex = (i/3) * 3 + (j/3);

                if(board[i][j] != '.'){
                    if(rows[digit][i] || cols[digit][j] || subGrids[digit][subgridIndex]){
                        return false;
                    }

                    rows[digit][i] = true;
                    cols[digit][j] = true;
                    subGrids[digit][subgridIndex] = true;
                }
            }
        }
        return true;
    }
}
