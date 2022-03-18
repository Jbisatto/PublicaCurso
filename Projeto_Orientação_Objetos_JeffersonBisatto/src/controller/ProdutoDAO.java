package controller;

import java.util.ArrayList;


import model.Produto;

public class ProdutoDAO implements ICrud<Produto> {

	static ArrayList<Produto> listaProduto = new ArrayList<>();

	@Override
	public void cadastrar(Produto obj) {
		listaProduto.add(obj);

	}

	/**
	 * Verifica se o Produto Cadastrado esta vinculado a alguma Venda, caso não esteja ele remove retornando true.
	 */
	@Override
	public boolean remover(int index) {
		VendaDAO vendaDAO = new VendaDAO();
		if(vendaDAO.verificaProduto(index)) {
			return false;
		}else {
			listaProduto.remove(index);
			return true;
		}

	}

	@Override
	public void alterar(Produto obj, int index) {
		listaProduto.set(index, obj);

	}

	/**
	 * Monta uma lista de Produtos com suas marcas
	 */
	public String listaProdutoTxt() {
		String lista = "Lista:\n", nomeMarca = "";
		MarcaDAO marcaDao = new MarcaDAO();
		for (int i = 0; i < listaProduto.size(); i++) {
			nomeMarca = marcaDao.buscarNomeIndex(listaProduto.get(i).getId_marca());
			lista += "Cod: " + i + ",  Marca: " + nomeMarca + listaProduto.get(i) + "\n";
		}
		return lista;
	}

	/**
	 * Busca o produto e verificando se ele esta cadastrado, caso não achar retorna nulo
	 */
	public Produto buscarIndex(int index) {
		if (index >= 0 && index <= (listaProduto.size() - 1)) {
			return listaProduto.get(index);
		}

		return null;
	}

	/**
	 * Verifica se tem algum Produto da marca para tratar a remoção da marca
	 */
	public boolean verificaMarca(int index) {
		for (int i = 0; i < listaProduto.size(); i++) {
			if (listaProduto.get(i).getId_marca() == index) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retorna todos os dados do produto buscado pelo indice
	 */
	public String buscarNomeIndex(int i) {

		return listaProduto.get(i).getNome();
	}

	/**
	 * Retorna o valor do Produto pelo indice dele na lista
	 */
	public double valorProduto(int id_produto) {
		return listaProduto.get(id_produto).getValor();
	}

}
