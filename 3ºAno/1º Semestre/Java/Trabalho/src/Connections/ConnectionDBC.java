package Connections;

import Interfaces.IConnection;

public class ConnectionDBC implements IConnection {
    private static ConnectionDBC connectionDBC;

    private ConnectionDBC() {}

    public static ConnectionDBC getInstance() {
        if (connectionDBC == null) 
        	connectionDBC = new ConnectionDBC();
        
        return connectionDBC;
    }

    public void getConnection() {
        System.out.println("Conexão com o banco de dados C obtida.");
    }

    public void closeConnection() {
        System.out.println("Conexão com o banco de dados C fechada.");
    }

    public void insertData() {
        System.out.println("Inserindo dados no banco de dados C.");
    }
}