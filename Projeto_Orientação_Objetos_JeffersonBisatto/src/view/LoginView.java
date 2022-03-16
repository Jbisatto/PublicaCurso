package view;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

import controller.FuncionarioDAO;
import model.Funcionario;

public class LoginView {

//	Tela de login
	public char loginView() {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		String senha = "";
		boolean sair = true;
		char resposta = '-';

		String login = JOptionPane.showInputDialog("Digite o login\nDigite 1 caso esqueceu a senha!");
		sair = login.equals("1") ? true : false;
		if (sair) {
			esqueceuSenha();
		} else {
			senha = JOptionPane.showInputDialog("Digite a senha");
			resposta = funcionarioDAO.verificaSenha(login, senha);
			controlarErro(resposta);
		}

		return resposta;

	}

// Controla quantidade de erro
	public char controlarErro(char resposta) {

		int qtderros = 0;
		String login = "", senha = "";
		while (true) {

			if (qtderros != 3) {
				if (resposta == '0') {
					qtderros++;
					login = JOptionPane.showInputDialog("Numeros de tentativas restantes :" + (3 - qtderros)
							+ "\nDigite o login" + "\nDigite 1 caso esqueceu a senha!");
					if (login.equals("1")) {
						return esqueceuSenha();

					}
					senha = JOptionPane
							.showInputDialog("Numeros de tentativas restantes :" + (3 - qtderros) + "\nDigite a senha");
				} else {
					break;
				}
			} else {
				qtderros= bloqueadoErro(3);
			}

		}
		return resposta;
	}

//caso esqueceu a senha
	public char esqueceuSenha() {
		int erroRecuperacao = 0;
		while (true) {
			Funcionario funcionario = new Funcionario();
			FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
			String login = "";
			try {
				while (true) {
					login = JOptionPane.showInputDialog("Recuperação de Senha\nNumeros de tentativas restantes :" + (3 - erroRecuperacao) +"\nDigite o login");
					if (funcionarioDAO.buscarLogin(login)) {
						return recuperacaoLogin(true);
					} else {
						erroRecuperacao++;
						JOptionPane.showMessageDialog(null, "Login não encontrado\n");
					}if(erroRecuperacao==3) {
						erroRecuperacao= (bloqueadoErro(10)+1);
					}
				}

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Opção invalida!!!");
			}

		}

	}

// Recupera Login verificando se o Usuario existe
	public char recuperacaoLogin(boolean funcionarioEncontrado) {
		int teleEmail;
		if (funcionarioEncontrado) {
			teleEmail = Integer.parseInt(
					JOptionPane.showInputDialog("Como deseja recuperar a senha?\n1-Por Telefone\n2-Por E-mail"));
			if (teleEmail == 1) {
				recuperarTelefone();
			} else if (teleEmail == 2) {
				recuperarEmail();
			} else {
				JOptionPane.showMessageDialog(null, "Opção invalida!!!");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Login errado ou não cadastrada no sistema!");
		}
		return't';
		
		
		
//		CONFERIR aqui em cima
	}

	public void recuperarEmail() {
		String telefone = "";
		telefone = JOptionPane.showInputDialog("Informe o Telefone:");

	}

	public void recuperarTelefone() {
		String email = "";
		email = JOptionPane.showInputDialog("Informe o Email:");

	}
	
//Bloqueia a Aplicação pela quantidade de tempo Informada	
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
					return qtderros = -1;
				} else {
					JOptionPane.showMessageDialog(null, "Aplicação bloqueada por " + (tempo - diferenca) + " minutos!!!");
				}
			}
		}

}
