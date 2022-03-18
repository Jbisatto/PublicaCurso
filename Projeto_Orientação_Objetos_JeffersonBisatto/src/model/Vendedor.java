package model;

public class Vendedor extends Funcionario implements IComissao{

	public Vendedor() {
		super();
	}

	public Vendedor(String nome, String telefone, String email, String login, String senha, double salario, char tipo,
			String perguntaSenha) {
		super(nome, telefone, email, login, senha, salario, tipo, perguntaSenha);
	}

	/**
	 * Calcula a comissão do Vendedor
	 */
	@Override
	public double comissao(double valor) {
		return valor*0.05;
	}

}
