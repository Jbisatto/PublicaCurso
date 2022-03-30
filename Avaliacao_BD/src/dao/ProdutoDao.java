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

public class ProdutoDao implements ICrud<Produto> {

	@Override
	public void cadastrar(Produto obj) throws SQLException {
		Connection con = Conexao.getInstance().conectar();
		PreparedStatement pstmt = null;

		String sql = "Insert into produtos (nome, valor, marca, tipo) values (?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.getNome());
			pstmt.setDouble(2, obj.getValor());
			pstmt.setInt(3, obj.getMarca());
			pstmt.setInt(4, obj.getTipo());
			pstmt.execute();

		} catch (Exception e) {
			System.out.println("Falha ao cadastrar um produto");
		} finally {
			pstmt.close();
			con.close();
		}
	}


	public List<ProdutoDto> lista(String pesquisar) throws SQLException {
		List<ProdutoDto> listaProdutos = new ArrayList<>();
		Connection obj = Conexao.getInstance().conectar();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "Select" + "	produtos.codigo," + "    produtos.nome," + "    produtos.valor,"
					+ "    marcas.nome," + "    tipos.nome " + "from produtos " + "inner join marcas "
					+ "on  produtos.marca = marcas.codigo " + "inner join tipos " + "on  produtos.tipo = tipos.codigo "
					+ "where produtos.nome like ? " + "order by produtos.codigo ;";
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

	@Override
	public void alterar(Produto obj, int index) throws SQLException {
		Connection con = Conexao.getInstance().conectar();
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE produtos SET nome = ? , valor = ? , marca = ? , tipo = ?  WHERE codigo = ? ;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.getNome());
			pstmt.setDouble(2, obj.getValor());
			pstmt.setInt(3, obj.getMarca());
			pstmt.setInt(4, obj.getTipo());
			pstmt.setInt(5, index);
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
			String sql = "DELETE FROM produtos  WHERE codigo = ? ;";
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
	public Produto buscaId(int index) throws SQLException {
		Produto produto = new Produto();
		Connection obj = Conexao.getInstance().conectar();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "Select * from produtos where codigo = ? ;";
			pstmt = obj.prepareStatement(sql);
			pstmt.setInt(1, index);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				produto.setCodigoProduto(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setValor(rs.getDouble(3));
				produto.setMarca(rs.getInt(4));
				produto.setTipo(rs.getInt(5));
			}
		} catch (Exception e) {
			System.out.println("Falha " + e.getMessage());
		} finally {
			rs.close();
			pstmt.close();
			obj.close();
		}
		return produto;
	}

	@Override
	public List<Produto> lista() throws SQLException {
		List<Produto> listaProduto = new ArrayList<>();
		Connection obj = Conexao.getInstance().conectar();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "Select * from produtos;";
			stmt = obj.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Produto produto = new Produto();
				produto.setCodigoProduto(rs.getInt(1));
				produto.setNome(rs.getString(2));
				produto.setValor(rs.getDouble(3));
				produto.setMarca(rs.getInt(4));
				produto.setTipo(rs.getInt(5));
				listaProduto.add(produto);
			}
		} catch (Exception e) {
			System.out.println("Falha " + e.getMessage());
		} finally {
			rs.close();
			stmt.close();
			obj.close();
		}
		return listaProduto;
	}

}
