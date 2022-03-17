package model;

public class Funcionario {



	private String nome;
	private String telefone;
	private String email;
	private String login;
	private String senha;
	private double salario;
	private char tipo;
	private String perguntaSenha;

	public Funcionario() {

	}

	public Funcionario(String nome, String telefone, String email, String login, String senha, double salario,
			char tipo, String perguntaSenha) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.salario = salario;
		this.tipo = tipo;
		this.perguntaSenha = perguntaSenha;
	}

	public char getTipo() {
		return tipo;
	}

	public void setTipo(char tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getPerguntaSenha() {
		return perguntaSenha;
	}

	public void setPerguntaSenha(String perguntaSenha) {
		this.perguntaSenha = perguntaSenha;
	}
	@Override
	public String toString() {
		return "  Nome:" + nome + ", telefone:" + telefone + ", email:" + email + ", login:" + login
				+ ", senha:" + senha + ", salario:" + salario + ", tipo:" + tipo + ", perguntaSenha:" + perguntaSenha;
	}
}
