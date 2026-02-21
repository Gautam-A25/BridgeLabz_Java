package designpattern;

import java.util.Stack;

class EditorMemento {
    private final String content;

    public EditorMemento(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}

class TextEditor {
    private String content = "";

    public void type(String text) {
        content += text;
    }

    public EditorMemento save() {
        return new EditorMemento(content);
    }

    public void restore(EditorMemento memento) {
        content = memento.getContent();
    }

    public void show() {
        System.out.println("Content: " + content);
    }
}

class EditorHistory {
    private Stack<EditorMemento> history = new Stack<>();

    public void save(EditorMemento memento) {
        history.push(memento);
    }

    public EditorMemento undo() {
        return history.pop();
    }
}

public class MementoDemo {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();
        EditorHistory history = new EditorHistory();

        editor.type("Hello ");
        history.save(editor.save());

        editor.type("Nehaa!");
        editor.show();

        editor.restore(history.undo());
        editor.show();
    }
}