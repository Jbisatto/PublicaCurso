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
import model.Tipo;

public class TipoDao implements ICrud<Tipo> {

	@Override
	public void cadastrar(Tipo obj) throws SQLException {
		Connection con = Conexao.getInstance().conectar();
		PreparedStatement pstmt = null;

		String sql = "Insert into tipos (nome) values (?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.getNomeTipo());
			pstmt.execute();

		} catch (Exception e) {
			System.out.println("Falha ao cadastrar um tipo");
		} finally {
			pstmt.close();
			con.close();
		}
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
			rs = pstmt.executeQuery();
			while (rs.next()) {
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
		List<Tipo> listaTipo = new ArrayList<>();
		Connection obj = Conexao.getInstance().conectar();
		Statement stmt = null;
		ResultSet rs = null;
		try {
			String sql = "Select * from tipos;";
			stmt = obj.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Tipo tipo = new Tipo();
				tipo.setCodigoTipo(rs.getInt(1));
				tipo.setNomeTipo(rs.getString(2));
				listaTipo.add(tipo);
			}
		} catch (Exception e) {
			System.out.println("Falha " + e.getMessage());
		} finally {
			rs.close();
			stmt.close();
			obj.close();
		}
		return listaTipo;
	}

	@Override
	public void alterar(Tipo obj, int index) throws SQLException {
		Connection con = Conexao.getInstance().conectar();
		PreparedStatement pstmt = null;
		try {
			String sql = "UPDATE tipos SET nome = ? WHERE codigo = ? ;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, obj.getNomeTipo());
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
			String sql = "DELETE FROM tipos  WHERE codigo = ? ;";
			pstmt = obj.prepareStatement(sql);
			pstmt.setInt(1, index);
			pstmt.execute();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Esse tipo não pode ser removida pois existe algum produto vinculado a ela!!!");
		} finally {
			pstmt.close();
			obj.close();
		}

	}



	public List<ProdutoDto> filtrarFiltros(String pesquisar) throws SQLException {
		List<ProdutoDto> listaProdutos = new ArrayList<>();
		Connection obj = Conexao.getInstance().conectar();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			String sql = "Select" + "	produtos.codigo," + "    produtos.nome," + "    produtos.valor,"
					+ "    marcas.nome," + "    tipos.nome " + "from produtos " + "inner join marcas "
					+ "on  produtos.marca = marcas.codigo " + "inner join tipos " + "on  produtos.tipo = tipos.codigo "
					+ "where tipos.nome like ? " + "order by produtos.codigo ;";
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
