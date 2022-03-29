package model;

public class Marca {
	private int codigoMarca;
	private String marca;
	
	
	public Marca() {
		
	}
	
	public Marca(int codigoMarca, String marca) {
		super();
		this.codigoMarca = codigoMarca;
		this.marca = marca;
	}
	
	
	public int getCodigoMarca() {
		return codigoMarca;
	}
	public void setCodigoMarca(int codigoMarca) {
		this.codigoMarca = codigoMarca;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	

}
