package Chat.server;

import javax.swing.*;
import java.awt.*;

public class ServerWindow extends JFrame implements ServerGUI {
    private final int WIDTH = 300, HEIGHT = 200;

    private final ServerController controller;

    private final TextArea logArea;

    public ServerWindow() {
        controller = new ServerController(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle("server.Server");
        setResizable(false);

        logArea = new TextArea();
        add(logArea);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(_ -> controller.run());

        JButton stopButton = new JButton("Stop");
        stopButton.addActionListener(_ -> controller.stop());

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2));
        buttonsPanel.add(startButton);
        buttonsPanel.add(stopButton);

        add(buttonsPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void appendLog(String log) {
        logArea.append(log);
    }

    public ServerController getController() {
        return controller;
    }
}
