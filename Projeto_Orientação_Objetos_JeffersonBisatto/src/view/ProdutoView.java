package view;

import javax.swing.JOptionPane;

import controller.ProdutoDAO;
import model.Produto;
import service.MarcaService;
import service.ProdutoService;

public class ProdutoView {

	/**
	 * Monta a Tela de cadastramento de Produtos
	 */
	public void tela(String tipoUsuario) {
		boolean senhaVerificada = true;
		String verifica;
		while (senhaVerificada) {
			try {
				verifica = JOptionPane.showInputDialog(tipoUsuario + " LOGADO\n1-Cadastrar Produto"
						+ "\n2-Alterar Produto" + "\n3-Remover Produto" + "\n4-Sair");
				if (verifica == null) {
					break;
				}

				int acao = Integer.parseInt(verifica);
				switch (acao) {
				case 1: {
					cadastrarProduto();
					break;
				}
				case 2: {
					alterarProduto();
					break;
				}
				case 3: {
					removerProduto();
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

	/**
	 * Executa o cadastramento de Produtos
	 */
	private void cadastrarProduto() {
		int index;
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ProdutoService produtoService = new ProdutoService();
		MarcaService marcaService = new MarcaService();
		index = marcaService.pedirIdMarca(" cadastrar");
		if (index != -1) {
			produto.setId_marca(index);
			produto.setNome(JOptionPane.showInputDialog("Digite o nome do Produto"));
			produto.setValor(produtoService.validarValor(" ", ""));
			produtoDAO.cadastrar(produto);
		}

	}

	/**
	 * Executa a alteração de Produtos
	 */
	private void alterarProduto() {
		int index;
		Produto produto = new Produto();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ProdutoService produtoService = new ProdutoService();
		MarcaService marcaService = new MarcaService();
		index = produtoService.pedirIdProduto(" alterar");
		if (index != -1) {
			produto = produtoDAO.buscarIndex(index);
			produto.setId_marca(marcaService.pedirIdMarca("alterar( atual: " + produto.getId_marca() + " ):"));
			produto.setNome(JOptionPane.showInputDialog("Digite o novo nome do usuário( " + produto.getNome() + "):"));
			produto.setValor(produtoService.validarValor(" novo ", "( " + produto.getValor() + "):"));
			produtoDAO.alterar(produto, index);
		}
	}

	/**
	 * Executa a remoção de Usuários
	 */
	private void removerProduto() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ProdutoService produtoService = new ProdutoService();
		int index = produtoService.pedirIdProduto(" remover");
		if (index != -1) {
			if (produtoDAO.remover(index)) {
				JOptionPane.showMessageDialog(null, "Produto removido!!!");
			} else {
				JOptionPane.showMessageDialog(null,
						"Esse Produto não pode ser removida pois existe Vendas vinculados a ele!!!");
			}
		}
	}

}
