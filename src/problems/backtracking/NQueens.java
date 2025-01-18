package problems.backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
    static boolean isSafe(boolean[][] board, int row, int col, int n) {
        // Check current column
        for (int i = 0; i < row; i++)
            if (board[i][col]) return false;

        // upper left diagonal
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j]) return false;

        // up right diagonal
        for (int i = row, j = col; i >= 0 && j < n; i--, j++)
            if (board[i][j]) return false;

        return true;
    }

    static void backtrack(ArrayList<boolean[][]> solutions, boolean[][] board, int row, int n) {
        if (row == n) {
            boolean[][] solution = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                solution[i] = board[i].clone();
            }
            solutions.add(solution);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col, n)) {
                board[row][col] = true;
                backtrack(solutions, board, row + 1, n);
                board[row][col] = false;
            }
        }
    }

    static ArrayList<boolean[][]> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        for (boolean[] row : board)
            Arrays.fill(row, false);

        ArrayList<boolean[][]> solutions = new ArrayList<>();
        backtrack(solutions, board, 0, n);
        return solutions;
    }

    static void printSolution(boolean[][] board) {
        for (boolean[] row : board) {
            for (boolean cell : row) {
                if (cell) {
                    System.out.print(" Q");
                } else {
                    System.out.print(" .");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int idx = 1;
        for (boolean[][] board : solveNQueens(4)) {
            System.out.printf("Solution %d:\n", idx++);
            printSolution(board);
        }
    }
}
