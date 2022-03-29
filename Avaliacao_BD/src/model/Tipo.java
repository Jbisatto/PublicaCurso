package model;

public class Tipo {
	
	private int codigoTipo;
	private String nomeTipo;
	
	
	public Tipo() {
		
	}
	
	public Tipo(int codigoTipo, String nomeTipo) {
		super();
		this.codigoTipo = codigoTipo;
		this.nomeTipo = nomeTipo;
	}
	
	
	public int getCodigoTipo() {
		return codigoTipo;
	}
	public void setCodigoTipo(int codigoTipo) {
		this.codigoTipo = codigoTipo;
	}
	public String getNomeTipo() {
		return nomeTipo;
	}
	public void setNomeTipo(String nomeTipo) {
		this.nomeTipo = nomeTipo;
	}
	
	
	

}
