package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bd.Conexao;
import model.Produto;
import model.Tipo;

public class TipoDao implements ICrud<Tipo>{

	@Override
	public void cadastrar(Tipo obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Tipo buscaId(int index) throws SQLException {
		Tipo tipo = new Tipo();
		Connection obj = Conexao.getInstance().conectar();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {			
			String sql = "Select * from tipos where codigo = ? ;";
			pstmt = obj.prepareStatement(sql);
			pstmt.setInt(1, index);
			rs = pstmt.executeQuery();;
			while(rs.next()) {
					tipo.setCodigoTipo(rs.getInt(1));
					tipo.setNomeTipo(rs.getString(2));
		}
		} catch (Exception e) {
			System.out.println("Falha " + e.getMessage());
		} finally {
			rs.close();
			pstmt.close();
			obj.close();
		}
		return tipo;
	}

	@Override
	public List<Tipo> lista() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Tipo obj, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tipo> lista(String pesquisar) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	

}
