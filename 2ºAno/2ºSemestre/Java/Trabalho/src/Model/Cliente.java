package Model;

import java.util.Arrays;
import java.util.Objects;

public class Cliente {
	private int Id;
    private long Cpf;
    private String Nome;
    private String DataDeNascimento; 
    private String Email;
    private Produto[] CarrinhoDeCompras;
    private String Senha;
    private String Cargo;
    
    public Cliente(long cpf, String nome, String dataDeNascimento, String email, String senha, String cargo) {
		Cpf = cpf;
		Nome = nome;
		DataDeNascimento = dataDeNascimento;
		Email = email;
		Senha = senha;
		Cargo = cargo;
	}
    
    public Cliente() {
    	this.Cpf = 0;
    	this.Nome = "";
    	this.DataDeNascimento = "";
    	this.Email = "";
    	this.Senha = "";
    	this.Cargo = "";
    }
    
    
	public String getCargo() {
		return Cargo;
	}

	public void setCargo(String cargo) {
		Cargo = cargo;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String senha) {
		Senha = senha;
	}

	public Produto[] getCarrinhoDeCompras() {
		return CarrinhoDeCompras;
	}

	public void setCarrinhoDeCompras(Produto[] carrinhoDeCompras) {
		CarrinhoDeCompras = carrinhoDeCompras;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public long getCpf() {
		return Cpf;
	}

	public void setCpf(long cpf) {
		Cpf = cpf;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDataDeNascimento() {
		return DataDeNascimento;
	}

	public void setDataDeNascimento(String dataDeNascimento) {
		DataDeNascimento = dataDeNascimento;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "Cliente [Id=" + Id + ", Cpf=" + Cpf + ", Nome=" + Nome + ", DataDeNascimento=" + DataDeNascimento
				+ ", Email=" + Email + ", CarrinhoDeCompras=" + Arrays.toString(CarrinhoDeCompras) + ", Senha=" + Senha
				+ ", Cargo=" + Cargo + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(CarrinhoDeCompras);
		result = prime * result + Objects.hash(Cargo, Cpf, DataDeNascimento, Email, Id, Nome, Senha);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(Cargo, other.Cargo) && Arrays.equals(CarrinhoDeCompras, other.CarrinhoDeCompras)
				&& Cpf == other.Cpf && Objects.equals(DataDeNascimento, other.DataDeNascimento)
				&& Objects.equals(Email, other.Email) && Id == other.Id && Objects.equals(Nome, other.Nome)
				&& Objects.equals(Senha, other.Senha);
	}
	
	
}