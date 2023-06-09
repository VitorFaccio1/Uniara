package Interfaces;

public interface IConnectionFactory {
    IConnection getConnection();

	IConnection getConnection(String type);
}