package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import Model.Produto;

public class CadastraDBDAO implements ICadastraDAO {
	private Connection connection;
	private static String bancoDeDados = "jdbc:sqlite:produtos.db";

	public CadastraDBDAO() {
		try {
			connection = DriverManager.getConnection(bancoDeDados);
			criarTabela();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void criarTabela() {
		try (var connection = DriverManager.getConnection(bancoDeDados); var statement = connection.createStatement()) {

			var sql = "CREATE TABLE IF NOT EXISTS " + "produtos" + " (" + "id INTEGER PRIMARY KEY, " + "nome TEXT, "
					+ "descricao TEXT, " + "preco REAL, " + "qtd INTEGER" + ")";

			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void cadastrar(Produto produto) {
		var query = "INSERT INTO produtos (id, nome, descricao, preco, qtd) VALUES (?, ?, ?, ?, ?)";

		try {
			var statement = connection.prepareStatement(query);
			statement.setInt(1, produto.getId());
			statement.setString(2, produto.getNome());
			statement.setString(3, produto.getDescricao());
			statement.setDouble(4, produto.getPreco());
			statement.setInt(5, produto.getQtd());

			statement.executeUpdate();
			statement.close();

			System.out.println("Produto cadastrado no banco de dados.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Produto buscar(int id) {
		var query = "SELECT * FROM produtos WHERE id = ?";
		Produto produto = null;

		try {
			var statement = connection.prepareStatement(query);
			statement.setInt(1, id);

			var resultSet = statement.executeQuery();
			if (resultSet.next()) {
				int produtoId = resultSet.getInt("id");
				String nome = resultSet.getString("nome");
				String descricao = resultSet.getString("descricao");
				double preco = resultSet.getDouble("preco");
				int qtd = resultSet.getInt("qtd");

				produto = new Produto(produtoId, nome, descricao, preco, qtd);
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produto;
	}

	@Override
	public void atualizar(Produto produto) {
		var query = "UPDATE produtos SET nome = ?, descricao = ?, preco = ?, qtd = ? WHERE id = ?";

		try {
			var statement = connection.prepareStatement(query);
			statement.setString(1, produto.getNome());
			statement.setString(2, produto.getDescricao());
			statement.setDouble(3, produto.getPreco());
			statement.setInt(4, produto.getQtd());
			statement.setInt(5, produto.getId());

			statement.executeUpdate();
			statement.close();

			System.out.println("Produto atualizado no banco de dados.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(int id) {
		var query = "DELETE FROM produtos WHERE id = ?";

		try {
			var statement = connection.prepareStatement(query);
			statement.setInt(1, id);

			statement.executeUpdate();
			statement.close();

			System.out.println("Produto excluído do banco de dados.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Produto[] listar() {
		var produtos = new ArrayList<Produto>();

		try {
			var statement = connection.createStatement();
			var sql = "SELECT * FROM produtos";
			var resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				var id = resultSet.getInt("id");
				var nome = resultSet.getString("nome");
				var descricao = resultSet.getString("descricao");
				var preco = resultSet.getDouble("preco");
				var qtd = resultSet.getInt("qtd");

				produtos.add(new Produto(id, nome, descricao, preco, qtd));
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produtos.toArray(new Produto[0]);
	}

	public int obterUltimoId() {
		var ultimoId = 0;

		try {
			var statement = connection.createStatement();
			var sql = "SELECT MAX(id) as ultimo_id FROM produtos";
			var resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				ultimoId = resultSet.getInt("ultimo_id");
			}

			resultSet.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ultimoId + 1;
	}
}