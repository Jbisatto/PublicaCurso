package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Marca;

public class MarcaDAO implements ICrud<Marca> {

	static ArrayList<Marca> listaMarca = new ArrayList<>();

	@Override
	public void cadastrar(Marca obj) {
		listaMarca.add(obj);

	}

	@Override
	public void remover(int index) {
		ProdutoDAO produtoDAO = new ProdutoDAO();
//		Verifica se tem algum produto com a marca que esta tentando remover;
		if (produtoDAO.verificaMarca(index)) {
			JOptionPane.showMessageDialog(null, "Essa marca não pode ser removida pois existe Produtos vinculados a ela!!!");
		} else {
			listaMarca.remove(index);
		}
	}


	@Override
	public void alterar(Marca obj, int index) {
		// TODO Auto-generated method stub

	}

	public String listaMarcaTxt() {
		String lista = "Lista:\n";
		for (int i = 0; i < listaMarca.size(); i++) {
			lista += "Cod: " + i + listaMarca.get(i) + "\n";
		}
		return lista;
	}

	public Marca buscarIndex(int index) {
		if (index >= 0 && index <= (listaMarca.size() - 1)) {
			return listaMarca.get(index);
		}

		return null;
	}

	public String buscarNomeIndex(int index) {

		return listaMarca.get(index).getNome();
	}

}
