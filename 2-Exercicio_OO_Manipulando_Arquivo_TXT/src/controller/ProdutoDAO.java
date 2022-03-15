package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import modelo.Produto;

public class ProdutoDAO {

	public static ArrayList<Produto> listaProduto = new ArrayList<>();

	public void salvarProduto(Produto produto) {
		listaProduto.add(produto);

	}

	public void saltarTxtProduto() {
		try {
			FileWriter escrever = new FileWriter("arquivoProduto.txt");
			escrever.write(listaSalvar());
			escrever.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String listaSalvar() {
		String user = "";
		for (int i = 0; i < listaProduto.size(); i++) {
			user += listaProduto.get(i) + "\n";
		}
		return user;
	}

	public String buscarTodos() {
		String prod = "";
		for (int i = 0; i < listaProduto.size(); i++) {
			prod += "Cod: " + i + ", Nome Produto: " + listaProduto.get(i).getNomeProduto() + ", Valor: "
					+ listaProduto.get(i).getValor() + "\n";
		}
		return prod;
	}

	public Produto buscarId(int acaoAlterar) {
		return listaProduto.get(acaoAlterar);
	}

	public void alterarProduto(Produto produtoAlterar, int acaoAlterar) {
		listaProduto.set(acaoAlterar, produtoAlterar);
		
	}

}
