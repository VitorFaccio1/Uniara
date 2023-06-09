package Connections;

import Interfaces.IConnection;

public class ConnectionDBB implements IConnection {
    private static ConnectionDBB connectionDBB;

    private ConnectionDBB() {}

    public static ConnectionDBB getInstance() {
        if (connectionDBB == null) 
        	connectionDBB = new ConnectionDBB();
        
        return connectionDBB;
    }

    public void getConnection() {
        System.out.println("Conexão com o banco de dados B obtida.");
    }

    public void closeConnection() {
        System.out.println("Conexão com o banco de dados B fechada.");
    }

    public void insertData() {
        System.out.println("Inserindo dados no banco de dados B.");
    }
}