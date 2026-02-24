package treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Program to find Lowest Common Ancestor (LCA)
 */
public class LowestCommonAncestor {

    // Separate Tree Node class
    static class LCATreeNode {
        int value;
        LCATreeNode left;
        LCATreeNode right;

        LCATreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * Build tree using level order input
     */
    public static LCATreeNode buildTree(Scanner scanner) {

        System.out.print("Enter root value (-1 for no node): ");
        int rootValue = scanner.nextInt();

        if (rootValue == -1) {
            return null;
        }

        LCATreeNode root = new LCATreeNode(rootValue);
        Queue<LCATreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            LCATreeNode currentNode = queue.poll();

            System.out.print("Enter left child of " + currentNode.value + " (-1 for no node): ");
            int leftValue = scanner.nextInt();

            if (leftValue != -1) {
                currentNode.left = new LCATreeNode(leftValue);
                queue.add(currentNode.left);
            }

            System.out.print("Enter right child of " + currentNode.value + " (-1 for no node): ");
            int rightValue = scanner.nextInt();

            if (rightValue != -1) {
                currentNode.right = new LCATreeNode(rightValue);
                queue.add(currentNode.right);
            }
        }

        return root;
    }

    /**
     * Find LCA using recursion
     */
    public static LCATreeNode findLCA(LCATreeNode root, int p, int q) {

        if (root == null) {
            return null;
        }

        if (root.value == p || root.value == q) {
            return root;
        }

        LCATreeNode leftResult = findLCA(root.left, p, q);
        LCATreeNode rightResult = findLCA(root.right, p, q);

        if (leftResult != null && rightResult != null) {
            return root;
        }

        return (leftResult != null) ? leftResult : rightResult;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LCATreeNode root = buildTree(scanner);

        System.out.print("Enter first node value (p): ");
        int p = scanner.nextInt();

        System.out.print("Enter second node value (q): ");
        int q = scanner.nextInt();

        LCATreeNode lca = findLCA(root, p, q);

        if (lca != null) {
            System.out.println("Lowest Common Ancestor: " + lca.value);
        } else {
            System.out.println("LCA not found.");
        }
    }
}

