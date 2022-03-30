package formulario;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.MarcaDao;
import dao.ProdutoDao;
import dao.TipoDao;
import model.Marca;
import model.Produto;
import model.Tipo;
import service.MarcaService;
import service.ProdutoService;
import validador.Validador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class FormProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField txtProduto;
	private JTable table;
	private JComboBox<Tipo> cbxCategoria;
	private JComboBox<Marca> cbxMarca;
	private JButton btnRemover;
	private JButton btnAlterar;
	int index = 0;
	Produto produto = new Produto();
	ProdutoDao produtoDao = new ProdutoDao();
	Marca marca = new Marca();
	MarcaDao marcaDao = new MarcaDao();
	Tipo tipo = new Tipo();
	TipoDao tipoDao = new TipoDao();
	Validador validador = new Validador();
	private JTextField txtValor;

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public FormProdutos() throws SQLException {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 513, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeProva = new JLabel("Produto");
		lblNomeProva.setBounds(10, 15, 51, 29);
		contentPane.add(lblNomeProva);

		txtProduto = new JTextField();
		txtProduto.setBounds(71, 19, 143, 19);
		contentPane.add(txtProduto);
		txtProduto.setColumns(10);

		JButton btnCadastrarMarca = new JButton("Cadastrar");
		btnCadastrarMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marca = (Marca) cbxMarca.getSelectedItem();
				tipo = (Tipo) cbxCategoria.getSelectedItem();
				produto.setNome(txtProduto.getText());
				produto.setValor(validador.validaDouble(txtValor.getText()));
				produto.setMarca(marca.getCodigoMarca());
				produto.setTipo(tipo.getCodigoTipo());
				try {
					produtoDao.cadastrar(produto);
					table.setModel(ProdutoService.listarProdutos(""));
					txtProduto.setText("");
					txtValor.setText("");
					cbxCategoria.setSelectedIndex(0);
					cbxMarca.setSelectedIndex(0);
					JOptionPane.showMessageDialog(null, "Produto Cadastrado");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "Não cadastrado!!!");
				}

			}
		});
		btnCadastrarMarca.setBounds(375, 15, 112, 21);
		contentPane.add(btnCadastrarMarca);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 130, 477, 169);
		contentPane.add(scrollPane);

		table = new JTable(ProdutoService.listarProdutos(""));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = Integer.parseInt(String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 0)));
				try {
					produto = produtoDao.buscaId(index);
					for (int i = 0; i < cbxMarca.getItemCount(); i++) {
						if (((Marca) cbxMarca.getItemAt(i)).getCodigoMarca() == produto.getMarca()) {
							cbxMarca.setSelectedIndex(((Marca) cbxMarca.getItemAt(i)).getCodigoMarca() - 1);
						}
					}
					for (int i = 0; i < cbxCategoria.getItemCount(); i++) {
						if (((Tipo) cbxCategoria.getItemAt(i)).getCodigoTipo() == produto.getTipo()) {
							cbxCategoria.setSelectedIndex(((Tipo) cbxCategoria.getItemAt(i)).getCodigoTipo() - 1);
						}
					}
				} catch (SQLException e2) {
					e2.printStackTrace();
				}

				btnAlterar.setEnabled(true);
				btnRemover.setEnabled(true);
				txtProduto.setText(produto.getNome());
				txtValor.setText(Double.toString(produto.getValor()));
				cbxMarca.setSelectedItem(marca);

			}
		});
		scrollPane.setViewportView(table);

		btnRemover = new JButton("Remover");
		btnRemover.setEnabled(false);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					produtoDao.remover(index);
					table.setModel(ProdutoService.listarProdutos(""));
					btnRemover.setEnabled(false);
					btnAlterar.setEnabled(false);
					txtProduto.setText("");
					txtValor.setText("");
					JOptionPane.showMessageDialog(null, "Produto removida");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRemover.setBounds(375, 79, 112, 21);
		contentPane.add(btnRemover);

		btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				marca = (Marca) cbxMarca.getSelectedItem();
				tipo = (Tipo) cbxCategoria.getSelectedItem();
				produto.setNome(txtProduto.getText());
				produto.setValor(validador.validaDouble(txtValor.getText()));
				produto.setMarca(marca.getCodigoMarca());
				produto.setTipo(tipo.getCodigoTipo());
				try {
					produtoDao.alterar(produto, index);
					table.setModel(ProdutoService.listarProdutos(""));
					txtProduto.setText("");
					txtValor.setText("");
					cbxCategoria.setSelectedIndex(0);
					cbxMarca.setSelectedIndex(0);
					JOptionPane.showMessageDialog(null, "Produto Alterada");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(375, 46, 112, 21);
		contentPane.add(btnAlterar);

		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(10, 39, 51, 29);
		contentPane.add(lblValor);

		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(71, 43, 143, 19);
		contentPane.add(txtValor);

		JLabel lblNomeProva_1_1 = new JLabel("Marca");
		lblNomeProva_1_1.setBounds(10, 65, 45, 29);
		contentPane.add(lblNomeProva_1_1);

		JLabel lblNomeProva_1_2 = new JLabel("Categoria");
		lblNomeProva_1_2.setBounds(10, 90, 65, 29);
		contentPane.add(lblNomeProva_1_2);

		cbxMarca = new JComboBox<>();
		cbxMarca.setBounds(71, 68, 143, 22);
		for (Marca marca : marcaDao.lista()) {
			cbxMarca.addItem(marca);
		}
		contentPane.add(cbxMarca);

		cbxCategoria = new JComboBox<>();
		cbxCategoria.setBounds(71, 96, 143, 22);
		for (Tipo tipo : tipoDao.lista()) {
			cbxCategoria.addItem(tipo);
		}
		contentPane.add(cbxCategoria);
	}
}
