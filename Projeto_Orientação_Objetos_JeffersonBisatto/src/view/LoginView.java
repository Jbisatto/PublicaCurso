package view;

import javax.swing.JOptionPane;

import controller.FuncionarioDAO;
import service.LoginService;

public class LoginView {

	/**
	 * Chama a tela de login e encaminha para o Usuario correto
	 */
	public void telaLogin() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		while (true) {

			int indexUsuario = loginView();
			if (indexUsuario == -3) { // clicou em cancelar
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
				VendedorView vendedorView = new VendedorView();
				vendedorView.vendedorTela(true);
			} else {
				JOptionPane.showMessageDialog(null, "Login/Senha errada ou não cadastrada no sistema!");
			}
		}

	}

	/**
	 * Monta a Tela de login irá retornar o Index do Usuario ou -3 pra sair da
	 * aplicação irá retorna -2 caso tenha esquecido a senha e conseguido ter
	 * alterado a nova senha!
	 */
	public int loginView() {

		String senha = "";
		int resposta = -2;
		LoginService loginService = new LoginService();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

		while (resposta == -2) {
			String login = JOptionPane.showInputDialog("---------------------LOGIN---------------------"
					+ "\n\n\n\nDigite:\n1-Esqueceu a senha! / Sair (Calcelar)");
			if (login == null) {// caso apertou em cancelar
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
