package controller;

import java.util.ArrayList;

import model.Funcionario;
import model.Produto;
import model.Venda;

public class VendaDAO implements ICrud<Venda> {

	static ArrayList<Venda> listaVenda = new ArrayList<>();

	@Override
	public void cadastrar(Venda obj) {
		listaVenda.add(obj);
	}

	@Override
	public void remover(int index) {
		listaVenda.remove(index);

	}


	@Override
	public void alterar(Venda obj, int index) {
		listaVenda.set(index, obj);
	}

	public String listaVendaTxt() {
		String lista = "Lista:\n";
		Produto produto = new Produto();
		Funcionario funcionario = new Funcionario();
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		ProdutoDAO produtoDAO = new ProdutoDAO();
		for (int i = 0; i < listaVenda.size(); i++) {
			produto = produtoDAO.buscarIndex(listaVenda.get(i).getId_produto());
			funcionario= funcionarioDAO.buscarIndex(listaVenda.get(i).getId_funcionario());
			lista += "Cod: " + i + ", Vendedor: "+ funcionario.getNome()+
					", Produto: " + produto.getNome() +
					", Valor: "+produto.getValor()+
					", Qtd: "+listaVenda.get(i).getQtdProdutos()+
					"Total R$"+(produto.getValor()*listaVenda.get(i).getQtdProdutos())+"\n";
		}
		return lista;
	}

	public Venda buscarIndex(int respostas) {
		
		return listaVenda.get(respostas);
	}

}
