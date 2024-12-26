package Chat;

import Chat.client.ClientWindow;
import Chat.server.ServerController;
import Chat.server.ServerWindow;

public class Main {
    public static void main(String[] args) {
        ServerWindow server = new ServerWindow();
        ServerController controller = server.getController();
        new ClientWindow(controller, "Alex", "pass1", "127.0.0.1", "8000");
        new ClientWindow(controller, "Bob", "pass2", "127.0.0.2", "9000");
    }
}
