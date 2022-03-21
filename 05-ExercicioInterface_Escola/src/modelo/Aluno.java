package modelo;

public class Aluno extends Login{

	private String nome;
	private char sexo;
	
	public Aluno() {
		super();
			}
	public Aluno(String login, String senha, char tipo, String nome, char sexo) {
		super(login, senha, tipo);
		this.nome = nome;
		this.sexo = sexo;
	}

}
