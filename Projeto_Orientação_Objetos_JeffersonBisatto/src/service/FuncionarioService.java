package service;

import javax.swing.JOptionPane;

import controller.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioService {

	// Esse metodo pede o id para alterar validando o que é digitado retornando um
	// index do funcionario ou -1 se ele cancelar a alteração
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

//		Valida Tipo, entra num laço até que seja escolhido o tipo certo	
	public char validaTipo(String frase) {
		int tipo = 0;
		char tipoFuncionario = ' ';
		boolean sair = (frase == " novo ") ? false : true;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		while (sair) {
			try {
				tipo = Integer.parseInt(
						JOptionPane.showInputDialog("Digite o" + frase + "Tipo de Funcionário\n1-Gerente\n2-Vendedor"));
				tipoFuncionario = funcionarioDAO.buscarTipoCadastrar(tipo);
				if (tipoFuncionario != 'E') {
					break;
				} else {
					JOptionPane.showMessageDialog(null, "Opção invalida!!!");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Digite um caracter invalido!!!");
			}
		}
		return tipoFuncionario;
	}

//		Valida Salario não aceirtando um String
	public Double validaSalario(String frase) {
		double salario = 0;
		while (true) {
			try {
				salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o" + frase + "salário do usuário"));
				break;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Digite um valor válido!!!");
			}
		}
		return salario;
	}

	// Esse metodo pede o id para alterar validando o que é digitado retornando um
	// index do funcionario ou -1 se ele cancelar a alteração
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
