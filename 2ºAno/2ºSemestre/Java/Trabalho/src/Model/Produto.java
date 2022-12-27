package Model;

import java.util.Objects;

public class Produto {
	private int Id;
    private String Nome;
    private String Descricao;
    private float Preco;
    
    
	public Produto(String nome, String descricao, float preco) {
		Nome = nome;
		Descricao = descricao;
		Preco = preco;
	} 

	public Produto() {
		Nome = "";
		Descricao = "";
		Preco = 0f;
	}

	@Override
	public String toString() {
		return "Produto [Id=" + Id + ", Nome=" + Nome + ", Descricao=" + Descricao + ", Preco=" + Preco + "]";
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public float getPreco() {
		return Preco;
	}

	public void setPreco(float preco) {
		Preco = preco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Descricao, Id, Nome, Preco);
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
		return Objects.equals(Descricao, other.Descricao) && Id == other.Id && Objects.equals(Nome, other.Nome)
				&& Float.floatToIntBits(Preco) == Float.floatToIntBits(other.Preco);
	}
}
