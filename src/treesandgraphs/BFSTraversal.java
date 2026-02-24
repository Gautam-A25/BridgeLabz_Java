package treesandgraphs;

import java.util.*;

/*
 * Program to perform BFS traversal of an undirected graph
 */
public class BFSTraversal {

    /**
     * Perform BFS traversal
     */
    public static void performBFS(List<List<Integer>> adjacencyList,
                                  int numberOfVertices,
                                  int startVertex) {

        boolean[] visited = new boolean[numberOfVertices];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {

            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int neighbor : adjacencyList.get(currentVertex)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int numberOfVertices = scanner.nextInt();

        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < numberOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        System.out.print("Enter number of edges: ");
        int numberOfEdges = scanner.nextInt();

        System.out.println("Enter edges (source destination):");

        for (int i = 0; i < numberOfEdges; i++) {

            int source = scanner.nextInt();
            int destination = scanner.nextInt();

            // Undirected graph
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }

        System.out.print("Enter starting vertex: ");
        int startVertex = scanner.nextInt();

        performBFS(adjacencyList, numberOfVertices, startVertex);
    }
}
