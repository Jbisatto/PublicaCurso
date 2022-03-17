package service;

import javax.swing.JOptionPane;

import controller.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioService {

	// Esse metodo pede o id para alterar validando o que � digitado retornando um
	// index do funcionario ou -1 se ele cancelar a altera��o
	public int pedirId(String frase) {
		int respostas;
		String validaResposta;
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		while (true) {
			try {
				validaResposta = JOptionPane.showInputDialog(
						funcionarioDAO.listaFuncionarioTxtPersonalizado() + "\nDigite o codigo para" + frase + ":");
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

//		Valida Tipo, entra num la�o at� que seja escolhido o tipo certo	
	public char validaTipo(String frase) {
		int tipo = 0;
		char tipoFuncionario = ' ';
		boolean sair = (frase == " novo ") ? false : true;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		while (sair) {
			try {
				tipo = Integer.parseInt(
						JOptionPane.showInputDialog("Digite o" + frase + "Tipo de Funcion�rio\n1-Gerente\n2-Vendedor"));
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

//		Valida Salario n�o aceirtando um String
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

	// Esse metodo pede o id para alterar validando o que � digitado retornando um
	// index do funcionario ou -1 se ele cancelar a altera��o
	public int pedirIdSemAdm(String frase) {

		int respostas;
		String validaResposta;
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		while (true) {
			try {
				validaResposta = JOptionPane.showInputDialog(
						funcionarioDAO.listaFuncionarioTxt() + "\nDigite o codigo para" + frase + ":");
				if (validaResposta == null) {
					respostas = -1;
					break;
				}
				respostas = Integer.parseInt(validaResposta);
//						caso tentar alterar o Administardor
				if (respostas == 0) {
					throw new IllegalArgumentException("Valor invalido");
				}
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
}
