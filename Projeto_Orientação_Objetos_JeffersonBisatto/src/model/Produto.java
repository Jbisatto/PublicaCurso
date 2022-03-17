package model;

public class Produto {

	private int id_marca;
	private String nome;
	private double valor;

	public Produto() {

	}

	public Produto(int id_marca, String nome, double valor) {
		super();
		this.id_marca = id_marca;
		this.nome = nome;
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


	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return ", Nome:" + nome + ", valor:" + valor;
	}

}
