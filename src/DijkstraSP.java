import java.util.*;

public class DijkstraSP {
    // Dijkstra's algorithm using an adjacency list
    // Returns the shortest path from the start node to all other nodes
    static ArrayList<Integer> dijkstraList(int source, int sink, GraphEdge[][] graph) {
        if (graph == null || graph.length == 0)
            return new ArrayList<>();  // if the graph is empty, return an empty list
        if (source < 0 || source >= graph.length || sink < 0 || sink >= graph.length)
            return new ArrayList<>();  // if the source or sink are out of bounds, return an empty list

        int[] distance = new int[graph.length];  // the distance array contains the shortest distance from the source to each node
        Arrays.fill(distance, Integer.MAX_VALUE);  // distance array
        distance[source] = 0;  // distance from source to source is 0

        PriorityQueue<GraphEdge> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));  // priority queue to store the next node to visit
        pq.add(new GraphEdge(source, 0));  // add source to the priority queue

        while (!pq.isEmpty()) {  // while the priority queue is not empty
            GraphEdge current = pq.poll();  // get the node with the smallest weight
            for (GraphEdge next : graph[current.to]) {  // iterate through the neighbors of the current node
                int newDistance = distance[current.to] + next.weight;  // calculate the new distance
                if (newDistance < distance[next.to]) {  // if the new distance is less than the current distance
                    distance[next.to] = newDistance;  // update the distance array
                    pq.add(new GraphEdge(next.to, newDistance));  // add the neighbor to the priority queue
                }
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        int current = sink;  // start from the sink node
        while (current != source) {  // while we haven't reached the source node
            result.add(current);  // add the current node to the result
            for (GraphEdge next : graph[current]) {  // for each neighbor of the current node
                if (distance[current] == distance[next.to] + next.weight) {  // if the distance is correct
                    current = next.to;  // move to the next node
                    break;
                }
            }
        }
        result.add(source);  // add the source node to the result
        Collections.reverse(result);  // reverse the result list
        return result;
    }


    public static void main(String[] args) {
        GraphEdge[][] graph = new GraphEdge[7][];
        //      (1) --- (4) ---- (5)
        //    /  |       |       /|
        // (0)   | ------|------- |
        //    \  |/      |        |
        //      (2) --- (3) ---- (6)
        graph[0] = new GraphEdge[]{new GraphEdge(1, 3), new GraphEdge(2, 1)};
        graph[1] = new GraphEdge[]{new GraphEdge(0, 3), new GraphEdge(2, 4), new GraphEdge(4, 1)};
        graph[2] = new GraphEdge[]{new GraphEdge(0, 1), new GraphEdge(1, 4), new GraphEdge(3, 7)};
        graph[3] = new GraphEdge[]{new GraphEdge(2, 7), new GraphEdge(4, 5), new GraphEdge(6, 1)};
        graph[4] = new GraphEdge[]{new GraphEdge(1, 1), new GraphEdge(3, 5), new GraphEdge(5, 2)};
        graph[5] = new GraphEdge[]{new GraphEdge(4, 2), new GraphEdge(6, 1), new GraphEdge(2, 18)};
        graph[6] = new GraphEdge[]{new GraphEdge(3, 1), new GraphEdge(5, 1)};

        ArrayList<Integer> result = dijkstraList(0, 6, graph); // [0, 1, 4, 5, 6]
        System.out.println("Shortest path from 0 to 6: " + result);

    }
}
