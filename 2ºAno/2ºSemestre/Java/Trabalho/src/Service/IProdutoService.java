package Service;

import Model.Produto;

public interface IProdutoService {

	public void inserirProduto(Produto Produto);
	
	public void alterarProduto(Produto Produto);
	
	public void excluirProduto(Produto Produto);
	
	public Produto pesquisarProdutoPorId(int id);
	
	public Produto[] listarProdutos();
	
 }