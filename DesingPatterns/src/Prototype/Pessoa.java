package Prototype;

public class Pessoa implements Cloneable {
	
	private String pessoa;
	private int idade;
	
	public Pessoa() {
	}
	
	public Pessoa(String pessoa, int idade) {
		super();
		this.pessoa = pessoa;
		this.idade = idade;
	}
	public String getPessoa() {
		return pessoa;
	}
	public void setPessoa(String pessoa) {
		this.pessoa = pessoa;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		return "Nome: " + pessoa + ", idade: " + idade;
	}
		
	@Override
	protected Pessoa clone() throws CloneNotSupportedException {
		return (Pessoa)super.clone();
	}

}
