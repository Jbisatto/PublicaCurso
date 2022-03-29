package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.PreparableStatement;

import bd.Conexao;

public class AcoesSql {

	public static void selecionar() throws SQLException {
		Conexao c = new Conexao();
		Connection obj = c.conectar();
		Statement stmt = null;
		ResultSet rs = null;

		try {

			String sql = "Select * from marcas";

			stmt = obj.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				System.out.print(rs.getString(1) + ", ");
				System.out.println(rs.getString(2) );
//				System.out.println(rs.getDouble("valor"));

			}
		} catch (Exception e) {
			System.out.println("Falha " + e.getMessage());
		} finally {
			rs.close();
			stmt.close();
			obj.close();
		}

	}

	public static void cadastrarMarca(String marca) throws SQLException {
		Conexao c = new Conexao();
		Connection obj = c.conectar();
		PreparedStatement pstmt = null;
		
		String sql = "Insert into marcas (nome) values (?)";
		try {
			pstmt= obj.prepareStatement(sql);
			pstmt.setString(1, marca);
			pstmt.execute();			
			
		} catch (Exception e) {
			System.out.println("Falha ao cadastrar uma marca");
		}finally {
			pstmt.close();
			obj.close();
		}
	
	
	}

}
