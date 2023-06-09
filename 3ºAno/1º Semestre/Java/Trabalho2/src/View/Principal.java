package View;

import javax.swing.JOptionPane;

import Model.Produto;
import Service.CadastraService;

public class Principal {
	private static CadastraService cadastraService = new CadastraService("DB");

	public static void main(String[] args) {
		exibirMenu();
	}

	private static void exibirMenu() {
		String menu = "Escolha uma opção:\n" + "1. Cadastrar produto\n" + "2. Buscar produto\n"
				+ "3. Atualizar produto\n" + "4. Excluir produto\n" + "5. Listar produtos\n" + "6. Sair";

		int opcao;
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

			switch (opcao) {
			case 1:
				cadastrarProduto();
				break;
			case 2:
				buscarProduto();
				break;
			case 3:
				atualizarProduto();
				break;
			case 4:
				excluirProduto();
				break;
			case 5:
				listarProdutos();
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "Saindo do programa...");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
				break;
			}
		} while (opcao != 6);
	}

	private static void cadastrarProduto() {
		var nome = JOptionPane.showInputDialog("Digite o nome do produto:");
		var descricao = JOptionPane.showInputDialog("Digite a descrição do produto:");

		var precoStr = JOptionPane.showInputDialog("Digite o preço do produto:");
		var preco = Double.parseDouble(precoStr);

		var qtdStr = JOptionPane.showInputDialog("Digite a quantidade do produto:");
		var qtd = Integer.parseInt(qtdStr);

		var ultimoIdCadastrado = cadastraService.obterUltimoId();

		System.out.println(ultimoIdCadastrado);

		var produto = new Produto(ultimoIdCadastrado, nome, descricao, preco, qtd);
		cadastraService.cadastrarProduto(produto);

		JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
	}

	private static void buscarProduto() {
		var idStr = JOptionPane.showInputDialog("Digite o ID do produto:");
		var id = Integer.parseInt(idStr);

		var produto = cadastraService.buscarProduto(id);

		if (produto != null) {
			var mensagem = "ID: " + produto.getId() + "\n" + "Nome: " + produto.getNome() + "\n" + "Descrição: "
					+ produto.getDescricao() + "\n" + "Preço: " + produto.getPreco() + "\n" + "Quantidade: "
					+ produto.getQtd();

			JOptionPane.showMessageDialog(null, mensagem);
		} else {
			JOptionPane.showMessageDialog(null, "Produto não encontrado!");
		}
	}

	private static void atualizarProduto() {
		var idStr = JOptionPane.showInputDialog("Digite o ID do produto:");
		var id = Integer.parseInt(idStr);

		var produto = cadastraService.buscarProduto(id);

		if (produto != null) {
			var nome = JOptionPane.showInputDialog("Digite o novo nome do produto:");
			var descricao = JOptionPane.showInputDialog("Digite a nova descrição do produto:");

			var precoStr = JOptionPane.showInputDialog("Digite o novo preço do produto:");
			var preco = Double.parseDouble(precoStr);

			var qtdStr = JOptionPane.showInputDialog("Digite a nova quantidade do produto:");
			var qtd = Integer.parseInt(qtdStr);

			produto.setNome(nome);
			produto.setDescricao(descricao);
			produto.setPreco(preco);
			produto.setQtd(qtd);

			cadastraService.atualizarProduto(produto);

			JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Produto não encontrado!");
		}
	}

	private static void excluirProduto() {
		var idStr = JOptionPane.showInputDialog("Digite o ID do produto:");
		var id = Integer.parseInt(idStr);

		var produto = cadastraService.buscarProduto(id);

		if (produto != null) {
			cadastraService.excluirProduto(id);
			JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "Produto não encontrado!");
		}
	}

	private static void listarProdutos() {
		var produtos = cadastraService.listarProdutos();

		if (produtos.length == 0) {
			JOptionPane.showMessageDialog(null, "Não há produtos cadastrados.");
		} else {
			StringBuilder listaProdutos = new StringBuilder("Lista de Produtos:\n");
			for (var produto : produtos) {
				listaProdutos.append(produto.toString()).append("\n");
			}
			JOptionPane.showMessageDialog(null, listaProdutos.toString());
		}
	}
}