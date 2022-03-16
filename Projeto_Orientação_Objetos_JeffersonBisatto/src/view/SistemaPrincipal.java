package view;

import javax.swing.JOptionPane;

import controller.FuncionarioDAO;
import model.Administrador;
import model.Funcionario;

public class SistemaPrincipal {

	public static void main(String[] args) {

// Cadastra primeiro Administrador

		Funcionario funcionario = new Administrador("Jefferson Bisatto", 999158513, "jefferson.bisatto@gmail.com",
				"bisatto", "123", 3000.0, 'A',"1954");
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.cadastrar(funcionario);
		System.out.println(funcionarioDAO.listaFuncionarioTxt());

//	Login	
		LoginView telaLogin = new LoginView();
		char senhaVerificada = telaLogin.loginView();
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
