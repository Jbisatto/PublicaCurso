package view;

import service.PopuladorService;

public class SistemaPrincipal {

	public static void main(String[] args) {

		/**
		 * ADMINISTRADOR LOGIN = bisatto SENHA = 123 Popular os dados
		 */
		PopuladorService populadorService = new PopuladorService();
		populadorService.populador();

		/**
		 * Inicio da aplicação Login
		 */
		LoginView telaLogin = new LoginView();
		telaLogin.telaLogin();

	}

}
