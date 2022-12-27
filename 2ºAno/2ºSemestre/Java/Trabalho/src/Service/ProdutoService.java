package Service;

import Model.Produto;

public class ProdutoService implements IProdutoService {

	private Produto [] produtos;
	private int idx = 0;
	
	public ProdutoService(int tamanho) {
		this.produtos = new Produto[tamanho];
	}
	
	@Override
	public void inserirProduto(Produto produto) {
		produto.setId(idx);
		this.produtos[idx] = produto;
		idx++;
	}

	@Override
	public void alterarProduto(Produto produto) {
		this.produtos[produto.getId()] = produto;
	}

	@Override
	public void excluirProduto(Produto produto) {
		for(int i = produto.getId(); i < this.idx - 1; i++) { 
			this.produtos[i] = this.produtos[i + 1];
			this.produtos[i].setId(i);
		}
		
		this.produtos[idx - 1] = null;
		this.idx--;
	}

	@Override
	public Produto pesquisarProdutoPorId(int id) {
		return this.produtos[id];
	}

	@Override
	public Produto[] listarProdutos() {
		return this.produtos;
	}

}