package designpattern;

interface Expression {
    int interpret();
}

class NumberExpression implements Expression {
    private int number;

    public NumberExpression(int number) {
        this.number = number;
    }

    public int interpret() {
        return number;
    }
}

class AddExpression implements Expression {

    private Expression left;
    private Expression right;

    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public int interpret() {
        return left.interpret() + right.interpret();
    }
}

public class InterpreterDemo {
    public static void main(String[] args) {

        Expression five = new NumberExpression(5);
        Expression three = new NumberExpression(3);

        Expression addition = new AddExpression(five, three);

        System.out.println("Result: " + addition.interpret());
    }
}
