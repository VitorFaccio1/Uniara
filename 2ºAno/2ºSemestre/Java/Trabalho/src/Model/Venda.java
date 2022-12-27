package Model;

public class Venda {
	private int Id;
    private Cliente Comprador;
    private String Pagamento;
    private Produto[] Produtos;
    private float PrecoTotal;
    
    
	public Venda(Cliente comprador, String pagamento, Produto[] produtos, float precoTotal) {
		Comprador = comprador;
		Pagamento = pagamento;
		Produtos = produtos;
		PrecoTotal = precoTotal;
	}
	
	public Venda() {
		Comprador = new Cliente();
		Pagamento = "";
		Produtos = new Produto[100];
		PrecoTotal = 0.0f;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Cliente getComprador() {
		return Comprador;
	}
	public void setComprador(Cliente comprador) {
		Comprador = comprador;
	}
	public String getPagamento() {
		return Pagamento;
	}
	public void setPagamento(String pagamento) {
		Pagamento = pagamento;
	}
	public Produto[] getProdutos() {
		return Produtos;
	}
	public void setProdutos(Produto[] produtos) {
		Produtos = produtos;
	}
	public float getPrecoTotal() {
		return PrecoTotal;
	}
	public void setPrecoTotal(float precoTotal) {
		PrecoTotal = precoTotal;
	}
}
