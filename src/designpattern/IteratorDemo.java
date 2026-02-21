package designpattern;

import java.util.ArrayList;
import java.util.List;

class NameRepository {

    private List<String> names = new ArrayList<>();

    public NameRepository() {
        names.add("Nehaa");
        names.add("Riya");
        names.add("Aman");
    }

    public NameIterator getIterator() {
        return new NameIterator();
    }

    // Custom Iterator
    class NameIterator {
        private int index = 0;

        public boolean hasNext() {
            return index < names.size();
        }

        public String next() {
            return names.get(index++);
        }
    }
}

public class IteratorDemo {
    public static void main(String[] args) {

        NameRepository repository = new NameRepository();
        NameRepository.NameIterator iterator = repository.getIterator();

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
