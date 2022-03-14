package exemplo03;

public class Pessoa {
	/*
	 Default: Atributos e métodos visíveis apenas no mesmo pacote;
	 Public: Atributos e métodos visíveis em todo o projeto;
	 Private: Atributos e métodos visíveis apenas na classes onde são criadas;
	 Protected: Atributos e métodos visíveis nas classes onde são criadas ou herdadas; 
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
