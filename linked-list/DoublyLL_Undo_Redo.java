class TextState {
    String text;
    TextState prev;
    TextState next;

    public TextState(String text) {
        this.text = text;
        this.prev = null;
        this.next = null;
    }
}

class TextEditor {
    private TextState head;
    private TextState tail;
    private TextState current;
    private int historySize;
    private int size;

    // Constructor to initialize the text editor
    public TextEditor(int historySize) {
        this.head = null;
        this.tail = null;
        this.current = null;
        this.historySize = historySize;
        this.size = 0;
    }

    // Add a new text state to the end of the history
    public void addTextState(String newText) {
        TextState newState = new TextState(newText);
        
        // If there's already a current state, remove forward history (redo)
        if (current != null && current.next != null) {
            current.next = null;  // Disconnect redo history
        }

        // Add new state at the end (tail)
        if (tail == null) {
            head = tail = current = newState;  // First state
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = tail;
        }

        size++;

        // If history size exceeds the limit, remove the oldest state
        if (size > historySize) {
            removeOldestState();
        }

        System.out.println("Current state: " + current.text);
    }

    // Remove the oldest state (head of the list)
    private void removeOldestState() {
        if (head != null) {
            head = head.next;
            if (head != null) {
                head.prev = null;
            }
            size--;
        }
    }

    // Undo operation (move to the previous state)
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo: " + current.text);
        } else {
            System.out.println("No more undo operations.");
        }
    }

    // Redo operation (move to the next state)
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo: " + current.text);
        } else {
            System.out.println("No more redo operations.");
        }
    }

    // Display the current text state
    public void displayCurrentState() {
        if (current != null) {
            System.out.println("Current text: " + current.text);
        } else {
            System.out.println("No current text state.");
        }
    }

    // Display the history of text states (for debugging purposes)
    public void displayHistory() {
        if (head == null) {
            System.out.println("No text history.");
            return;
        }

        TextState temp = head;
        System.out.println("Text History:");
        while (temp != null) {
            System.out.println(temp.text);
            temp = temp.next;
        }
    }
}

public class DoublyLL_Undo_Redo {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor(10);  // History size limit: 10

        // Simulate typing actions
        editor.addTextState("Hello, ");
        editor.addTextState("Hello, World!");
        editor.addTextState("Hello, World! How are you?");
        editor.addTextState("Hello, World! How are you? I'm fine.");

        // Display the current state
        editor.displayCurrentState();

        // Undo actions
        editor.undo();
        editor.undo();

        // Redo actions
        editor.redo();
        editor.redo();

        // Add more text and demonstrate the history limit
        editor.addTextState("New paragraph added.");
        editor.addTextState("Final version of the document.");
        
        // Display the history
        editor.displayHistory();
    }
}
