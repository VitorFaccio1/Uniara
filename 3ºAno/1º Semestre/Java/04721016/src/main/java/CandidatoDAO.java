import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidatoDAO {
	private String bancoDeDados = "jdbc:sqlite:candidatos.db";

	public CandidatoDAO(boolean test) {
		if (test)
			bancoDeDados = "jdbc:sqlite:candidatosTest.db";
		
		try {
			DriverManager.getConnection(bancoDeDados);
			criarTabela();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void criarTabela() {
		try (var connection = DriverManager.getConnection(bancoDeDados); var statement = connection.createStatement()) {
			var sql = "CREATE TABLE IF NOT EXISTS candidato (" + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ "nome TEXT NOT NULL," + "cpf TEXT NOT NULL," + "telefone TEXT NOT NULL," + "email TEXT NOT NULL,"
					+ "endereco TEXT NOT NULL," + "cidade TEXT NOT NULL," + "estado TEXT NOT NULL,"
					+ "cep TEXT NOT NULL" + ")";
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void inserirCandidato(CandidatoTO candidato) {
		try (Connection connection = DriverManager.getConnection(bancoDeDados)) {
			try (PreparedStatement statement = connection.prepareStatement(
					"INSERT INTO candidato (nome, cpf, telefone, email, endereco, cidade, estado, cep) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

				statement.setString(1, candidato.getNome());
				statement.setString(2, candidato.getCpf());
				statement.setString(3, candidato.getTelefone());
				statement.setString(4, candidato.getEmail());
				statement.setString(5, candidato.getEndereco());
				statement.setString(6, candidato.getCidade());
				statement.setString(7, candidato.getEstado());
				statement.setString(8, candidato.getCep());

				statement.executeUpdate();

				System.out.println("\nCandidato Inserido com sucesso!!!!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean CandidatoJaInscrito(CandidatoTO candidato) {
		try (Connection connection = DriverManager.getConnection(bancoDeDados)) {
			try (PreparedStatement statement = connection
					.prepareStatement("SELECT COUNT(*) FROM candidato WHERE cpf = ?")) {

				statement.setString(1, candidato.getCpf());

				try (ResultSet resultSet = statement.executeQuery()) {
					if (resultSet.next()) {
						int count = resultSet.getInt(1);
						if (count > 0) {
							System.out.println("\nCandidato já cadastrado!!!!");
							return true;
						}
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public void deletarTodosCandidatos() {
	    try (Connection connection = DriverManager.getConnection(bancoDeDados);
	         PreparedStatement statement = connection.prepareStatement("DELETE FROM candidato")) {

	        statement.executeUpdate();

	        System.out.println("Todos os candidatos foram excluídos do banco de dados.");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}