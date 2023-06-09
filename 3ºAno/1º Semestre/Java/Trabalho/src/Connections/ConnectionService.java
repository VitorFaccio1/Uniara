package Connections;

import Interfaces.IConnection;
import Interfaces.IConnectionFactory;

public class ConnectionService {
    private IConnectionFactory connectionFactory;

    public ConnectionService() {}
    
    public void useConnection(String type) {
        IConnection connection = connectionFactory.getConnection(type);
        if (connection != null) {
            connection.getConnection();
            connection.insertData();
            connection.closeConnection();
        } else {
            System.out.println("Tipo de conexão inválido.");
        }
    }

    public void sendFile() {
        System.out.println("Enviando arquivo.");
    }

    public void closeCall() {
        System.out.println("Fechando chamada.");
    }
}