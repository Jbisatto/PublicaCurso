package service;

import controller.FuncionarioDAO;
import controller.MarcaDAO;
import controller.ProdutoDAO;
import controller.VendaDAO;
import model.Administrador;
import model.Funcionario;
import model.Marca;
import model.Produto;
import model.Venda;

public class PopuladorService {

	/**
	 * Carregar os dados dos Array 
	 */
	public void populador() {
		

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		MarcaDAO marcaDAO = new MarcaDAO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		VendaDAO vendaDAO = new VendaDAO();
		
		
		Funcionario funcionario = new Administrador("Jefferson Bisatto", "999158513", "jefferson.bisatto@gmail.com",
				"bisatto", "123", 3000.0, 'A', "1954");
		funcionarioDAO.cadastrar(funcionario);
		
		Marca marca = new Marca("Acer");
		marcaDAO.cadastrar(marca);

		Marca marca2 = new Marca("Dell");
		marcaDAO.cadastrar(marca2);
		
		Marca marca3 = new Marca("Asus");
		marcaDAO.cadastrar(marca3);
				
		Produto produto = new Produto(0, "NoteBook Nitro 5", 5499);
		produtoDAO.cadastrar(produto);
		
		Produto produto2 = new Produto(1, "Inspiron 15", 3499);
		produtoDAO.cadastrar(produto2);
		
		Produto produto3 = new Produto(2, "Zen Book 14", 4499);
		produtoDAO.cadastrar(produto3);

		Venda venda = new Venda(0, 0, 2);
		vendaDAO.cadastrar(venda);
		
		Venda venda1 = new Venda(0, 1, 1);
		vendaDAO.cadastrar(venda1);
		
		Venda venda2 = new Venda(0, 2, 1);
		vendaDAO.cadastrar(venda2);
	}
}
