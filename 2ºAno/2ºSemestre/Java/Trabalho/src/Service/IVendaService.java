package Service;

import Model.Venda;

public interface IVendaService {
	Venda[] listarVendas();
	
	Venda listarVendaPorId(int id);
	
	void inserirVenda(Venda venda);
}