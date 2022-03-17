package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Funcionario;
import model.Produto;

public class ProdutoDAO implements ICrud<Produto> {

	static ArrayList<Produto> listaProduto = new ArrayList<>();

	@Override
	public void cadastrar(Produto obj) {
		listaProduto.add(obj);

	}

	@Override
	public void remover(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void alterar(Produto obj, int index) {
		// TODO Auto-generated method stub

	}

	public String listaProdutoTxt() {
		String lista = "Lista:\n", nomeMarca = "";
		MarcaDAO marcaDao = new MarcaDAO();
		for (int i = 0; i < listaProduto.size(); i++) {
			nomeMarca = marcaDao.buscarNomeIndex(listaProduto.get(i).getId_marca());
			lista += "Cod: " + i + ",  Marca: " + nomeMarca + listaProduto.get(i) + "\n";
		}
		return lista;
	}

//	busca o produto e veerifica se ele esta cadastrado
	public Produto buscarIndex(int index) {
		if (index >= 0 && index <= (listaProduto.size() - 1)) {
			return listaProduto.get(index);
		}

		return null;
	}

	public boolean verificaMarca(int index) {
		for (int i = 0; i < listaProduto.size(); i++) {
			if (listaProduto.get(i).getId_marca() == index) {
				return true;
			}
		}
		return false;
	}

	public String buscarNomeIndex(int i) {

		return listaProduto.get(i).getNome();
	}

}
