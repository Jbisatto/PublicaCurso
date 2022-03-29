package service;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.MarcaDao;
import dao.ProdutoDao;
import dao.TipoDao;

public class ProdutoService {

	public static DefaultTableModel listarProdutos(String pesquisar) throws SQLException {
		ProdutoDao produtoDao = new ProdutoDao();
		MarcaDao marcaDao = new MarcaDao();
		TipoDao tipoDao = new TipoDao();
		String marca, tipo;
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Código");
		dtm.addColumn("Produto");
		dtm.addColumn("Valor");
		dtm.addColumn("Marca");
		dtm.addColumn("Tipo");
		for (int i = 0; i < produtoDao.lista(pesquisar).size(); i++) {
			marca = marcaDao.buscaId(produtoDao.lista(pesquisar).get(i).getMarca()).getMarca();
			tipo = tipoDao.buscaId(produtoDao.lista(pesquisar).get(i).getTipo()).getNomeTipo();
			dtm.addRow(new Object[] { produtoDao.lista(pesquisar).get(i).getCodigoProduto(), produtoDao.lista(pesquisar).get(i).getNome(),
					produtoDao.lista(pesquisar).get(i).getValor(), marca, tipo });
		}
		return dtm;
	}

}
