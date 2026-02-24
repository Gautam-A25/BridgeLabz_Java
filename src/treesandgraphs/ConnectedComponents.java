package treesandgraphs;

import java.util.*;

/*
 * Program to count number of connected components
 */
public class ConnectedComponents {

    public static void dfs(List<List<Integer>> adjacencyList,
                           boolean[] visited,
                           int currentVertex) {

        visited[currentVertex] = true;

        for (int neighbor : adjacencyList.get(currentVertex)) {
            if (!visited[neighbor]) {
                dfs(adjacencyList, visited, neighbor);
            }
        }
    }

    public static int countComponents(List<List<Integer>> adjacencyList,
                                      int numberOfVertices) {

        boolean[] visited = new boolean[numberOfVertices];
        int componentCount = 0;

        for (int i = 0; i < numberOfVertices; i++) {

            if (!visited[i]) {
                dfs(adjacencyList, visited, i);
                componentCount++;
            }
        }

        return componentCount;
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

            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }

        int components = countComponents(adjacencyList, numberOfVertices);

        System.out.println("Number of Connected Components: " + components);
    }
}
