package modelo;

public class Login {
	private String nome;
	private int senha;
	private char nivel;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public char getNivel() {
		return nivel;
	}
	public void setNivel(char nivel) {
		this.nivel = nivel;
	}
	@Override
	public String toString() {
		return nome + ","+ senha +","+ nivel;
	}
	

}
