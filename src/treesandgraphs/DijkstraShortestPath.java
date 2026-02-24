package treesandgraphs;

import java.util.*;

/*
 * Program to find shortest path using Dijkstra's Algorithm
 */
public class DijkstraShortestPath {

    static class Edge {
        int destination;
        int weight;

        Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public static void dijkstra(List<List<Edge>> adjacencyList,
                                int numberOfVertices,
                                int source) {

        int[] distance = new int[numberOfVertices];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        PriorityQueue<Edge> minHeap =
                new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        minHeap.add(new Edge(source, 0));

        while (!minHeap.isEmpty()) {

            Edge current = minHeap.poll();

            for (Edge neighbor : adjacencyList.get(current.destination)) {

                int newDistance =
                        distance[current.destination] + neighbor.weight;

                if (newDistance < distance[neighbor.destination]) {
                    distance[neighbor.destination] = newDistance;
                    minHeap.add(new Edge(neighbor.destination, newDistance));
                }
            }
        }

        System.out.println("Shortest distances from source:");
        for (int i = 0; i < numberOfVertices; i++) {
            System.out.println("To " + i + " → " + distance[i]);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int numberOfVertices = scanner.nextInt();

        List<List<Edge>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < numberOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        System.out.print("Enter number of edges: ");
        int numberOfEdges = scanner.nextInt();

        System.out.println("Enter edges (source destination weight):");

        for (int i = 0; i < numberOfEdges; i++) {

            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            int weight = scanner.nextInt();

            adjacencyList.get(source).add(new Edge(destination, weight));
            adjacencyList.get(destination).add(new Edge(source, weight));
        }

        System.out.print("Enter source vertex: ");
        int source = scanner.nextInt();

        dijkstra(adjacencyList, numberOfVertices, source);
    }
}
