package service;

import javax.swing.JOptionPane;

import controller.FuncionarioDAO;
import model.Funcionario;

public class FuncionarioService {

	/**
	 * Esse metodo pede o id validando o que � digitado retornando um index do
	 * funcionario ou -1 se ele cancelar, frase iria especificar a opera��o e
	 * mostraAdm iria exibir o administardor ou n�o.
	 */
	public int pedirId(String frase, boolean mostraAdm) {
		int respostas;
		String validaResposta;
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		while (true) {
			try {
				validaResposta = JOptionPane.showInputDialog(funcionarioDAO.listaFuncionarioTxtPersonalizado(mostraAdm)
						+ "\nDigite o codigo para" + frase + ":");
				if (validaResposta == null) {
					respostas = -1;
					break;
				}
				respostas = Integer.parseInt(validaResposta);
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

	/**
	 * Valida Tipo, entra num la�o at� que seja escolhido o tipo certo
	 */	
	public char validaTipo(String frase) {
		int tipo = 0;
		char tipoFuncionario = ' ';
		boolean sair = (frase == " novo ") ? false : true;
		while (sair) {
			try {
				tipo = Integer.parseInt(
						JOptionPane.showInputDialog("Digite o" + frase + "Tipo de Funcion�rio\n1-Gerente\n2-Vendedor"));
				tipoFuncionario = buscarTipoCadastrar(tipo);
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

	/**
	 *Valida Salario n�o aceirtando um String
	 */	
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

	/**
	 * Retorna o por extenso o tipo do Funcionario
	 */
	public String cargoFuncionario(char tipo) {
		if (tipo == 'A') {
			return "Administrador";
		} else if (tipo == 'G') {
			return "Gerente";
		} else {
			return "Vendedor";
		}
	}

	/**
	 * Retorna o tipo do usuario, ou retorna E se caso n�o exista esse tipo
	 */
	public char buscarTipoCadastrar(int tipo) {
		if (tipo == 1) {
			return 'G';
		} else if (tipo == 2) {
			return 'V';
		} else {
			return 'E';
		}
	}
}
