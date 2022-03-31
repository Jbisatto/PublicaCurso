package service;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import dao.ProdutoDao;
import validador.Formatador;

public class ProdutoService {

	public static DefaultTableModel listarProdutos(String pesquisar) throws SQLException {
		ProdutoDao produtoDao = new ProdutoDao();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Código");
		dtm.addColumn("Produto");
		dtm.addColumn("Valor");
		dtm.addColumn("Marca");
		dtm.addColumn("Categoria");
		for (int i = 0; i < produtoDao.lista(pesquisar).size(); i++) {
			dtm.addRow(new Object[] { 
					produtoDao.lista(pesquisar).get(i).getCodigoProduto(),
					produtoDao.lista(pesquisar).get(i).getNome(),
					Formatador.z.format(produtoDao.lista(pesquisar).get(i).getValor()),
					produtoDao.lista(pesquisar).get(i).getMarca(),
					produtoDao.lista(pesquisar).get(i).getTipo()});
		}
		return dtm;
	}

}
