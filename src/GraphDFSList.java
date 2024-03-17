import java.util.ArrayList;
import java.util.Arrays;

public class GraphDFSList {
    // DFS using an adjacency list
    // Returns the path from the start node to the target node
    // Complexity: O(V + E)  (V = number of vertices, E = number of edges)
    static boolean walk(GraphEdge[][] graph, int current, int target, boolean[] seen, ArrayList<Integer> path) {
        if (seen[current])
            return false;  // if the current node has been seen, return false
        seen[current] = true;  // mark the current node as seen

        // pre
        path.add(current);  // add the current node to the path
        if (current == target)
            return true;  // if the current node is the target, return true

        // recurse
        for (GraphEdge edge : graph[current]) {  // for each edge from the current node
            if (walk(graph, edge.to, target, seen, path))  // if there is a successful walk, return true
                return true;  // return true if there is a successful walk
        }

        // post
        path.remove(path.size() - 1);  // remove the current node from the path since it was not part of a successful walk
        return false;  // return false since there was no successful walk
    }

    public static void main(String[] args) {
        //     >(1)<--->(4) ---->(5)
        //    /          |       /|
        // (0)     ------|------- |
        //    \   v      v        v
        //     >(2) --> (3) <----(6)
        GraphEdge[][] adjList = new GraphEdge[7][];
        adjList[0] = new GraphEdge[]{new GraphEdge(1, 3), new GraphEdge(2, 1)};
        adjList[1] = new GraphEdge[]{new GraphEdge(4, 1)};
        adjList[2] = new GraphEdge[]{new GraphEdge(3, 7)};
        adjList[3] = new GraphEdge[]{};
        adjList[4] = new GraphEdge[]{new GraphEdge(1, 1), new GraphEdge(3, 5), new GraphEdge(5, 2)};
        adjList[5] = new GraphEdge[]{new GraphEdge(2, 18), new GraphEdge(6, 1)};
        adjList[6] = new GraphEdge[]{new GraphEdge(3, 1)};

        boolean[] seen = new boolean[adjList.length];  // create a seen array
        Arrays.fill(seen, false);  // mark all nodes as unseen
        ArrayList<Integer> path = new ArrayList<>();
        walk(adjList, 0, 6, seen, path);  // walk from node 0 to node 6
        System.out.println(path); // [0, 1, 4, 5, 6]

    }
}
