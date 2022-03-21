package exercicio04_Crud;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProdutoAcao {

	public void cadastra(ProdutoModelo produto) {
		BdProdutos.listaProduto.add(produto);
	}

	public DefaultTableModel listar() {

		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Produto");
		dtm.addColumn("Marca");
		dtm.addColumn("Segmento");
		dtm.addColumn("Quantidade");
		for (int i = 0; i < BdProdutos.listaProduto.size(); i++) {
			dtm.addRow(new Object[] { BdProdutos.listaProduto.get(i).getNomeProduto(),
					BdProdutos.listaProduto.get(i).getMarca(), BdProdutos.listaProduto.get(i).getSegmento(),
					BdProdutos.listaProduto.get(i).getQuantidade() });
		}
		return dtm;
	}

	public void alterar(ProdutoModelo produto, int index) {
		BdProdutos.listaProduto.set(index, produto);
	}

	public void remover(int index) {
		BdProdutos.listaProduto.remove(index);
	}

	public int validaQuantidade(String txtQuantidade) {
		try {
			return Integer.parseInt(txtQuantidade);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Digite uma quantidade válida!!!");
		}
		return -1;
	}
	
	public int quantidadeCadastrado() {
		return BdProdutos.listaProduto.size();
	}
	
	public ProdutoModelo buscarId(int Index) {
		return BdProdutos.listaProduto.get(Index);
	}
}
