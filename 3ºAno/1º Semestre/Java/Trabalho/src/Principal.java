import Connections.ConnectionService;

public class Principal {
    public static void main(String[] args) {
        ConnectionService connectionService = new ConnectionService();

        connectionService.useConnection("A");
        connectionService.useConnection("B");
        connectionService.useConnection("C");
    }
}