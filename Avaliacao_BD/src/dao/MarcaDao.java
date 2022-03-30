package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import bd.Conexao;
import dto.ProdutoDto;
import model.Marca;
import model.Produto;

public class MarcaDao implements ICrud<Marca> {

	@Override
	public void cadastrar(Marca obj) throws SQLException {
		Connection con = Conexao.getInstance().conectar();
		PreparedStatement pstmt = null;

		String sql = "Insert into marcas (nome) values (?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.getMarca());
			pstmt.execute();

		} catch (Exception e) {
			System.out.println("Falha ao cadastrar uma marca");
		} finally {
			pstmt.close();
			con.close();
		}

	}

	@Override
	public List<Marca> lista() throws SQLException {
		List<Marca> listaMarca = new ArrayList<>();
		Connection obj = Conexao.getInstance().conectar();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "Select * from marcas;";
			stmt = obj.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Marca marca = new Marca();
				marca.setCodigoMarca(rs.getInt(1));
				marca.setMarca(rs.getString(2));
				listaMarca.add(marca);
			}
		} catch (Exception e) {
			System.out.println("Falha " + e.getMessage());
		} finally {
			rs.close();
			stmt.close();
			obj.close();
		}
		return listaMarca;
	}

	@Override
	public void alterar(Marca obj, int index) throws SQLException {
		Connection con = Conexao.getInstance().conectar();
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE marcas SET nome = ? WHERE codigo = ? ;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.getMarca());
			pstmt.setInt(2, index);
			pstmt.execute();
		} catch (Exception e) {
			System.out.println("Falha " + e.getMessage());
		} finally {
			pstmt.close();
			con.close();
		}
	}

	@Override
	public void remover(int index) throws SQLException {
		Connection obj = Conexao.getInstance().conectar();
		PreparedStatement pstmt = null;
		try {
			String sql = "DELETE FROM marcas  WHERE codigo = ? ;";
			pstmt = obj.prepareStatement(sql);
			pstmt.setInt(1, index);
			pstmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Essa marca não pode ser removida pois existe algum produto vinculado a ela!!!");
		} finally {
			pstmt.close();
			obj.close();
		}

	}

	@Override
	public Marca buscaId(int index) throws SQLException {
		Marca marca = new Marca();
		Connection obj = Conexao.getInstance().conectar();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			String sql = "Select * from marcas where codigo = ? ;";
			pstmt = obj.prepareStatement(sql);
			pstmt.setInt(1, index);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				marca.setCodigoMarca(rs.getInt(1));
				marca.setMarca(rs.getString(2));
			}
		} catch (Exception e) {
			System.out.println("Falha " + e.getMessage());
		} finally {
			rs.close();
			pstmt.close();
			obj.close();
		}
		return marca;
	}

	public List<ProdutoDto> filtrarMarcas(String pesquisar) throws SQLException {
		List<ProdutoDto> listaProdutos = new ArrayList<>();
		Connection obj = Conexao.getInstance().conectar();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "Select" + "	produtos.codigo," + "    produtos.nome," + "    produtos.valor,"
					+ "    marcas.nome," + "    tipos.nome " + "from produtos " + "inner join marcas "
					+ "on  produtos.marca = marcas.codigo " + "inner join tipos " + "on  produtos.tipo = tipos.codigo "
					+ "where marcas.nome like ? " + "order by produtos.codigo ;";
			pstmt = obj.prepareStatement(sql);
			pstmt.setString(1, "%" + pesquisar + "%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ProdutoDto produtoDto = new ProdutoDto();
				produtoDto.setCodigoProduto(rs.getInt(1));
				produtoDto.setNome(rs.getString(2));
				produtoDto.setValor(rs.getDouble(3));
				produtoDto.setMarca(rs.getString(4));
				produtoDto.setTipo(rs.getString(5));
				listaProdutos.add(produtoDto);
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

}
