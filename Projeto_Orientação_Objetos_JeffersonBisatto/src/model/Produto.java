package model;

public class Produto {

	private int id_marca;
	private String nome;
	private int quantidade;
	private double valor;

	public Produto() {

	}

	public Produto(int id_marca, String nome, int quantidade, double valor) {
		super();
		this.id_marca = id_marca;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
	}

	public int getId_marca() {
		return id_marca;
	}

	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
