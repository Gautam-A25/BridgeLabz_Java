package designpattern;

import java.util.ArrayList;
import java.util.List;

interface ChatMediator {
    void sendMessage(String message, ChatUser sender);
    void addUser(ChatUser user);
}

class ChatRoomMediator implements ChatMediator {

    private List<ChatUser> users = new ArrayList<>();

    public void addUser(ChatUser user) {
        users.add(user);
    }

    public void sendMessage(String message, ChatUser sender) {
        for (ChatUser user : users) {
            if (user != sender) {
                user.receive(message);
            }
        }
    }
}

abstract class ChatUser {
    protected ChatMediator mediator;
    protected String name;

    public ChatUser(ChatMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    abstract void send(String message);
    abstract void receive(String message);
}

class ConcreteChatUser extends ChatUser {

    public ConcreteChatUser(ChatMediator mediator, String name) {
        super(mediator, name);
    }

    void send(String message) {
        mediator.sendMessage(message, this);
    }

    void receive(String message) {
        System.out.println(name + " received: " + message);
    }
}

public class MediatorDemo {
    public static void main(String[] args) {

        ChatMediator chatRoom = new ChatRoomMediator();

        ChatUser user1 = new ConcreteChatUser(chatRoom, "Nehaa");
        ChatUser user2 = new ConcreteChatUser(chatRoom, "Riya");

        chatRoom.addUser(user1);
        chatRoom.addUser(user2);

        user1.send("Hello!");
    }
}