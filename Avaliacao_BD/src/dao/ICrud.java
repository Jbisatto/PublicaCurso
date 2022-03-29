package dao;

import java.sql.SQLException;
import java.util.List;

import model.Produto;

public interface ICrud <t> {
	

	public void cadastrar(t obj);
	public t buscaId(int index) throws SQLException;
	public List<t> lista() throws SQLException;
	public void alterar(t obj,  int index);
	public void remover(int index);
	List<t> lista(String pesquisar) throws SQLException;

}
