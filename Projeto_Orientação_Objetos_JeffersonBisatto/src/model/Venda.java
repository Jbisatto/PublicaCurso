package model;

public class Venda {
	private int id_funcionario;
	private int id_produto;
	private int qtdProdutos;

	public Venda() {
		
	}
	
	public Venda(int id_funcionario, int id_produto, int qtdProdutos) {
		super();
		this.id_funcionario = id_funcionario;
		this.id_produto = id_produto;
		this.qtdProdutos = qtdProdutos;
	}

	public int getId_funcionario() {
		return id_funcionario;
	}

	public void setId_funcionario(int id_funcionario) {
		this.id_funcionario = id_funcionario;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public int getQtdProdutos() {
		return qtdProdutos;
	}

	public void setQtdProdutos(int qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}

}
