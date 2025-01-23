package problems.backtracking;

import java.util.Arrays;

public class Sudoku {
    public static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < 9; i++)
            if (board[row][i] == num || board[i][col] == num) return false;  // diagonals

        int subCol = 3 * (col / 3);
        int subRow = 3 * (row / 3);
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[subRow + i][subCol + j] == num) return false;  // 3x3 subgrid

        return true;
    }

    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < 9; row++)
            for (int col = 0; col < 9; col++)
                if (board[row][col] == 0) {
                    for (int num = 1; num < 10; num++)
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solveSudoku(board)) return true;
                            board[row][col] = 0;
                        }
                    return false;
                }
        return true;
    }

    public static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int n : row) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] board1 = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9},
        };
        if (solveSudoku(board1)) {
            System.out.println("Solution");
            printBoard(board1);
        } else {
            System.out.println("No Solution");
        }
        System.out.println();
        int[][] board2 = new int[9][9];
        for (int[] row : board2) {
            Arrays.fill(row, 0);
        }
        if (solveSudoku(board2)) {
            System.out.println("Solution");
            printBoard(board2);
        } else {
            System.out.println("No Solution");
        }
    }
}
