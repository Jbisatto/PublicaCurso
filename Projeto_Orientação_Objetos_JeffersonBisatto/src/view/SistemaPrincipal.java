package view;

import controller.FuncionarioDAO;
import model.Administrador;
import model.Funcionario;

public class SistemaPrincipal {

	public static void main(String[] args) {

// Cadastra primeiro Administrador

		Funcionario funcionario = new Administrador("Jefferson Bisatto", "999158513", "jefferson.bisatto@gmail.com",
				"bisatto", "123", 3000.0, 'A', "1954");
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		funcionarioDAO.cadastrar(funcionario);
		System.out.println(funcionarioDAO.listaFuncionarioTxt());

//	Login	
		LoginView telaLogin = new LoginView();
		telaLogin.telaLogin();

	}

}
