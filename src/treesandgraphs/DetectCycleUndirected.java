package treesandgraphs;

import java.util.*;

/*
 * Program to detect cycle in an undirected graph
 */
public class DetectCycleUndirected {

    /**
     * DFS function with parent tracking
     */
    public static boolean dfsCycleCheck(List<List<Integer>> adjacencyList,
                                        boolean[] visited,
                                        int currentVertex,
                                        int parent) {

        visited[currentVertex] = true;

        for (int neighbor : adjacencyList.get(currentVertex)) {

            if (!visited[neighbor]) {
                if (dfsCycleCheck(adjacencyList, visited, neighbor, currentVertex)) {
                    return true;
                }
            }
            else if (neighbor != parent) {
                return true;  // Cycle detected
            }
        }

        return false;
    }

    public static boolean containsCycle(List<List<Integer>> adjacencyList,
                                        int numberOfVertices) {

        boolean[] visited = new boolean[numberOfVertices];

        for (int i = 0; i < numberOfVertices; i++) {

            if (!visited[i]) {
                if (dfsCycleCheck(adjacencyList, visited, i, -1)) {
                    return true;
                }
            }
        }

        return false;
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

        boolean result = containsCycle(adjacencyList, numberOfVertices);

        if (result) {
            System.out.println("Graph contains a cycle.");
        } else {
            System.out.println("Graph does NOT contain a cycle.");
        }
    }
}
