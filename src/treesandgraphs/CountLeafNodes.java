package treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Program to count leaf nodes in a binary tree
 */
public class CountLeafNodes {

    // Separate Tree Node class for this program
    static class LeafTreeNode {
        int value;
        LeafTreeNode left;
        LeafTreeNode right;

        LeafTreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * Build tree using level order input
     */
    public static LeafTreeNode buildTree() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter root value (-1 for no node): ");
        int rootValue = scanner.nextInt();

        if (rootValue == -1) {
            return null;
        }

        LeafTreeNode root = new LeafTreeNode(rootValue);
        Queue<LeafTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            LeafTreeNode currentNode = queue.poll();

            System.out.print("Enter left child of " + currentNode.value + " (-1 for no node): ");
            int leftValue = scanner.nextInt();

            if (leftValue != -1) {
                currentNode.left = new LeafTreeNode(leftValue);
                queue.add(currentNode.left);
            }

            System.out.print("Enter right child of " + currentNode.value + " (-1 for no node): ");
            int rightValue = scanner.nextInt();

            if (rightValue != -1) {
                currentNode.right = new LeafTreeNode(rightValue);
                queue.add(currentNode.right);
            }
        }

        return root;
    }

    /**
     * Count leaf nodes using recursion
     */
    public static int countLeafNodes(LeafTreeNode root) {

        // Base case
        if (root == null) {
            return 0;
        }

        // If no left and right child → leaf node
        if (root.left == null && root.right == null) {
            return 1;
        }

        // Recursive traversal
        return countLeafNodes(root.left) + countLeafNodes(root.right);
    }

    public static void main(String[] args) {

        LeafTreeNode root = buildTree();

        int leafCount = countLeafNodes(root);

        System.out.println("Number of Leaf Nodes: " + leafCount);
    }
}
