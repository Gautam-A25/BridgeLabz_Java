package treesandgraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Program to validate whether a binary tree is a BST
 */
public class ValidateBST {

    // Separate Tree Node class for this program
    static class BSTTreeNode {
        int value;
        BSTTreeNode left;
        BSTTreeNode right;

        BSTTreeNode(int value) {
            this.value = value;
        }
    }

    private static Integer previousValue = null;

    /**
     * Build tree using level order input
     */
    public static BSTTreeNode buildTree() {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter root value (-1 for no node): ");
        int rootValue = scanner.nextInt();

        if (rootValue == -1) {
            return null;
        }

        BSTTreeNode root = new BSTTreeNode(rootValue);
        Queue<BSTTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            BSTTreeNode currentNode = queue.poll();

            System.out.print("Enter left child of " + currentNode.value + " (-1 for no node): ");
            int leftValue = scanner.nextInt();

            if (leftValue != -1) {
                currentNode.left = new BSTTreeNode(leftValue);
                queue.add(currentNode.left);
            }

            System.out.print("Enter right child of " + currentNode.value + " (-1 for no node): ");
            int rightValue = scanner.nextInt();

            if (rightValue != -1) {
                currentNode.right = new BSTTreeNode(rightValue);
                queue.add(currentNode.right);
            }
        }

        return root;
    }

    /**
     * Validate BST using inorder traversal
     */
    public static boolean isValidBST(BSTTreeNode root) {

        previousValue = null;
        return inorderCheck(root);
    }

    private static boolean inorderCheck(BSTTreeNode node) {

        if (node == null) {
            return true;
        }

        // Check left subtree
        if (!inorderCheck(node.left)) {
            return false;
        }

        // BST condition
        if (previousValue != null && node.value <= previousValue) {
            return false;
        }

        previousValue = node.value;

        // Check right subtree
        return inorderCheck(node.right);
    }

    public static void main(String[] args) {

        BSTTreeNode root = buildTree();

        boolean isBST = isValidBST(root);

        if (isBST) {
            System.out.println("The tree is a VALID BST.");
        } else {
            System.out.println("The tree is NOT a BST.");
        }
    }
}
