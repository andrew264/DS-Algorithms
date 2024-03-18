package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class GraphBFSMatrix {
    // BFS using an adjacency matrix
    // Returns the path from the start node to the target node
    static ArrayList<Integer> bfs(int[][] adjMat, int start, int target) {

        if (start == target) {  // if the start and target are the same, return a path of length 1
            ArrayList<Integer> path = new ArrayList<>();
            path.add(start);
            return path;
        }

        // seen array will keep track of which nodes have been visited
        boolean[] seen = new boolean[adjMat.length];
        Arrays.fill(seen, false);  // mark all nodes as unseen
        // prev array will keep track of the previous node in the path
        int[] prev = new int[adjMat.length];
        Arrays.fill(prev, -1);  // mark all nodes as having no previous node

        seen[start] = true;  // mark start as seen
        LinkedList<Integer> queue = new LinkedList<>();  // create a queue for the BFS
        queue.offer(start);  // add the start node to the queue

        while (!queue.isEmpty()) {
            int current = queue.poll();  // dequeue the current node

            if (current == target)
                break;  // if the current node is the target, break

            int[] adj = adjMat[current];
            for (int i = 0; i < adj.length; i++) {
                if (adj[i] != 0 && !seen[i]) {  // if there is an edge and the node has not been seen
                    seen[i] = true;  // mark the node as seen
                    prev[i] = current;  // set the previous node
                    queue.offer(i);  // enqueue the node
                }
            }
        }

        if (prev[target] == -1)  // if the target node has no previous node, there is no path
            return null;

        ArrayList<Integer> path = new ArrayList<>();  // create a queue for the path
        int current = target;
        while (current != -1) {  // loop until the start node is reached
            path.add(current);  // add the current node to the path
            current = prev[current];  // set the current node to the previous node
        }
        Collections.reverse(path);  // reverse the path so it is in the correct order
        return path;
    }

    public static void main(String[] args) {
        //     >(1)<--->(4) ---->(5)
        //    /          |       /|
        // (0)     ------|------- |
        //    \   v      v        v
        //     >(2) --> (3) <----(6)
        int[][] adjMat = {
                {0, 3, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 7, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 5, 0, 2, 0},
                {0, 0, 18, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 0, 1}
        };

        ArrayList<Integer> path = bfs(adjMat, 0, 6);
        System.out.println("Path [0-6]: " + path);  //[0, 1, 4, 5, 6]
        ArrayList<Integer> path2 = bfs(adjMat, 1, 3);
        System.out.println("Path [1-3]: " + path2);  //[0, 1, 4, 3]
        System.out.println("Path [3-3]: " + bfs(adjMat, 3, 3));  // [3]
    }
}
