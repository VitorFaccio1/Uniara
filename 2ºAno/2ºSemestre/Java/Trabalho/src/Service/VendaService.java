package Service;

import Model.Cliente;
import Model.Produto;
import Model.Venda;

public class VendaService implements IVendaService{
	private Venda [] vendas;
	private int idv = 0;
	
	public VendaService(int tamanho) {
		this.vendas = new Venda[tamanho];
	}
	
	@Override
	public Venda[] listarVendas() {
		return this.vendas;
	}
	
	@Override
	public Venda listarVendaPorId(int id) {
		return this.vendas[id];
	}
	
	@Override
	public void inserirVenda(Venda venda) {
		venda.setId(idv);
		this.vendas[idv] = venda;
		idv++;
	}
}