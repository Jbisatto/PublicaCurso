package dao;

import java.sql.SQLException;
import java.util.List;


public interface ICrud <t> {
	

	public void cadastrar(t obj) throws SQLException;
	public t buscaId(int index) throws SQLException;
	public List<t> lista() throws SQLException;
	public void alterar(t obj,  int index) throws SQLException;
	public void remover(int index) throws SQLException;

}
