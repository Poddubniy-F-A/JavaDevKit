package Chat.client;

public interface ChatGUI {
    void setText(String text);

    void appendText(String text);

    String getMessage();

    void clearMessageField();
}
