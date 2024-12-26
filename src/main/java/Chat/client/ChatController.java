package Chat.client;

import Chat.server.ServerController;

public class ChatController {
    private final ServerController server;
    private final ChatGUI window;

    private final String login;

    private boolean isConnected;

    public ChatController(ServerController server, ChatGUI window, String login) {
        this.server = server;
        this.window = window;

        this.login = login;

        isConnected = false;
    }

    public void connect() {
        if (server.isServerWorking()) {
            if (!isConnected) {
                server.addClient(this);

                isConnected = true;
                window.setText(server.getLog() + "Connection to the server is successful\n");
            }
        } else {
            isConnected = false;
            window.appendText("Connection to the server failed\n");
        }
    }

    public void sendMessage() {
        if (server.isServerWorking()) {
            if (isConnected) {
                String text = window.getMessage();
                if (!text.isEmpty()) {
                    server.handleNewMessage(login + ": " + text + "\n");
                    window.clearMessageField();
                }
            } else {
                window.appendText("You aren't connected to the server\n");
            }
        } else {
            isConnected = false;
            window.appendText("Connection to the server failed\n");
        }
    }

    public void receiveMessage(String message) {
        window.appendText(message);
    }
}
