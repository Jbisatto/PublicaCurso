package service;

import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import dao.MarcaDao;
import dao.ProdutoDao;
import dao.TipoDao;

public class MarcaService {

	public static DefaultTableModel listarMarca(String text) throws SQLException {
		MarcaDao marcaDao = new MarcaDao();
		String marca, tipo;
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
}
