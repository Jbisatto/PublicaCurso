package service;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import controller.FuncionarioDAO;
import model.Funcionario;

public class LoginService {

	/**
	 * Controla quantidade de erro retorna -3 se o usuario clicou em cancelar.
	 * Quando � feito o login, e verificado o login e senha, caso esteja errado ir�
	 * contar 3 erro e ap�s isso ir� bloquear a aplica��o por 3 minutos.
	 */
	public int controlarErro(int resposta) {
		int qtderros = 0;

		String login = "", senha = "";

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		while (true) {

			if (qtderros != 2) {
				if (resposta == -1) {
					qtderros++;
					login = JOptionPane.showInputDialog("Numeros de tentativas restantes :" + (3 - qtderros)
							+ "\nDigite o login" + "\nDigite: \n1-Esqueceu a senha!\nSair (Calcelar)");
					if (login == null) {
						resposta = -3;
						break;
					}
					if (login.equals("1")) {
						return esqueceuSenha();
					} else {
						senha = JOptionPane.showInputDialog(
								"Numeros de tentativas restantes :" + (3 - qtderros) + "\nDigite a senha");
						resposta = funcionarioDAO.verificaSenha(login, senha);
					}
				} else {
					break;
				}
			} else {
				qtderros = bloqueadoErro(3);
			}

		}
		return resposta;
	}

	/**
	 * Bloqueia a aplica��o pelo tempo passado em minutos. Esse metodo bloqueia os 3
	 * minutos do erro e os 10 minutos de erros quando esqueceu a senha
	 */
	public int bloqueadoErro(int tempo) {
		Date dataHoraErro = null, dataHoraAtual = null;
		String hora = "";
		int diferenca = 0, qtderros = 0;
		while (true) {
			if (hora.equals("")) {
				dataHoraErro = new Date();
				hora = new SimpleDateFormat("mm:ss").format(dataHoraErro);
			} else {
				dataHoraAtual = new Date();
				diferenca = (int) ((dataHoraAtual.getTime() - dataHoraErro.getTime()) / 1000) / 60;
			}
			if ((tempo - diferenca) <= 0) {
				qtderros = -1;
				break;
			} else {
				JOptionPane.showMessageDialog(null, "Aplica��o bloqueada por " + (tempo - diferenca) + " minutos!!!");
			}
		}
		return qtderros;
	}

	/**
	 * Esse m�todo permite o Usu�rio recuperar a senha, verificando primeiro se o
	 * login existe, caso o usu�rio erre por 3 vezes a aplica��o ser� bloqueada por
	 * 10 minutos
	 */
	public int esqueceuSenha() {

		int erroRecuperacao = 0;

		String login = "";

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		while (true) {
			int retornoRecuperacao = -1;
			login = JOptionPane.showInputDialog("Recupera��o de Senha\nNumeros de tentativas restantes :"
					+ (3 - erroRecuperacao) + "\nDigite o login");
			if(login==null) {
				break;
			}
			if (funcionarioDAO.buscarLogin(login)) {
				retornoRecuperacao = recuperacaoLogin(login);
			}
			if (retornoRecuperacao == -1) {
				erroRecuperacao++;
				JOptionPane.showMessageDialog(null, "Login n�o encontrado\n");
			} else {
				return retornoRecuperacao;
			}
			if (erroRecuperacao == 3) {
				erroRecuperacao = (bloqueadoErro(10) + 1);// Bloqueia o Login por 10 minutos
			}
		}
	}

	/**
	 * Atrav�s do login, ele permite o usu�rio escolher a forma de recupera��o de
	 * login (Telefone ou email)
	 */
	public int recuperacaoLogin(String login) {
		int teleEmail = -1;
		int resposta = -1;
		while (true) {
			try {
				teleEmail = Integer.parseInt(
						JOptionPane.showInputDialog("Como deseja recuperar a senha?\n1-Por Telefone\n2-Por E-mail"));
				if (teleEmail == 1) {
					resposta = recuperarSenha(login, 'T');
					break;
				} else if (teleEmail == 2) {
					resposta = recuperarSenha(login, 'E');
					break;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Op��o invalida!!!");
				break;
			}

		}
		return resposta;
	}

	/**
	 * Atrav�s do login e faz uma recupera��o pelo Telefone ou Email do usuario, se
	 * tivera verfica��o for falsa ir� retora -1 n�o proceguindo com a altera�ao da
	 * senha.
	 */
	public int recuperarSenha(String login, char tipo) {
		String telefone = "", email = "";
		int resposta = -1;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		if (tipo == 'T') {
			telefone = JOptionPane.showInputDialog("Informe o Telefone:");
			resposta = funcionarioDAO.buscarTelefone(telefone, login);
		} else {
			email = JOptionPane.showInputDialog("Informe o Email:");
			resposta = funcionarioDAO.buscarEmail(email, login);
		}
		if (resposta != -1) {
			resposta = alterarSenha(resposta);
		}
		return resposta;
	}

	/**
	 * FAZ A PERGUNTA E TROCA A SENHA
	 * Ir� retornar -1 se digitou a frase errada e
	 * -2 de alterou a senha
	 */
	public int alterarSenha(int index) {
		int resposta = -1;
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionario = funcionarioDAO.buscarIndex(index);
		String respostaPergunta = JOptionPane.showInputDialog("Qual o ano de nascimento do seu pai?");
		if (funcionario.getPerguntaSenha().equals(respostaPergunta)) {
			resposta = -2;
			funcionario.setSenha(JOptionPane.showInputDialog("Digite uma nova senha:"));
			funcionarioDAO.alterar(funcionario, index);
			JOptionPane.showMessageDialog(null, "Senha redefinida!!!");
		}
		return resposta;
	}

}
