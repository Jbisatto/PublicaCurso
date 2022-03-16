package exemplo09;

public class Pessoa extends Colaborador{
	
	 private String nome;
	 private int idade;
	
	public Pessoa(String nome, int idade, String cargo, double salario) {
		super(cargo,salario);
		this.nome=nome;
		this.idade=idade;

	}

}
