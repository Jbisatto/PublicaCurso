package Prototype;

public class Documento implements Cloneable {
	private String nome;
	private String tipo;
	private String seguranca;
	
	@Override
	protected Documento clone() throws CloneNotSupportedException {
		return (Documento)super.clone();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSeguranca() {
		return seguranca;
	}

	public void setSeguranca(String seguranca) {
		this.seguranca = seguranca;
	}
	

	@Override
	public String toString() {
		return "Nome: " + nome + ", tipo: " + tipo + ", seguranca: " + seguranca;
	}
	
}
