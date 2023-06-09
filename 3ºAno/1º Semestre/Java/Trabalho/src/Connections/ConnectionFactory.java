package Connections;

import Interfaces.IConnection;

public class ConnectionFactory {
    public IConnection getConnection(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("A")) {
            return ConnectionDBA.getInstance();
        } else if (type.equalsIgnoreCase("B")) {
            return ConnectionDBB.getInstance();
        } else if (type.equalsIgnoreCase("C")) {
            return ConnectionDBC.getInstance();
        }
        return null;
    }
}