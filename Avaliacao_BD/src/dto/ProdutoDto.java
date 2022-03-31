package dto;

public class ProdutoDto {
	private int codigoProduto;
    private String nome;
    private double valor;
    private String marca;
    private String tipo;
    
    public ProdutoDto() {
    	
    }
	
    public ProdutoDto(int codigoProduto, String nome, double valor, String marca, String tipo) {
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
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}    

}
