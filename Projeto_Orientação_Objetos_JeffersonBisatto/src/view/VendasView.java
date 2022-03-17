package view;

import javax.swing.JOptionPane;

import controller.VendaDAO;
import model.Venda;
import service.FuncionarioService;
import service.ProdutoService;
import service.VendaService;

public class VendasView {
	public void tela(String tipoUsuario) {
		boolean senhaVerificada = true;
//		Criar, Alterar e Excluir
		while (senhaVerificada) {
			try {
				int acao = Integer.parseInt(JOptionPane.showInputDialog(tipoUsuario + " LOGADO\n1-Cadastrar Venda"
						+ "\n2-Alterar Venda" + "\n3-Remover Venda" + "\n4-Sair"));
				switch (acao) {
				case 1: {
					cadastrarVenda();
					break;
				}
				case 2: {
					alterarVenda();
					break;
				}
				case 3: {
					removerVenda();
					break;
				}
				case 4: {
					senhaVerificada = false;
					break;
				}

				default: {
					JOptionPane.showMessageDialog(null, "Opção invalida!!!");

				}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Caracter invalido!!!");
			}

		}

	}

	private void cadastrarVenda() {

		Venda venda = new Venda();
		VendaDAO vendaDAO = new VendaDAO();
		FuncionarioService funcionarioService = new FuncionarioService();
		ProdutoService produtoService = new ProdutoService();
		venda.setId_funcionario(funcionarioService.pedirId(" adicionar Vendedor:"));
		venda.setId_produto(produtoService.pedirIdProduto(" adicionar nas Venda"));
		venda.setQtdProdutos(produtoService.validarQuantidade());

		vendaDAO.cadastrar(venda);

	}


	private void alterarVenda() {
		int index;
		Venda venda = new Venda();
		VendaDAO vendaDAO = new VendaDAO();
		FuncionarioService funcionarioService = new FuncionarioService();
		ProdutoService produtoService = new ProdutoService();
		VendaService vendaService = new VendaService();

		index = vendaService.pedirIdVenda(" alterar ");
		if (index != -1) {
			venda = vendaDAO.buscarIndex(index);
			venda.setId_funcionario(funcionarioService.pedirId(" alterar Vendedor:"));
			venda.setId_produto(produtoService.pedirIdProduto(" alterar nas Venda"));
			venda.setQtdProdutos(produtoService.validarQuantidade());

			vendaDAO.alterar(venda, index);

		}
	}

	private void removerVenda() {
		VendaDAO vendaDAO = new VendaDAO();
		VendaService vendaService = new VendaService();
		vendaDAO.remover(vendaService.pedirIdVenda(" remover "));

	}

}
