package modelo;

public class Aluno extends Login {

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

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

}
