package treesandgraphs;

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class HeightOfBinaryTree {


    public static int findHeight(TreeNode root) {

        // Base Case: If tree is empty
        if (root == null) {
            return -1;
        }

        // Recursively find height of left subtree
        int leftHeight = findHeight(root.left);

        // Recursively find height of right subtree
        int rightHeight = findHeight(root.right);

        // Return the maximum height + 1 (for current node)
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Main method for testing
    public static void main(String[] args) {

        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        int height = findHeight(root);

        System.out.println("Height of the Binary Tree: " + height);
    }
}
