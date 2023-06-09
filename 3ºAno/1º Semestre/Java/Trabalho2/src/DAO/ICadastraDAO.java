package DAO;

import Model.Produto;

public interface ICadastraDAO {
	void cadastrar(Produto produto);

	Produto buscar(int id);

	void atualizar(Produto produto);

	void excluir(int id);

	Produto[] listar();

	int obterUltimoId();
}