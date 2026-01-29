package collections;

public class CircularBuffer {

    int[] buffer;
    int size, index = 0;

    CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
    }

    void insert(int value) {
        buffer[index % size] = value;
        index++;
    }

    void display() {
        for (int i = 0; i < size; i++)
            System.out.print(buffer[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.insert(4);

        cb.display();
    }
}

