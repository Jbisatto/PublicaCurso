package service;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import dao.MarcaDao;

public class MarcaService {

	public static DefaultTableModel listarProdutoMarca(String text) throws SQLException {
		MarcaDao marcaDao = new MarcaDao();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Código");
		dtm.addColumn("Produto");
		dtm.addColumn("Valor");
		dtm.addColumn("Marca");
		dtm.addColumn("Tipo");
		for (int i = 0; i < marcaDao.filtrarMarcas(text).size(); i++) {
			dtm.addRow(new Object[] { marcaDao.filtrarMarcas(text).get(i).getCodigoProduto(), marcaDao.filtrarMarcas(text).get(i).getNome(),
					marcaDao.filtrarMarcas(text).get(i).getValor(), marcaDao.filtrarMarcas(text).get(i).getMarca(),
					marcaDao.filtrarMarcas(text).get(i).getTipo() });
		}
		return dtm;
	}
	
	public static DefaultTableModel listarMarca() throws SQLException {
		MarcaDao marcaDao = new MarcaDao();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Código");
		dtm.addColumn("Marca");
		for (int i = 0; i < marcaDao.lista().size(); i++) {
			dtm.addRow(new Object[] { marcaDao.lista().get(i).getCodigoMarca(),
					marcaDao.lista().get(i).getMarca(),
					 });
		}
		return dtm;
	}
}
