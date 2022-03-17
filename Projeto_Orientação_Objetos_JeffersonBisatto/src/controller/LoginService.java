package controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Funcionario;

public class LoginService {

	// Controla quantidade de erro
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

	// Bloqueia a Aplicação pela quantidade de tempo Informada e zera a quatidade de
	// erros!!!
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
				JOptionPane.showMessageDialog(null, "Aplicação bloqueada por " + (tempo - diferenca) + " minutos!!!");
			}
		}
		return qtderros;
	}

	// caso esqueceu a senha
	public int esqueceuSenha() {

		int erroRecuperacao = 0;

		String login = "";

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		while (true) {
			int retornoRecuperacao = -1;
			login = JOptionPane.showInputDialog("Recuperação de Senha\nNumeros de tentativas restantes :"
					+ (3 - erroRecuperacao) + "\nDigite o login");
			if (funcionarioDAO.buscarLogin(login)) {
				retornoRecuperacao = recuperacaoLogin(login);
			}
			if (retornoRecuperacao == -1) {
				erroRecuperacao++;
				JOptionPane.showMessageDialog(null, "Login não encontrado\n");
			} else {
				return retornoRecuperacao;
			}
			if (erroRecuperacao == 3) {
				erroRecuperacao = (bloqueadoErro(10) + 1);// Bloqueia o Login por 10 minutos
			}
		}
	}

	// Recupera Login verificando se o Usuario existe
	public int recuperacaoLogin(String login) {
		int teleEmail = -1;
		int resposta = -1;
		while (true) {
			try {
				teleEmail = Integer.parseInt(
						JOptionPane.showInputDialog("Como deseja recuperar a senha?\n1-Por Telefone\n2-Por E-mail"));
				if (teleEmail == 1) {
					resposta = recuperarTelefone(login);
					break;
				} else if (teleEmail == 2) {
					resposta = recuperarEmail(login);
					break;
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Opção invalida!!!");
				break;
			}

		}
		return resposta;
	}

	// RECUPERCAO TELEFONE
	public int recuperarTelefone(String login) {
		String telefone = "";
		int resposta = -1;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		telefone = JOptionPane.showInputDialog("Informe o Telefone:");
		resposta = funcionarioDAO.buscarTelefone(telefone, login);
		if (resposta != -1) {
			resposta = alterarSenha(resposta);
		}
		return resposta;
	}

	// RECUPERCAO POR EMAIL
	public int recuperarEmail(String login) {
		String email = "";
		int resposta = -1;
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		email = JOptionPane.showInputDialog("Informe o Email:");
		resposta = funcionarioDAO.buscarEmail(email, login);
		if (resposta != -1) {
			resposta = alterarSenha(resposta);
		}
		return resposta;
	}

	// FAZ A PERGUNTA E TROCA A SENHA--Irá retornar -1 se digitou a frase errada e
	// -2 de alterou a senha
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
