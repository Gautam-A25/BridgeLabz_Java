package designpattern;

abstract class RequestHandler {

    protected RequestHandler nextHandler;

    public void setNext(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    abstract void handleRequest(int days);
}

class TeamLeadHandler extends RequestHandler {
    void handleRequest(int days) {
        if (days <= 2)
            System.out.println("Approved by Team Lead");
        else if (nextHandler != null)
            nextHandler.handleRequest(days);
    }
}

class ManagerHandler extends RequestHandler {
    void handleRequest(int days) {
        if (days <= 5)
            System.out.println("Approved by Manager");
        else if (nextHandler != null)
            nextHandler.handleRequest(days);
    }
}

class HRHandler extends RequestHandler {
    void handleRequest(int days) {
        System.out.println("Approved by HR");
    }
}

public class ChainDemo {
    public static void main(String[] args) {

        RequestHandler lead = new TeamLeadHandler();
        RequestHandler manager = new ManagerHandler();
        RequestHandler hr = new HRHandler();

        lead.setNext(manager);
        manager.setNext(hr);

        lead.handleRequest(4);
    }
}
