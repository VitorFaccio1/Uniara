	package Service;

import Model.Cliente;
import Model.Produto;

public interface IClienteService {

	void excluirCliente(Cliente Cliente);

	void inserirCliente(Cliente Cliente);

	void alterarCliente(Cliente Cliente);

	Cliente pesquisarClientePorId(int id);

	Cliente[] listarClientes();
	
	Produto[] listarCarrinhoDeCompras();
	
	void adicionarCarrinhoDeCompras(Cliente cliente, Produto Produto);
	
	void removerProdutoDoCarrinhoDeCompras(Produto produto);
	
	Cliente pesquisarClientePorEmailESenha(String email, String senha);
}