package Connections;

import Interfaces.IConnection;

public class ConnectionDBA implements IConnection {
    private static ConnectionDBA connectionDBA;

    private ConnectionDBA() {}

    public static ConnectionDBA getInstance() {
        if (connectionDBA == null) 
        	connectionDBA = new ConnectionDBA();
        
        return connectionDBA;
    }

    public void getConnection() {
        System.out.println("Conexão com o banco de dados A obtida.");
    }

    public void closeConnection() {
        System.out.println("Conexão com o banco de dados A fechada.");
    }

    public void insertData() {
        System.out.println("Inserindo dados no banco de dados A.");
    }
}