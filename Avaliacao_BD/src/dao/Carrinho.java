package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ProdutoDto;
import model.Produto;
import model.ProdutosCarrinho;

public class Carrinho {
	public static List<ProdutosCarrinho> carrinho = new ArrayList<>();
	
	public static void addCarrinho(Produto produto) {
		ProdutosCarrinho produtoCarrinho = new ProdutosCarrinho();
		boolean contem=false;
		for (int i = 0; i < carrinho.size(); i++) {
			if(carrinho.get(i).getId_produto()==produto.getCodigoProduto()) {
				carrinho.get(i).setQtd_Produto(carrinho.get(i).getQtd_Produto()+1);
				contem= true;
			}
		}
		if(!contem) {
			produtoCarrinho.setId_produto(produto.getCodigoProduto());
			produtoCarrinho.setQtd_Produto(1);
			carrinho.add(produtoCarrinho);
		}
	}

	public static String lista() throws SQLException {
		double valorTotal=0;
		String lista = "Carrinho: \n";
		Produto produto = new Produto();
		ProdutoDao produtoDao = new ProdutoDao();
		for (int i = 0; i < carrinho.size(); i++) {
			produto=produtoDao.buscaId(carrinho.get(i).getId_produto());
			lista+=produto.getNome()+"  --  Qtd: "+carrinho.get(i).getQtd_Produto()+
					"  --  Valor: "+(produto.getValor() * carrinho.get(i).getQtd_Produto())+"\n";
			valorTotal+=(produto.getValor() * carrinho.get(i).getQtd_Produto());
		
		}
		lista+="\n\nTotal: "+valorTotal;
		return lista;
	}

	public static void limparLista() {
		carrinho.clear();
		
	}

}
