package model;

public class Gerente extends Funcionario implements IComissao {

	public Gerente() {
		super();
	}

	public Gerente(String nome, String telefone, String email, String login, String senha, double salario, char tipo,
			String perguntaSenha) {
		super(nome, telefone, email, login, senha, salario, tipo, perguntaSenha);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Calcula a comiss�o do Gerente
	 */
	@Override
	public double comissao(double valor) {
		return valor * 0.08;
	}

}
