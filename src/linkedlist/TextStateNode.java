package linkedlist;

/*
8. Doubly Linked List: Undo/Redo Functionality for Text Editor
Problem Statement: Design undo/redo functionality using a doubly linked list.
Each node represents a state of the text content.

Implement:
- Add a new state at the end when user types/actions.
- Undo (move to previous state).
- Redo (move to next state after undo).
- Display current state.
- Limit history to fixed size (last 10 states).

Hint:
- next = redo, prev = undo.
- Track current state pointer.
*/

class TextState {
    String text;
    TextState next, prev;

    TextState(String text) {
        this.text = text;
        this.next = null;
        this.prev = null;
    }
}

class TextEditorHistory {
    private TextState head, tail, current;
    private int size = 0;
    private final int MAX_SIZE = 10;

    // Add new state at end, clear redo history if user types after undo
    public void addState(String text) {
        TextState newNode = new TextState(text);

        // If there are redo states, remove them
        if (current != null && current.next != null) {
            TextState temp = current.next;

            while (temp != null) {
                TextState nxt = temp.next;
                temp.next = null;
                temp.prev = null;
                temp = nxt;
                size--;
            }

            current.next = null;
            tail = current;
        }

        // First state
        if (head == null) {
            head = tail = current = newNode;
            size = 1;
            return;
        }

        // Add at end
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        current = newNode;
        size++;

        // Maintain fixed size history (remove from beginning)
        if (size > MAX_SIZE) {
            TextState oldHead = head;
            head = head.next;

            if (head != null) {
                head.prev = null;
            }

            oldHead.next = null; // cleanup
            size--;
        }
    }

    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo.");
            return;
        }
        current = current.prev;
        System.out.println("Undo done.");
    }

    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo.");
            return;
        }
        current = current.next;
        System.out.println("Redo done.");
    }

    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No text state.");
            return;
        }
        System.out.println("Current Text: " + current.text);
    }
}

public class TextStateNode {
    public static void main(String[] args) {

        TextEditorHistory editor = new TextEditorHistory();

        editor.addState("H");
        editor.addState("He");
        editor.addState("Hel");
        editor.addState("Hell");
        editor.addState("Hello");

        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.undo();
        editor.displayCurrentState();

        editor.redo();
        editor.displayCurrentState();

        // typing after undo clears redo history
        editor.addState("Hello World!");
        editor.displayCurrentState();

        editor.redo(); // should fail
    }
}
