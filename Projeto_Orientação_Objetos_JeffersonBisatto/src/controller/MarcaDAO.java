package controller;

import java.util.ArrayList;


import model.Marca;

public class MarcaDAO implements ICrud<Marca> {

	static ArrayList<Marca> listaMarca = new ArrayList<>();

	/**
	 * Cadastra uma marca na lista
	 */
	@Override
	public void cadastrar(Marca obj) {
		listaMarca.add(obj);
	}

	/**
	 * Verifica se tem algum produto com a marca que esta tentando remover e remove
	 * ele da lista retornando true;
	 */
	@Override
	public boolean remover(int index) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		if (produtoDAO.verificaMarca(index)) {
			return false;
		} else {
			listaMarca.remove(index);
			return true;
		}
	}

	/**
	 * Altera uma marca
	 */
	@Override
	public void alterar(Marca obj, int index) {
		listaMarca.set(index, obj);
	}

	/**
	 * Retorna uma Lista de todas a marcas com dados completos da marca
	 */
	public String listaMarcaTxt() {
		String lista = "Lista:\n";
		for (int i = 0; i < listaMarca.size(); i++) {
			lista += "Cod: " + i + listaMarca.get(i) + "\n";
		}
		return lista;
	}

	/**
	 * Retorna um Objeto Marca que esteja cadastrado da na lista pelo Indice dele na
	 * lista
	 */
	public Marca buscarIndex(int index) {
		if (index >= 0 && index <= (listaMarca.size() - 1)) {
			return listaMarca.get(index);
		}
		return null;
	}

	/**
	 * Retorna apenas o nome da Marca atraves do indice dele na lista
	 */
	public String buscarNomeIndex(int index) {

		return listaMarca.get(index).getNome();
	}

}
