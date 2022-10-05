package main.java.cmnguyen.problems.medium.bfs;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j =0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, String word, int row, int column, int d) {
        if (d >= word.length()) return true;
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length)
            return false;

        if (board[row][column] != word.charAt(d)) return false;

        char temp = board[row][column];
        board[row][column] = '#';

        boolean result =  dfs(board, word, row + 1, column, d+1) ||
                dfs(board, word, row - 1, column, d+1) ||
                dfs(board, word, row, column + 1, d+1) ||
                dfs(board, word, row, column - 1, d+1);
        board[row][column] = temp;

        return result;
    }

}
