package exemplo03;

public class Pessoa {
	/*
	 Default: Atributos e m�todos vis�veis apenas no mesmo pacote;
	 Public: Atributos e m�todos vis�veis em todo o projeto;
	 Private: Atributos e m�todos vis�veis apenas na classes onde s�o criadas;
	 Protected: Atributos e m�todos vis�veis nas classes onde s�o criadas ou herdadas; 
	 */
	String nome;
	public int idade;
	private double peso;
	protected double altura;
	
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	
	

}
