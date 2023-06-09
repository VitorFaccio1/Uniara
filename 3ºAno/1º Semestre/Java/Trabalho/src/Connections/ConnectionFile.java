package Connections;

import Interfaces.IConnection;

public class ConnectionFile implements IConnection {
    private static ConnectionFile instance;

    private ConnectionFile() {}

    public static ConnectionFile getInstance() {
        if (instance == null) 
            instance = new ConnectionFile();
        
        return instance;
    }

    public void getConnection() {
        System.out.println("Conexão com o arquivo obtida.");
    }

    public void closeConnection() {
        System.out.println("Conexão com o arquivo fechada.");
    }

    public void insertData() {
        System.out.println("Inserindo dados no arquivo.");
    }
    
    public void closeFile() {
        System.out.println("Fechando Arquivo.");
    }

	public void writeFile() {
		System.out.println("Escrevendo arquivo.");
	}
}