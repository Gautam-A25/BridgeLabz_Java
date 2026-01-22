package stacks;
import java.util.Stack;

public class QUsingStacks {
    Stack<Integer> inStack = new Stack<>();
    Stack<Integer> outStack = new Stack<>();

    // Enqueue operation
    void enqueue(int value) {
        inStack.push(value);
    }
    // Dequeue operation
    int dequeue(){
        if(inStack.isEmpty() && outStack.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        if(outStack.isEmpty()){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public static void main(String[] args) {
        QUsingStacks queue = new QUsingStacks();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        System.out.println(queue.dequeue()); // Outputs 10
        System.out.println(queue.dequeue()); // Outputs 20
        System.out.println(queue.dequeue()); // Outputs 30
    }
}