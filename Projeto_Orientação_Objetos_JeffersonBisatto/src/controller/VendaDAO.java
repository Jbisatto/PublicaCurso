package controller;

import java.util.ArrayList;

import model.Funcionario;
import model.Produto;
import model.Venda;
import service.ProdutoService;

public class VendaDAO implements ICrud<Venda> {

	static ArrayList<Venda> listaVenda = new ArrayList<>();

	@Override
	public void cadastrar(Venda obj) {
		listaVenda.add(obj);
	}

	@Override
	public boolean remover(int index) {
		listaVenda.remove(index);
		return true;

	}

	@Override
	public void alterar(Venda obj, int index) {
		listaVenda.set(index, obj);
	}

	/**
	 * Monta uma String de Lista contendo todos os dados da venda, consultando os
	 * nomes pelos indice do funcionário e produtos
	 */
	public String listaVendaTxt() {
		String lista = "Lista:\n";
		Produto produto = new Produto();
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		for (int i = 0; i < listaVenda.size(); i++) {
			produto = produtoDAO.buscarIndex(listaVenda.get(i).getId_produto());
			funcionario = funcionarioDAO.buscarIndex(listaVenda.get(i).getId_funcionario());
			lista += "Cod: " + i + ", Vendedor: " + funcionario.getNome() + ", Produto: " + produto.getNome()
					+ ", Valor: " + produto.getValor() + ", Qtd: " + listaVenda.get(i).getQtdProdutos() + "Total R$"
					+ (produto.getValor() * listaVenda.get(i).getQtdProdutos()) + "\n";
		}
		return lista;
	}

	/**
	 * Retorna um objeto pelo indice informado
	 */
	public Venda buscarIndex(int respostas) {

		return listaVenda.get(respostas);
	}

	/**
	 * Retorna uma String contendo a quantidade, total de vendas e o valor da
	 * comissão do Funcionario passado no index
	 */
	public String extratoVendas(int index, String cargo) {
		int qtdVendas = 0;
		double valor = 0, comissao = 0;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		ProdutoService produtoService = new ProdutoService();
		for (int i = 0; i < listaVenda.size(); i++) {
			if (listaVenda.get(i).getId_funcionario() == index) {
				qtdVendas += listaVenda.get(i).getQtdProdutos();
				valor += (produtoDAO.valorProduto(listaVenda.get(i).getId_produto())
						* listaVenda.get(i).getQtdProdutos());
			}
		}
		comissao = produtoService.calculaComissao(cargo, valor);
		return "  Qtd Vendas: " + qtdVendas + "  Total de Vendas: " + valor + "  Comissao: " + comissao;
	}

	/**
	 * Verifica se tem um Produto cadastrado em alguma Venda, retornando true se tiver.
	 */
	public boolean verificaProduto(int index) {
		for (int i = 0; i < listaVenda.size(); i++) {
			if (listaVenda.get(i).getId_produto() == index) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Verifica se tem um Funcionario cadastrado em alguma Venda, retornando true se tiver.
	 */
	public boolean verificaFuncioanrio(int index) {
		for (int i = 0; i < listaVenda.size(); i++) {
			if (listaVenda.get(i).getId_funcionario() == index) {
				return true;
			}
		}
		return false;
	}

}
