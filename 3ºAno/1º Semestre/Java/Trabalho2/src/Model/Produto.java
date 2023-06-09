package Model;

import java.util.Objects;

public class Produto {
	private int id;

	private String nome;

	private String descricao;

	private double preco;

	private int qtd;

	public Produto() {
		this.id = 0;
		this.nome = "";
		this.descricao = "";
		this.preco = 0;
		this.qtd = 0;
	}

	public Produto(int id, String nome, String descricao, double preco, int qtd) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.qtd = qtd;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco + ", qtd=" + qtd
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(descricao, id, nome, preco, qtd);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(descricao, other.descricao) && id == other.id && Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(preco) == Double.doubleToLongBits(other.preco) && qtd == other.qtd;
	}
}