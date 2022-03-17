package view;

import javax.swing.JOptionPane;

import controller.FuncionarioDAO;
import controller.LoginService;

public class LoginView {

	
//	Chama a tela de login e encaminha para o Usuario correto
	public void telaLogin() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		while (true) {

			int indexUsuario = loginView();
			if (indexUsuario == -3) {
				break;
			}
			char senhaVerificada = funcionarioDAO.buscarTipo(indexUsuario);
			if (senhaVerificada == 'A') {
				AdministradoView administradoView = new AdministradoView();
				administradoView.administradorTela(true);
			} else if (senhaVerificada == 'G') {
				GerenteView gerenteView = new GerenteView();
				gerenteView.gerenteTela(true);
			} else if (senhaVerificada == 'V') {
			} else {
				JOptionPane.showMessageDialog(null, "Login/Senha errada ou não cadastrada no sistema!");
			}
		}

	}

//	Tela de login--irá retornar o Index do Usuario ou -3 pra sair da aplicação
	public int loginView() {

		String senha = "";
		int resposta = -2;// irá retorna -2 caso tenha esquecido a senha e conseguido ter alterado a nova
							// senha!

		LoginService loginService = new LoginService();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		while (resposta == -2) {
			String login = JOptionPane
					.showInputDialog("Digite o login\nDigite: \n1-Esqueceu a senha!\nSair (Calcelar)");
			if (login==null) {
				resposta = -3;
				break;
			}
			if (login.equals("1")) {
				resposta = loginService.esqueceuSenha();
			} else {
				senha = JOptionPane.showInputDialog("Digite a senha");
				resposta = loginService.controlarErro(funcionarioDAO.verificaSenha(login, senha));
			}

		}
		return resposta;

	}

}
