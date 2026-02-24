package treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Program to find Diameter of a Binary Tree
 */
public class DiameterOfBinaryTree {

    // Separate Tree Node class
    static class DiameterTreeNode {
        int value;
        DiameterTreeNode left;
        DiameterTreeNode right;

        DiameterTreeNode(int value) {
            this.value = value;
        }
    }

    private static int diameter = 0;

    /**
     * Build tree using level order input
     */
    public static DiameterTreeNode buildTree(Scanner scanner) {

        System.out.print("Enter root value (-1 for no node): ");
        int rootValue = scanner.nextInt();

        if (rootValue == -1) {
            return null;
        }

        DiameterTreeNode root = new DiameterTreeNode(rootValue);
        Queue<DiameterTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            DiameterTreeNode currentNode = queue.poll();

            System.out.print("Enter left child of " + currentNode.value + " (-1 for no node): ");
            int leftValue = scanner.nextInt();

            if (leftValue != -1) {
                currentNode.left = new DiameterTreeNode(leftValue);
                queue.add(currentNode.left);
            }

            System.out.print("Enter right child of " + currentNode.value + " (-1 for no node): ");
            int rightValue = scanner.nextInt();

            if (rightValue != -1) {
                currentNode.right = new DiameterTreeNode(rightValue);
                queue.add(currentNode.right);
            }
        }

        return root;
    }

    /**
     * Optimized method to calculate diameter
     */
    private static int calculateHeight(DiameterTreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Update diameter
        diameter = Math.max(diameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int findDiameter(DiameterTreeNode root) {

        diameter = 0;
        calculateHeight(root);
        return diameter;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        DiameterTreeNode root = buildTree(scanner);

        int result = findDiameter(root);

        System.out.println("Diameter of the Binary Tree: " + result);
    }
}
