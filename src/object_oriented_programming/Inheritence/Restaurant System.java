package object_oriented_programming.Inheritence;

interface Worker {
    void performDuties();
}

class PersonBase {
    String name;
    int id;

    PersonBase(String name, int id) {
        this.name = name;
        this.id = id;
    }
}

class Chef extends PersonBase implements Worker {
    Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println("Cooking food");
    }
}

class Waiter extends PersonBase implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println("Serving customers");
    }
}

