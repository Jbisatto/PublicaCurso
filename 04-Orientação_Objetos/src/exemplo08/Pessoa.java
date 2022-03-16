package exemplo08;

public class Pessoa extends Colaborador {
	
	String nome;
	int idade;
	
	public Pessoa(String nome, int idade, String cargo,double salario) {
		this.nome=nome;
		this.idade=idade;
		this.cargo=cargo;
		this.salario=salario;
		mensagem();
	}

	private void mensagem() {
		System.out.println("Nome: "+nome);
		System.out.println("Idade: "+idade);
		System.out.println("Cargo: "+cargo);
		System.out.println("Salario: "+salario);
	}
}
