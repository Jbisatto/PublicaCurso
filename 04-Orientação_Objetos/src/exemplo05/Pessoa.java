package exemplo05;

public class Pessoa {
	
	public Pessoa() {
		System.out.println("Construtor executado");
	}
	
	
	public Pessoa(String nome) {
		System.out.println("Bom dia "+nome);
	}
	
	public Pessoa(String nome, int idade) {
		System.out.println("Ol�, meu nome � "+nome+" e tenho "+idade+" anos.");
	}
}
