package DAO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import Model.Produto;

public class CadastraTXTDAO implements ICadastraDAO {
	private static final String FILE_PATH = "produtos.txt";

	@Override
	public void cadastrar(Produto produto) {
		if (!Files.exists(Paths.get(FILE_PATH))) {
			try {
				Files.createFile(Paths.get(FILE_PATH));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
			var linha = produto.getId() + ";" + produto.getNome() + ";" + produto.getDescricao() + ";"
					+ produto.getPreco() + ";" + produto.getQtd();
			writer.write(linha);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Produto buscar(int id) {
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(";");
				int produtoId = Integer.parseInt(partes[0]);
				if (produtoId == id) {
					var nome = partes[1];
					var descricao = partes[2];
					var preco = Double.parseDouble(partes[3]);
					var qtd = Integer.parseInt(partes[4]);
					return new Produto(id, nome, descricao, preco, qtd);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void atualizar(Produto produto) {
		List<Produto> produtos = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(";");
				int id = Integer.parseInt(partes[0]);
				if (id == produto.getId()) {
					produtos.add(produto);
				} else {
					String nome = partes[1];
					String descricao = partes[2];
					double preco = Double.parseDouble(partes[3]);
					int qtd = Integer.parseInt(partes[4]);
					produtos.add(new Produto(id, nome, descricao, preco, qtd));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
			for (Produto p : produtos) {
				String linha = p.getId() + ";" + p.getNome() + ";" + p.getDescricao() + ";" + p.getPreco() + ";"
						+ p.getQtd();
				writer.write(linha);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(int id) {
		var produtos = new ArrayList<Produto>();

		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(";");
				var produtoId = Integer.parseInt(partes[0]);
				if (produtoId != id) {
					produtos.add(new Produto(produtoId, partes[1], partes[2], Double.parseDouble(partes[3]),
							Integer.parseInt(partes[4])));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (var writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
			for (var p : produtos) {
				var linha = p.getId() + ";" + p.getNome() + ";" + p.getDescricao() + ";" + p.getPreco() + ";"
						+ p.getQtd();
				writer.write(linha);
				writer.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Produto[] listar() {
		var produtos = new ArrayList<Produto>();

		try (var reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(";");
				var id = Integer.parseInt(partes[0]);
				var nome = partes[1];
				var descricao = partes[2];
				var preco = Double.parseDouble(partes[3]);
				var qtd = Integer.parseInt(partes[4]);
				produtos.add(new Produto(id, nome, descricao, preco, qtd));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return produtos.toArray(new Produto[0]);
	}

	@Override
	public int obterUltimoId() {
		int ultimoId = 0;

		try (var reader = new BufferedReader(new FileReader(FILE_PATH))) {
			String linha;
			while ((linha = reader.readLine()) != null) {
				String[] partes = linha.split(";");
				var id = Integer.parseInt(partes[0]);
				if (id > ultimoId) {
					ultimoId = id;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return ultimoId;
	}
}