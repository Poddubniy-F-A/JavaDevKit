package Chat.server;

import Chat.client.ChatController;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ServerController {
    private final String pathToLog = "./src/main/java/Chat/server/log.txt";

    private final ServerGUI window;
    private final ArrayList<ChatController> clients = new ArrayList<>();

    private boolean isServerWorking;

    public ServerController(ServerGUI window) {
        this.window = window;
        isServerWorking = false;
    }

    public void run() {
        if (!isServerWorking) {
            isServerWorking = true;
            window.appendLog("Server is running\n");
        } else {
            window.appendLog("The server is already running\n");
        }
    }

    public void stop() {
        if (isServerWorking) {
            isServerWorking = false;
            window.appendLog("Server is stopped\n");
        } else {
            window.appendLog("The server is already stopped\n");
        }
    }

    public boolean isServerWorking() {
        return isServerWorking;
    }

    public void addClient(ChatController client) {
        clients.add(client);
    }

    public String getLog() {
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(pathToLog))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line);
                result.append('\n');
            }
        } catch (IOException e) {
            throw new RuntimeException("Проверьте корректность пути к лог-файлу");
        }
        return result.toString();
    }

    public void handleNewMessage(String message) {
        for (ChatController client : clients) {
            client.receiveMessage(message);
        }

        try (FileWriter fw = new FileWriter(pathToLog, true)) {
            fw.append(message);
        } catch (IOException e) {
            throw new RuntimeException("Проверьте корректность пути к лог-файлу");
        }
    }
}
