package Service;

import Model.Produto;

public interface ICadastraService {
	void cadastrarProduto(Produto produto);

	Produto buscarProduto(int id);

	void atualizarProduto(Produto produto);

	void excluirProduto(int id);

	Produto[] listarProdutos();

	int obterUltimoId();
}