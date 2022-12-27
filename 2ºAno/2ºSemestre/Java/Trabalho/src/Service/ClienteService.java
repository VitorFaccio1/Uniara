package Service;

import Model.Cliente;
import Model.Produto;

public class ClienteService implements IClienteService{
	private Cliente [] clientes;
	private Produto [] produtos;
	private int idc = 0;
	private int idp = 0;
	
	public ClienteService(int tamanho) {
		this.clientes = new Cliente[tamanho];
		this.produtos = new Produto[tamanho];
	}
	
	@Override
	public void inserirCliente(Cliente Cliente) {
		Cliente.setId(idc);
		this.clientes[idc] = Cliente;
		idc++;
	}

	@Override
	public void alterarCliente(Cliente Cliente) {
		this.clientes[Cliente.getId()] = Cliente;
	}

	@Override
	public void excluirCliente(Cliente Cliente) {
		for(int i = Cliente.getId(); i < this.idc - 1; i++) { 
			this.clientes[i] = this.clientes[i + 1];
			this.clientes[i].setId(i);
		}
		
		this.clientes[idc - 1] = null;
		this.idc--;
	}

	@Override
	public Cliente pesquisarClientePorId(int id) {
		return this.clientes[id];
	}
	
	@Override
	public Cliente pesquisarClientePorEmailESenha(String email, String senha) {
		for(int i = 0; i < this.idc; i++) { 
			if(this.clientes[i].getEmail().equals(email) && this.clientes[i].getSenha().equals(senha))
				return clientes[i];
		}
		
		return null;
	}

	@Override
	public Cliente[] listarClientes() {
		return this.clientes;
	}
	
	@Override
	public void adicionarCarrinhoDeCompras(Cliente cliente, Produto Produto) {
		Produto.setId(idp);
		this.produtos[idp] = Produto;
		cliente.setCarrinhoDeCompras(produtos);
		idp++;
	}
	
	@Override
	public Produto[] listarCarrinhoDeCompras() {
		return this.produtos;
	}
	
	@Override
	public void removerProdutoDoCarrinhoDeCompras(Produto produto) {
		for(int i = produto.getId(); i < this.idp - 1; i++) { 
			this.produtos[i] = this.produtos[i + 1];
			this.produtos[i].setId(i);
		}
		
		this.produtos[idp - 1] = null;
		this.idp--;
	}
}