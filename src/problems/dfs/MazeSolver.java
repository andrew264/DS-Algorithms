package problems.dfs;

import java.util.ArrayList;
import java.util.Arrays;

public class MazeSolver {
    static int[][] dirs = {  // directions
            {0, -1},  // up
            {0, 1},  // down
            {-1, 0},  // left
            {1, 0},  // right
    };

    static boolean walk(String[] maze, char wall, Point curr, Point end, boolean[][] seen, ArrayList<Point> path) {
        // maze: 2d array of strings
        // wall: string that represents a wall
        // curr: current point
        // end: end point
        // seen: 2d array of booleans
        // path: list of points that represent the path

        // Base Conditions
        // don't walk off the map
        if (curr.x < 0 || curr.x >= maze[0].length() || curr.y < 0 || curr.y >= maze.length)  // return false if the curr Point is out of bounds
            return false;

        // we can't go through walls
        if (maze[curr.y].charAt(curr.x) == wall)  // return false if the curr Point is a wall
            return false;

        // are we at the goal ?
        if (curr.equals(end)) {  // return true if current and end are the same
            path.add(curr);
            return true;
        }

        // have we been here already
        if (seen[curr.y][curr.x])  // return false if the curr Point has been seen
            return false;


        // there are 3 parts in a recursion
        // pre - do something before the recursion
        seen[curr.y][curr.x] = true;
        path.add(curr);

        // recurse
        for (int[] dir : dirs) {
            Point next_point = curr.move(dir);
            if (walk(maze, wall, next_point, end, seen, path)) {  // return true if we have a successful walk
                return true;
            }
        }

        // post - do something after the recursion
        path.remove(path.size() - 1);

        return false;  // no way to the end
    }


    static ArrayList<Point> solve(String[] maze, char wall, Point start, Point end) {
        ArrayList<Point> path = new ArrayList<>();
        boolean[][] seen = new boolean[maze.length][maze[0].length()];
        // fill seen with false
        for (int i = 0; i < maze.length; i++)
            Arrays.fill(seen[i], false);

        walk(maze, wall, start, end, seen, path);
        return path;

    }

    public static void main(String[] args) {
        String[] maze = {
                "##########E#",
                "#       ## #",
                "#       ## #",
                "# ######## #",
                "#          #",
                "#S##########",
        };
        char wall = '#';
        Point start = new Point(1, 5);
        Point end = new Point(10, 0);
        System.out.println("Maze:");
        for (String row : maze) {
            System.out.println(row);
        }
        System.out.println("Start: " + start);
        System.out.println("End: " + end);
        ArrayList<Point> path = solve(maze, wall, start, end);
        if (path.isEmpty()) {
            System.out.println("No path found");
            return;
        }
        for (Point point : path) {
            System.out.print(point);
            if (!point.equals(end)) {
                System.out.print(" -> ");
            }
        }

    }

    private static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean equals(Point other) {
            return this.x == other.x && this.y == other.y;
        }

        Point move(int[] dir) {
            // move in the direction dir
            return new Point(this.x + dir[0], this.y + dir[1]);
        }

        @Override
        public String toString() {
            return "(" + this.x + ", " + this.y + ")";
        }
    }
}
