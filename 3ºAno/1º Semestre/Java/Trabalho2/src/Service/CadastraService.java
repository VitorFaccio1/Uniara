package Service;

import DAO.CadastraDBDAO;
import DAO.CadastraTXTDAO;
import DAO.CadastraXLSDAO;
import DAO.ICadastraDAO;
import Model.Produto;

public class CadastraService implements ICadastraService {
	private ICadastraDAO cadastraDAO;

	public CadastraService(String tipo) {
		switch (tipo) {
		case "DB":
			cadastraDAO = new CadastraDBDAO();
			break;
		case "XLS":
			cadastraDAO = new CadastraXLSDAO();
			break;
		case "TXT":
			cadastraDAO = new CadastraTXTDAO();
			break;
		default:
			throw new IllegalArgumentException("Tipo de DAO inválido");
		}
	}

	@Override
	public void cadastrarProduto(Produto produto) {
		cadastraDAO.cadastrar(produto);
	}

	@Override
	public Produto buscarProduto(int id) {
		return cadastraDAO.buscar(id);
	}

	@Override
	public void atualizarProduto(Produto produto) {
		cadastraDAO.atualizar(produto);
	}

	@Override
	public void excluirProduto(int id) {
		cadastraDAO.excluir(id);
	}

	public Produto[] listarProdutos() {
		return cadastraDAO.listar();
	}

	@Override
	public int obterUltimoId() {
		return cadastraDAO.obterUltimoId();
	}
}