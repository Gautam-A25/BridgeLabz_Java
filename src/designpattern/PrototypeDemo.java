package designpattern;

class PrototypeEmployee implements Cloneable {

    private String name;

    public PrototypeEmployee(String name) {
        this.name = name;
    }

    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void show() {
        System.out.println(name);
    }
}

public class PrototypeDemo {
    public static void main(String[] args) throws Exception {

        PrototypeEmployee emp1 = new PrototypeEmployee("Nehaa");
        PrototypeEmployee emp2 = (PrototypeEmployee) emp1.clone();

        emp1.show();
        emp2.show();
    }
}