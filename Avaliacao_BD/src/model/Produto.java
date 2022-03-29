package model;

public class Produto {
	private int codigoProduto;
    private String nome;
    private double valor;
    private int marca;
    private int tipo;
    
    
    public Produto() {
    	
    }    
    
	public Produto(int codigoProduto, String nome, double valor, int marca, int tipo) {
		super();
		this.codigoProduto = codigoProduto;
		this.nome = nome;
		this.valor = valor;
		this.marca = marca;
		this.tipo = tipo;
	}
	public int getCodigoProduto() {
		return codigoProduto;
	}
	public void setCodigoProduto(int codigoProduto) {
		this.codigoProduto = codigoProduto;
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
	public int getMarca() {
		return marca;
	}
	public void setMarca(int marca) {
		this.marca = marca;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
