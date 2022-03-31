package service;

import java.sql.SQLException;

import bd.Conexao;

public class PopuladorService {

	public static void populadorService() throws SQLException {
		Conexao con = Conexao.getInstance();
		if (con.verificaDados()) {
			con.populadorMarcas();
			con.populadorTipos();
			con.populadorProdutos();
		}
	}
}
