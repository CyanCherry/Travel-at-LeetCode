package A_Array;

public class J_ValidSudoku {
    static boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] column = new boolean[9][9];
        boolean[][][] box = new boolean[3][3][9];
        for (int index = 0; index < board.length; index++) {
            for (int innerIndex = 0; innerIndex < board[index].length; innerIndex++) {
                if (board[index][innerIndex] == '.')
                    continue;
                int digit = board[index][innerIndex] - '1';
                if (row[index][digit])
                    return false;
                if (column[innerIndex][digit])
                    return false;
                if (box[index / 3][innerIndex / 3][digit])
                    return false;
                row[index][digit] = true;
                column[innerIndex][digit] = true;
                box[index / 3][innerIndex / 3][digit] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Boolean.TRUE.equals(isValidSudoku(new char[][]{
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        })));
        System.out.println(Boolean.FALSE.equals(isValidSudoku(new char[][]{
            {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        })));
    }
}
