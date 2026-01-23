package hashmap;

class CustomHashmap {
    private static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 1000;
    private Node[] table;

    public CustomHashmap() {
        table = new Node[SIZE];
    }

    private int hash(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = hash(key);
        Node head = table[index];

        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        table[index] = newNode;
    }

    public int get(int key) {
        int index = hash(key);
        for (Node curr = table[index]; curr != null; curr = curr.next) {
            if (curr.key == key) return curr.value;
        }
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = table[index], prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) table[index] = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}
