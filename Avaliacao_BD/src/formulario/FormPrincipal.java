package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.Carrinho;
import dao.ProdutoDao;
import model.Marca;
import model.Tipo;
import service.MarcaService;
import service.PopuladorService;
import service.ProdutoService;
import service.TipoService;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ButtonGroup grupo;
	private JTextField txtPesquisar;
	private int index;
	ProdutoDao produtoDao = new ProdutoDao();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrincipal frame = new FormPrincipal();
					frame.setTitle("Vendas de Produtos");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws SQLException
	 */
	public FormPrincipal() throws SQLException {
		PopuladorService.populadorService();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 533, 205);
		contentPane.add(scrollPane);

		table = new JTable(ProdutoService.listarProdutos(""));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				index = Integer.parseInt(String.valueOf(table.getModel().getValueAt(table.getSelectedRow() ,0)));
				try {
					Carrinho.addCarrinho(produtoDao.buscaId(index));
					JOptionPane.showMessageDialog(null,"Produto adicionado no carrinho");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);

		JRadioButton rdbtnProdutos = new JRadioButton("Produtos");
		rdbtnProdutos.setSelected(true);
		rdbtnProdutos.setBounds(10, 54, 109, 23);
		contentPane.add(rdbtnProdutos);

		JRadioButton rdbtnMarca = new JRadioButton("Marcas");
		rdbtnMarca.setBounds(10, 80, 109, 23);
		contentPane.add(rdbtnMarca);

		JRadioButton rdbtnTipo = new JRadioButton("Categorias");
		rdbtnTipo.setBounds(10, 106, 109, 23);
		contentPane.add(rdbtnTipo);

		grupo = new ButtonGroup();

		grupo.add(rdbtnProdutos);
		grupo.add(rdbtnMarca);
		grupo.add(rdbtnTipo);

		txtPesquisar = new JTextField();
		txtPesquisar.addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent e) {
				try {
					if (rdbtnProdutos.isSelected()) {
						table.setModel(ProdutoService.listarProdutos(txtPesquisar.getText()));
					} else if (rdbtnMarca.isSelected()) {
						table.setModel(MarcaService.listarProdutoMarca(txtPesquisar.getText()));
					} else if (rdbtnTipo.isSelected()) {
						table.setModel(TipoService.listarProdutoTipo(txtPesquisar.getText()));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		});
		txtPesquisar.setBounds(10, 27, 86, 20);
		contentPane.add(txtPesquisar);
		txtPesquisar.setColumns(10);

		JLabel lblNewLabel = new JLabel("Filtrar");
		lblNewLabel.setBounds(10, 11, 46, 14);
		contentPane.add(lblNewLabel);

		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				FormLogin formLogin = new FormLogin();
				formLogin.setTitle("Login");
				formLogin.setVisible(true);
				dispose();
			}
		});
		btnLogin.setBounds(398, 26, 145, 21);
		contentPane.add(btnLogin);

		JButton btnCarrinho = new JButton("Carrinho");
		btnCarrinho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCarrinho.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				String carrinho;
				try {
					carrinho = Carrinho.lista();
					JOptionPane.showMessageDialog(null, carrinho);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCarrinho.setBounds(398, 92, 145, 23);
		contentPane.add(btnCarrinho);
		
		JButton btnNewButton = new JButton("Limpar Carrinho");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Carrinho.limparLista();
			}
		});
		btnNewButton.setBounds(398, 119, 145, 23);
		contentPane.add(btnNewButton);

	}
}
