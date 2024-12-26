package Chat.client;

import Chat.server.ServerController;

import javax.swing.*;
import java.awt.*;

public class ClientWindow extends JFrame implements ChatGUI {
    private final int WIDTH = 600, HEIGHT = 400;

    private final ChatController controller;

    private final TextArea chat;
    private final TextField messageField;

    public ClientWindow(ServerController server, String login, String password, String IP, String port) {
        controller = new ChatController(server, this, login);

        setSize(WIDTH, HEIGHT);
        setTitle("client");
        setResizable(false);

        JPanel parametersPanel = new JPanel(new GridLayout(2, 3));
        parametersPanel.add(new TextField(IP));
        parametersPanel.add(new TextField(port));
        parametersPanel.add(new TextField(login));
        parametersPanel.add(new JPasswordField(password));
        JButton connectionButton = new JButton("Connect");
        connectionButton.addActionListener(_ -> controller.connect());
        parametersPanel.add(connectionButton);
        add(parametersPanel, BorderLayout.NORTH);

        chat = new TextArea();
        add(chat);

        JPanel messagePanel = new JPanel(new BorderLayout());
        messageField = new TextField();
        messagePanel.add(messageField, BorderLayout.CENTER);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(_ -> controller.sendMessage());
        messagePanel.add(sendButton, BorderLayout.EAST);
        add(messagePanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void setText(String text) {
        chat.setText(text);
    }

    public void appendText(String text) {
        chat.append(text);
    }

    public String getMessage() {
        return messageField.getText();
    }

    public void clearMessageField() {
        messageField.setText("");
    }
}
