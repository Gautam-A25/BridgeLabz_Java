package stacks;
import java.util.Stack;

public class SortUsingRec {
    // Function to sort the stack using recursion
    static void sortStack(Stack<Integer> stack){
        if(stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        sortStack(stack);
        insertSorted(stack, top);
    }
    // Helper function to insert an element in sorted order
    static void insertSorted(Stack<Integer> stack, int value){
        if(stack.isEmpty() || stack.peek() <= value){
            stack.push(value);
            return;
        }

        int temp = stack.pop();
        insertSorted(stack, value);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
