package problems;

public class NumIslands {
    // Number of islands problem
    // Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
    // An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    static int[][] dirs = {  // directions
            {0, -1},  // up
            {0, 1},  // down
            {-1, 0},  // left
            {1, 0},  // right
    };

    static int numIslands(boolean[][] grid) {
        int numIslands = 0;  // counter for the number of islands
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]) numIslands++;  // increment the counter if the cell is land
                dfs(grid, i, j);  // call the dfs function
            }
        }

        return numIslands;
    }

    static void dfs(boolean[][] grid, int i, int j) {
        // conditions to return
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;  // return if the cell is out of bounds
        if (!grid[i][j]) return;  // return if the cell is water

        // set the cell to water and call the dfs function for the adjacent cells
        grid[i][j] = false;  // set the cell to water
        for (int[] dir : dirs) {
            dfs(grid, i + dir[0], j + dir[1]);  // dfs in all 4 directions
        }
    }

    public static void main(String[] args) {
        boolean[][] grid = {
                {true, true, true, false, false, true, false, true},
                {true, true, false, false, true, true, true, true},
                {false, true, false, false, false, true, true, true},
                {false, false, false, true, false, false, true, true},
                {true, true, false, true, true, false, false, false},
                {false, false, false, false, false, false, true, true},
                {false, false, false, true, false, true, false, false},
                {true, false, false, true, true, true, true, true}
        };
        System.out.println("Grid: ");
        for (boolean[] row : grid) {
            for (boolean cell : row) {
                String colorCode = cell ? "\u001B[32m" : "\u001B[34m"; // Green for land, Blue for water
                System.out.print(" " + colorCode + (cell ? "1" : "0") + " " + "\u001B[0m"); // Reset color
            }
            System.out.println();
        }
        System.out.println("Number of islands: " + numIslands(grid));

    }
}
