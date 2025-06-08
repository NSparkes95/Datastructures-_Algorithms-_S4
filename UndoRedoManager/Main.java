package UndoRedoManager;

public class Main {
    public static void main(String[] args) {
        UndoRedoManager<String> manager = new UndoRedoManager<>();

        manager.addState("State 1");
        manager.addState("State 2");
        manager.addState("State 3");

        manager.traverse();
        System.out.println("Current State: " + manager.getCurrentState());

        manager.undo();
        manager.traverse();
        System.out.println("Current State: " + manager.getCurrentState());

        manager.undo();
        manager.traverse();
        System.out.println("Current State: " + manager.getCurrentState());

        manager.redo();
        manager.traverse();
        System.out.println("Current State: " + manager.getCurrentState());

        manager.addState("State 4");
        manager.traverse();
        System.out.println("Current State: " + manager.getCurrentState());
    }
}
