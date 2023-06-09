import Connections.ConnectionDBA;
import Connections.ConnectionDBB;
import Connections.ConnectionFile;
import Connections.ConnectionService;

public class TransactionFacade {
    private ConnectionDBA connectionDBA;
    private ConnectionDBB connectionDBB;
    private ConnectionService connectionService;
    private ConnectionFile connectionFile;

    public TransactionFacade(ConnectionDBA connectionDBA, ConnectionDBB connectionDBB,
                             ConnectionService connectionService, ConnectionFile connectionFile) {
        this.connectionDBA = connectionDBA;
        this.connectionDBB = connectionDBB;
        this.connectionService = connectionService;
        this.connectionFile = connectionFile;
    }

    public void doTransaction() {
        try {
            connectionDBA.insertData();
            connectionDBB.insertData();
            connectionService.sendFile();
            connectionFile.writeFile();
            connectionDBA.closeConnection();
            connectionDBB.closeConnection();
            connectionService.closeCall();
            connectionFile.closeFile();
            System.out.println("Transação concluída com sucesso.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro durante a transação: " + e.getMessage());
            connectionDBA.closeConnection();
            connectionDBB.closeConnection();
            connectionService.closeCall();
            connectionFile.closeFile();
        }
    }
}