package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

	private static Conexao conexao;

	public static synchronized Conexao getInstance() {
		if (conexao == null)
			conexao = new Conexao();

		return conexao;
	}

	private Conexao() {

	}

	public Connection conectar() {
		Connection obj = null;
		try {
			obj = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetoBdJefferson", "root", "admin");
		} catch (Exception e) {
			System.out.println("Falha ao conectar " + e.getMessage());
		}

		return obj;
	}

	/*
	 * Popula a tabela Marcas no banco de dados
	 */
	public void populadorMarcas() throws SQLException {
		Connection obj = conexao.conectar();
		PreparedStatement pstmt = null;
		String sqlMarca = "insert into marcas (nome) values(?),(?),(?),(?),(?);";

		try {
			pstmt = obj.prepareStatement(sqlMarca);
			pstmt.setString(1, "Apple");
			pstmt.setString(2, "Xiaomi");
			pstmt.setString(3, "Panasonic");
			pstmt.setString(4, "Samsung");
			pstmt.setString(5, "LG");
			pstmt.execute();

		} catch (Exception e) {
			System.out.println("Falha ao cadastrar uma marca");
		} finally {
			pstmt.close();
			obj.close();
		}

	}

	/*
	 * Popula a tabela Tipos no banco de dados
	 */
	public void populadorTipos() throws SQLException {
		Connection obj = conexao.conectar();
		PreparedStatement pstmt = null;
		String sqlMarca = "insert into tipos (nome) values(?),(?),(?),(?),(?);";

		try {
			pstmt = obj.prepareStatement(sqlMarca);
			pstmt.setString(1, "Celular");
			pstmt.setString(2, "Tv");
			pstmt.setString(3, "Eletrodomésticos");
			pstmt.setString(4, "Móveis");
			pstmt.setString(5, "Informática");
			pstmt.execute();

		} catch (Exception e) {
			System.out.println("Falha ao cadastrar um tipo");
		} finally {
			pstmt.close();
			obj.close();
		}

	}

	
	/*
	 * Popula a tabela Produtos no banco de dados
	 */
	public void populadorProdutos() throws SQLException {
		Connection obj = conexao.conectar();
		PreparedStatement pstmt = null;
		String sqlMarca = "insert into produtos (nome,valor,marca,tipo) values"
				+ "(?,?,?,?),"
				+ "(?,?,?,?),"
				+ "(?,?,?,?),"
				+ "(?,?,?,?),"
				+ "(?,?,?,?);";

		try {
			pstmt = obj.prepareStatement(sqlMarca);
			pstmt.setString(1, "Galaxy S22");
			pstmt.setDouble(2, 7000);
			pstmt.setInt(3, 4);
			pstmt.setInt(4, 1);
			
			pstmt.setString(5, "Iphone 13");
			pstmt.setDouble(6, 8000);
			pstmt.setInt(7, 1);
			pstmt.setInt(8, 1);
			
			pstmt.setString(9, "Note 9");
			pstmt.setDouble(10, 800);
			pstmt.setInt(11, 2);
			pstmt.setInt(12, 1);
			
			pstmt.setString(13, "TV-50_polegadas");
			pstmt.setDouble(14, 3500);
			pstmt.setInt(15, 4);
			pstmt.setInt(16, 2);
			
			pstmt.setString(17, "Notebook Samsung Galaxy Book S");
			pstmt.setDouble(18, 3800);
			pstmt.setInt(19, 4);
			pstmt.setInt(20, 5);

			pstmt.execute();

		} catch (Exception e) {
			System.out.println("Falha ao cadastrar uma marca");
		} finally {
			pstmt.close();
			obj.close();
		}

	}
	
	
	/*
	 * Verifica se tem algum dado no banco para nao repetir o populador
	 */
	public boolean verificaDados() throws SQLException {
		Connection obj = conexao.conectar();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "Select * from marcas";
			stmt = obj.createStatement();
			rs = stmt.executeQuery(sql);
			return rs.next()?false:true;
		} catch (Exception e) {
			System.out.println("Falha " + e.getMessage());
		} finally {
			rs.close();
			stmt.close();
			obj.close();
		}		
		return false;
	}
}
