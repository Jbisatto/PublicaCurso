package view;

import controller.FuncionarioDAO;
import controller.MarcaDAO;
import controller.ProdutoDAO;
import controller.VendaDAO;
import model.Administrador;
import model.Funcionario;
import model.Marca;
import model.Produto;
import model.Venda;

public class SistemaPrincipal {

	public static void main(String[] args) {

		/**
		 * Carregar os dados dos Array ADMINISTRADOR LOGIN = bisatto SENHA = 123
		 */
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = new Administrador("Jefferson Bisatto", "999158513", "jefferson.bisatto@gmail.com",
				"bisatto", "123", 3000.0, 'A', "1954");
		funcionarioDAO.cadastrar(funcionario);

		MarcaDAO marcaDAO = new MarcaDAO();
		Marca marca = new Marca("Acer");
		marcaDAO.cadastrar(marca);

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = new Produto(0, "NoteBook Nitro 5", 5499);
		produtoDAO.cadastrar(produto);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = new Venda(0, 0, 2);
		vendaDAO.cadastrar(venda);

//	Login	
		LoginView telaLogin = new LoginView();
		telaLogin.telaLogin();

	}

}
