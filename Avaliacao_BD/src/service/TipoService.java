package service;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import dao.MarcaDao;
import dao.TipoDao;

public class TipoService {
	
	public static DefaultTableModel listarProdutoTipo(String text) throws SQLException {
		TipoDao tipoDao = new TipoDao();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Código");
		dtm.addColumn("Produto");
		dtm.addColumn("Valor");
		dtm.addColumn("Marca");
		dtm.addColumn("Tipo");
		for (int i = 0; i < tipoDao.filtrarFiltros(text).size(); i++) {
			dtm.addRow(new Object[] { tipoDao.filtrarFiltros(text).get(i).getCodigoProduto(), tipoDao.filtrarFiltros(text).get(i).getNome(),
					tipoDao.filtrarFiltros(text).get(i).getValor(), tipoDao.filtrarFiltros(text).get(i).getMarca(),
					tipoDao.filtrarFiltros(text).get(i).getTipo() });
		}
		return dtm;
	}
	
	public static DefaultTableModel listarTipo() throws SQLException {
		TipoDao tipoDao = new TipoDao();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Código");
		dtm.addColumn("Categoria");
		for (int i = 0; i < tipoDao.lista().size(); i++) {
			dtm.addRow(new Object[] { tipoDao.lista().get(i).getCodigoTipo(),
					tipoDao.lista().get(i).getNomeTipo(),
					 });
		}
		return dtm;
	}
}
