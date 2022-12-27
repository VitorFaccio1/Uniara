package View;

import Model.Cliente;
import Model.Produto;
import Model.Venda;
import Service.ClienteService;
import Service.IClienteService;
import Service.IProdutoService;
import Service.IVendaService;
import Service.ProdutoService;
import Service.VendaService;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Principal {

	public static final String menuEntrada = ""
			+ "  1 - Logar \n"
			+ "  2 - Registrar \n"
			+ "  3 - Sair \n"; 
	
	public static final String menu = ""
			+ "  1 - Menu Clientes \n"
			+ "  2 - Menu Produtos \n"
			+ "  3 - Menu Vendas \n"
			+ "  4 - Menu Compras \n"
			+ "  5 - Sair \n"; 
	
	public static final String menuCliente = ""
			+ "  1 - Inserir Cliente \n"
			+ "  2 - Alterar Cliente \n"
			+ "  3 - Excluir Cliente \n"
			+ "  4 - Pesquisar Cliente por Id \n"
			+ "  5 - Listar Clientes \n"
			+ "  6 - Sair \n"; 
	
	public static final String menuProduto = ""
			+ "  1 - Inserir Produto \n"
			+ "  2 - Alterar Produto \n"
			+ "  3 - Excluir Produto \n"
			+ "  4 - Pesquisar Produto por Id \n"
			+ "  5 - Listar Produtos \n"
			+ "  6 - Sair \n"; 
		
	public static final String[] formasDePagamentosValida = {"pix", "dinheiro", "cartao"};
	
	public static final String menuCompra = ""
			+ "  1 - Mostrar Produtos \n"
			+ "  2 - Comprar produto por Id\n"
			+ "  3 - Pesquisar Produto por Id \n"
			+ "  4 - Mostrar Carrinho\n"
			+ "  5 - Finalizar Compra\n"
			+ "  6 - Sair \n";
	
	public static final String menuVenda = ""
			+ "  1 - Mostrar Vendas \n"
			+ "  2 - Procurar venda por Id\n"
			+ "  3 - Sair \n"; 
	
	public static void main(String [] args) {
		IClienteService ICS = getClienteService();
		IProdutoService IPS = getProdutoService();
		IVendaService IVS = getVendaService();
		
		ICS.inserirCliente(setAdmin());
		ICS.inserirCliente(setFuncionario());
		
		String opcaoEntrada = "";
		while(!opcaoEntrada.equals("4")) {
			opcaoEntrada = JOptionPane.showInputDialog(menuEntrada);
			switch(opcaoEntrada) {
				case "1":
					String email = JOptionPane.showInputDialog("Insiria seu email: ");
					String senha = JOptionPane.showInputDialog("Insiria sua senha: ");
					
					var cliente = ICS.pesquisarClientePorEmailESenha(email, senha);
					
					if(cliente.getCarrinhoDeCompras() == null)
						cliente.setCarrinhoDeCompras(new Produto[100]);
					
					if(cliente != null) {
						String opcaoMenu = "";
						while(!opcaoMenu.equals("5")) {
							opcaoMenu = JOptionPane.showInputDialog(menu);
							switchMenuEntrada(ICS, IPS, IVS, opcaoMenu, cliente);
						}
					}
					else 
						JOptionPane.showMessageDialog(null, "Usuario nao encontrado tente novamente");
					break;
				case "2":
					ICS.inserirCliente(getCliente());
					break;
				case "3": break;
					
			}
		}
	}

	private static void switchMenuEntrada(IClienteService ICS, IProdutoService IPS, IVendaService IVS, String opcao, Cliente cliente) {
		switch(opcao) {
		case "1":
			 String opcaoCliente = "";
			 while(!opcaoCliente.equals("6")) {
				 if(usuarioLogadoAdminOuFuncionario(cliente)) {
					 opcaoCliente = JOptionPane.showInputDialog(menuCliente);
					 switchMenuClientes(ICS, opcaoCliente);			 
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "Somente os admins ou funcionarios estao autorizados a entrar no gerenciamento de clientes");
					 break;
				 }
			 }
			 break;
		 case "2": 
			 String opcaoProduto = "";
			 while(!opcaoProduto.equals("6")) {
				 if(usuarioLogadoAdminOuFuncionario(cliente)) {
					 opcaoProduto = JOptionPane.showInputDialog(menuProduto);
					 switchMenuProdutos(IPS, opcaoProduto);
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "Somente os admins ou funcionarios estao autorizados a entrar no gerenciamento de produtos");
					 break;
				 }
			 }
			 break;
		 case "3":
			 String opcaoVenda = "";
			 if(usuarioLogadoAdminOuFuncionario(cliente)) {
				 opcaoVenda = JOptionPane.showInputDialog(menuVenda);
				 switchMenuVenda(IVS, opcaoVenda);
			 }
			 else {
				 JOptionPane.showMessageDialog(null, "Somente os admins ou funcionarios estao autorizados a entrar no gerenciamento de produtos");
				 break;
			 }
			 break;
		 case "4": 
			 String opcaoCompra = "";
			 while(!opcaoCompra.equals("6")) {
				 opcaoCompra = JOptionPane.showInputDialog(menuCompra);
				 switchmenuCompras(IVS, IPS, ICS, opcaoCompra, cliente);
			 }
			 break;
		 case "5": break;
		 default: JOptionPane.showMessageDialog(null, "Digite uma opcao valida ");
		}
	}

	private static boolean usuarioLogadoAdminOuFuncionario(Cliente cliente) {
		return cliente.getCargo().equals("admin") || cliente.getCargo().equals("funcionario");
	}

	private static void switchMenuClientes(IClienteService ICS, String opcao) {
		switch(opcao) {
		 case "1":
			 Cliente c = getCliente();
			 ICS.inserirCliente(c);
			 break;
		 case "2": 
			 int index = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice do Cliente que sera alterado"));
			 c = getCliente();
			 c.setId(index);
			 ICS.alterarCliente(c);
			 break;
		 case "3": 
			 index = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice do Cliente que sera alterado"));
			 c = new Cliente();
			 c.setId(index);
			 ICS.excluirCliente(c);
			 break;
		 case "4": 
			 index = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice do Cliente que sera alterado"));
			 c = ICS.pesquisarClientePorId(index);
			 JOptionPane.showMessageDialog(null, c);
			 break;
		 case "5": 
		 	String resposta = "";
		 	for(Cliente cont : ICS.listarClientes()) {
		 		if(cont != null)
		 			resposta += cont + "\n";
		 	}
		 	JOptionPane.showMessageDialog(null, resposta);
		 	break;
		 case "6": break;
		 default: JOptionPane.showMessageDialog(null, "Digite uma opcao v�lida ");
		
		}
	}
	
	private static void switchMenuProdutos(IProdutoService IPS, String opcao) {
		switch(opcao) {
		 case "1":
			 Produto p = getProduto();
			 IPS.inserirProduto(p);
			 break;
		 case "2": 
			 int index = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice do Produto que sera alterado"));
			 p = getProduto();
			 p.setId(index);
			 IPS.alterarProduto(p);
			 break;
		 case "3": 
			 index = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice do Produto que sera alterado"));
			 p = new Produto();
			 p.setId(index);
			 IPS.excluirProduto(p);
			 break;
		 case "4": 
			 index = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice do Produto que sera pesquisado"));
			 p = IPS.pesquisarProdutoPorId(index);
			 JOptionPane.showMessageDialog(null, p);
			 break;
		 case "5": 
		 	String resposta = "";
		 	for(Produto cont : IPS.listarProdutos()) {
		 		if(cont != null)
		 			resposta += cont + "\n";
		 	}
		 	JOptionPane.showMessageDialog(null, resposta);
		 	break;
		 case "6": break;
		 default: JOptionPane.showMessageDialog(null, "Digite uma opcao valida ");
		
		}
	}
	
	private static void switchmenuCompras(IVendaService IVS, IProdutoService IPS, IClienteService ICS, String opcao, Cliente clienteLogado) {
		switch(opcao) {
		 case "1":
			 	String resposta = "";
			 	for(Produto cont : IPS.listarProdutos()) 
			 		if(cont != null)
			 			resposta += cont + "\n";
			 	
			 	JOptionPane.showMessageDialog(null, resposta);
			 break;
		 case "2": 
			 int index = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice do Produto que deseja adicionar no carrinho de compras"));
			 Produto p = IPS.pesquisarProdutoPorId(index);
			 
			 if(p != null) {
					 var carrinhoDeComprasClienteLogado = clienteLogado.getCarrinhoDeCompras();
					 
					 int ultimoIdCarrinho = 0;
					 for(Produto produto : carrinhoDeComprasClienteLogado) 
					 		if(produto != null)
					 			ultimoIdCarrinho++;
					 			
					 carrinhoDeComprasClienteLogado[ultimoIdCarrinho] = p;	
					 
					 clienteLogado.setCarrinhoDeCompras(carrinhoDeComprasClienteLogado);
				 }
			 else 
				 JOptionPane.showMessageDialog(null,"Produto nao encontrado, tente novamente!!");
			 	
			 break;
		 case "3": 
			 break;
		 case "4": 
			 	String listaCarrinhoDeCompras = "";
			 	for(Produto produto : clienteLogado.getCarrinhoDeCompras()) 
			 		if(produto != null)
			 			listaCarrinhoDeCompras += produto + "\n";
			 	
			 	JOptionPane.showMessageDialog(null, listaCarrinhoDeCompras);
			 	
			 break;
		 case "5": 
			 var carrinhoDeComprasCliente =  clienteLogado.getCarrinhoDeCompras();
			 
			 if(carrinhoDeComprasCliente[0] != null) {
				 float valorTotal = 0f;
				 for(Produto cont : carrinhoDeComprasCliente) 
			 		if(cont != null) 
			 			valorTotal += cont.getPreco();
				 
				 String formaDePagamento = 
						 JOptionPane.showInputDialog("Valor total do carrinho: " + valorTotal + "\nQual sera a forma de pagamento?");
				 
				 if(Arrays.stream(formasDePagamentosValida).anyMatch(formaDePagamento.toLowerCase() :: equals)) {
					 JOptionPane.showMessageDialog(null, "Compra efetuada com sucesso");
					 for(Produto prod : carrinhoDeComprasCliente) 
					 		if(prod != null) 
					 			IPS.excluirProduto(prod);
					 
					 	Venda Venda = new Venda();
						
						Venda.setComprador(clienteLogado);
						Venda.setPagamento(formaDePagamento);
						Venda.setProdutos(carrinhoDeComprasCliente);
						Venda.setPrecoTotal(valorTotal);
					     
					 clienteLogado.setCarrinhoDeCompras(new Produto[100]);
				 }
				 else
					 JOptionPane.showMessageDialog(null, "Forma de pagamento invalida, tente novamente!");
			 }else
				 JOptionPane.showMessageDialog(null, "Carrinho de compras vazio!!");
			 break;
		 case "6": break;
		 default: 
			 JOptionPane.showMessageDialog(null, "Digite uma opcao valida ");
		}
	}
	
	private static void switchMenuVenda(IVendaService IVS, String opcao) {
		switch(opcao) {
		 case "1":
			 	String vendas = "";
			 	for(Venda venda : IVS.listarVendas()) 
			 		if(venda != null)
			 			vendas += venda + "\n";
			 	
			 	JOptionPane.showMessageDialog(null, vendas);
			 break;
		 case "2": 
			 int index = Integer.parseInt(JOptionPane.showInputDialog("Digite o indice da Venda que sera pesquisada"));
			 Venda v = IVS.listarVendaPorId(index);
			 
			 if(v != null)
				 JOptionPane.showMessageDialog(null, IVS.listarVendaPorId(index));
			 else	
				 JOptionPane.showMessageDialog(null, "Venda nao encontrada!");
			 
			 break;
		 case "3": 
			 break;
		 default: 
			 JOptionPane.showMessageDialog(null, "Digite uma opcao valida ");
		}
	}
	
	public static Cliente getCliente() {
		Cliente Cliente = new Cliente();
		Cliente.setCpf(Long.parseLong(JOptionPane.showInputDialog("Digite seu CPF do Cliente: ")));
		Cliente.setDataDeNascimento(JOptionPane.showInputDialog("Digite sua data de nascimento: "));
		Cliente.setNome(JOptionPane.showInputDialog("Digite seu nome: "));
		Cliente.setEmail(JOptionPane.showInputDialog("Digite seu email: "));
		Cliente.setSenha(JOptionPane.showInputDialog("Digite sua senha: "));
		Cliente.setCargo("cliente");

		return Cliente;
	}
	
	public static Cliente setAdmin(){
		Cliente Cliente = new Cliente();
		Cliente.setCpf(Long.parseLong("48993591873"));
		Cliente.setDataDeNascimento("14/11/2002");
		Cliente.setNome("Vitor Faccio");
		Cliente.setEmail("admin");
		Cliente.setSenha("admin");
		Cliente.setCargo("admin");

		return Cliente;
	}
	
	public static Cliente setFuncionario(){
		Cliente Cliente = new Cliente();
		Cliente.setCpf(Long.parseLong("48993591864"));
		Cliente.setDataDeNascimento("14/11/2002");
		Cliente.setNome("Vitor Ravenna");
		Cliente.setEmail("funcionario");
		Cliente.setSenha("funcionario");
		Cliente.setCargo("funcionario");

		return Cliente;
	}
	
	public static Produto getProduto() {
		Produto Produto = new Produto();
		Produto.setNome(JOptionPane.showInputDialog("Digite o nome do Produto"));
		Produto.setDescricao(JOptionPane.showInputDialog("Digite a descricao do Produto"));
		Produto.setPreco(Float.parseFloat(JOptionPane.showInputDialog("Digite o preco do Produto")));
		
		return Produto;
	}
	
	public static IClienteService getClienteService() {
		return new ClienteService(100);
	}
	
	public static IProdutoService getProdutoService() {
		return new ProdutoService(100);
	}
	
	public static IVendaService getVendaService() {
		return new VendaService(100);
	}
}