package treesandgraphs;

import java.util.*;

/*
 * Program to perform DFS traversal of a graph
 */
public class DFSTraversal {

    /**
     * Perform DFS using recursion
     */
    public static void performDFS(List<List<Integer>> adjacencyList,
                                  boolean[] visited,
                                  int currentVertex) {

        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");

        for (int neighbor : adjacencyList.get(currentVertex)) {

            if (!visited[neighbor]) {
                performDFS(adjacencyList, visited, neighbor);
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

        boolean[] visited = new boolean[numberOfVertices];

        System.out.print("DFS Traversal: ");
        performDFS(adjacencyList, visited, startVertex);
    }
}
