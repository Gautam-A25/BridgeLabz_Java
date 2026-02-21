package designpattern;

interface Command {
    void execute();
}

// Receiver
class LightDevice {
    public void turnOn() {
        System.out.println("Light ON");
    }

    public void turnOff() {
        System.out.println("Light OFF");
    }
}

// Concrete Commands
class LightOnCommand implements Command {

    private LightDevice light;

    public LightOnCommand(LightDevice light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {

    private LightDevice light;

    public LightOffCommand(LightDevice light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

// Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

public class CommandDemo {
    public static void main(String[] args) {

        LightDevice light = new LightDevice();
        RemoteControl remote = new RemoteControl();

        remote.setCommand(new LightOnCommand(light));
        remote.pressButton();

        remote.setCommand(new LightOffCommand(light));
        remote.pressButton();
    }
}
