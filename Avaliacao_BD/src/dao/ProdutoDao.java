package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bd.Conexao;
import model.Produto;

public class ProdutoDao implements ICrud<Produto> {

	@Override
	public void cadastrar(Produto obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Produto> lista(String pesquisar) throws SQLException {
		List<Produto> listaProdutos = new ArrayList<>();
		Connection obj = Conexao.getInstance().conectar();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "Select * from produtos where nome Like ? ;";
			pstmt = obj.prepareStatement(sql);
			pstmt.setString(1, "%" + pesquisar + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setCodigoProduto(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setValor(rs.getDouble(3));
				produto.setMarca(rs.getInt(4));
				produto.setTipo(rs.getInt(5));
				listaProdutos.add(produto);
			}
		} catch (Exception e) {
			System.out.println("Falha " + e.getMessage());
		} finally {
			rs.close();
			pstmt.close();
			obj.close();
		}
		return listaProdutos;
	}

	@Override
	public void alterar(Produto obj, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public Produto buscaId(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Produto> lista() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
