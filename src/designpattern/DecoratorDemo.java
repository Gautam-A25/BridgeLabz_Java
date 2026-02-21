package designpattern;

interface Coffee {
    int cost();
}

class SimpleCoffee implements Coffee {
    public int cost() {
        return 50;
    }
}

abstract class CoffeeDecorator implements Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}

class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public int cost() {
        return coffee.cost() + 20;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public int cost() {
        return coffee.cost() + 10;
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {

        Coffee coffee = new SimpleCoffee();
        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println("Total Cost: " + coffee.cost());
    }
}