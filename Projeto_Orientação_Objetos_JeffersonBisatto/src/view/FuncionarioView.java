package view;

import javax.swing.JOptionPane;

import controller.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioView {

	public void tela(String tipoUsuario) {
		boolean senhaVerificada = true;
//		Criar, Alterar e Excluir
		while (senhaVerificada) {
			try {
				int acao = Integer.parseInt(JOptionPane.showInputDialog(tipoUsuario + " LOGADO\n1-Cadastrar Usu�rio"
						+ "\n2-Alterar Usu�rio" + "\n3-Remover Usuario" + "\n4-Sair"));
				switch (acao) {
				case 1: {
					cadastrarUsuario();
					break;
				}
				case 2: {
					alterarUsuario();
					break;
				}
				case 3: {
					removerUsuario();
					break;
				}
				case 4: {
					senhaVerificada = false;
					break;
				}

				default: {
					JOptionPane.showMessageDialog(null, "Op��o invalida!!!");

				}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Caracter invalido!!!");
			}

		}

	}

	public void cadastrarUsuario() {

		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionario.setNome(JOptionPane.showInputDialog("Digite o nome do usu�rio"));
		funcionario.setTelefone(JOptionPane.showInputDialog("Digite o telefone do usu�rio"));
		funcionario.setEmail(JOptionPane.showInputDialog("Digite o email do usu�rio"));
		funcionario.setLogin(JOptionPane.showInputDialog("Digite o login do usu�rio"));
		funcionario.setSenha(JOptionPane.showInputDialog("Digite a senha do usu�rio"));
		funcionario.setPerguntaSenha(JOptionPane.showInputDialog("Digite a data de nascimento do Pai"));
		funcionario.setSalario(validaSalario(" "));
		funcionario.setTipo(validaTipo(" "));

		funcionarioDAO.cadastrar(funcionario);
	}

	public void alterarUsuario() {
		int index;
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		index = pedirId(" alterar ");
		if (index != -1) {
			funcionario = funcionarioDAO.buscarIndex(index);
			funcionario.setNome(
					JOptionPane.showInputDialog("Digite o novo nome do usu�rio( " + funcionario.getNome() + "):"));
			funcionario.setTelefone(JOptionPane
					.showInputDialog("Digite o novo telefone do usu�rio( " + funcionario.getTelefone() + "):"));
			funcionario.setEmail(
					JOptionPane.showInputDialog("Digite o novo email do usu�rio( " + funcionario.getEmail() + "):"));
			funcionario.setLogin(
					JOptionPane.showInputDialog("Digite o novo login do usu�rio( " + funcionario.getLogin() + ")"));
			funcionario.setSenha(
					JOptionPane.showInputDialog("Digite a nova senha do usu�rio( " + funcionario.getSenha() + ")"));
			funcionario.setPerguntaSenha(JOptionPane
					.showInputDialog("Digite a data de nascimento do Pai( " + funcionario.getPerguntaSenha() + ")"));
			funcionario.setSalario(validaSalario(" novo "));
			funcionario.setTipo(validaTipo(" novo "));

			funcionarioDAO.alterar(funcionario, index);
		}
	}

	public void removerUsuario() {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.remover(pedirId(" remover "));
	}

//Esse metodo pede o id para alterar validando o que � digitado retornando um index do funcionario ou -1 se ele cancelar a altera��o
	public int pedirId(String frase) {
		int respostas;
		String validaResposta;
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		while (true) {
			try {
				validaResposta = JOptionPane
						.showInputDialog(funcionarioDAO.listaFuncionarioTxt() + "\nDigite o codigo para" + frase + ":");
				if (validaResposta == null) {
					respostas = -1;
					break;
				}
				respostas = Integer.parseInt(validaResposta);

				funcionario = funcionarioDAO.buscarIndex(respostas);
				if (funcionario == null) {
					throw new IllegalArgumentException("Valor invalido");
				}
				break;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Digite um caracter invalido!!!");
			}
		}
		return respostas;
	}

//	Valida Salario n�o aceirtando um String
	public Double validaSalario(String frase) {
		double salario = 0;
		while (true) {
			try {
				salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o" + frase + "sal�rio do usu�rio"));
				break;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Digite um valor v�lido!!!");
			}
		}
		return salario;
	}

//	Valida Tipo, entra num la�o at� que seja escolhido o tipo certo	
	public char validaTipo(String frase) {
		int tipo = 0;
		char tipoFuncionario = ' ';
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		while (true) {
			try {
				tipo = Integer.parseInt(JOptionPane.showInputDialog(
						"Digite o" + frase + "Tipo de Funcion�rio\n1-Administrador\n2-Gerente\n3-Vendedor"));
				tipoFuncionario = funcionarioDAO.buscarTipoCadastrar(tipo);
				if (tipoFuncionario != 'E') {
					break;
				} else {
					JOptionPane.showMessageDialog(null, "Op��o invalida!!!");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Digite um caracter invalido!!!");
			}
		}
		return tipoFuncionario;
	}
}
