package model;

public class Administrador extends Funcionario implements IComissao {

	public Administrador() {
		super();
	}

	public Administrador(String nome, String telefone, String email, String login, String senha, double salario,
			char tipo, String perguntaSenha) {
		super(nome, telefone, email, login, senha, salario, tipo, perguntaSenha);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double comissao(double valor) {

		return valor * 0.10;
	}

}
