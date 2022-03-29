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

import service.MarcaService;
import service.ProdutoService;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLabel;

public class FormPrincipal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ButtonGroup grupo;
	private JTextField txtPesquisar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrincipal frame = new FormPrincipal();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 533, 205);
		contentPane.add(scrollPane);

		table = new JTable(ProdutoService.listarProdutos(""));
		scrollPane.setViewportView(table);

		JRadioButton rdbtnProdutos = new JRadioButton("Produtos");
		rdbtnProdutos.setSelected(true);
		rdbtnProdutos.setBounds(10, 54, 109, 23);
		contentPane.add(rdbtnProdutos);

		JRadioButton rdbtnMarca = new JRadioButton("Marca");
		rdbtnMarca.setBounds(10, 80, 109, 23);
		contentPane.add(rdbtnMarca);

		JRadioButton rdbtnTipo = new JRadioButton("Tipo");
		rdbtnTipo.setBounds(10, 106, 109, 23);
		contentPane.add(rdbtnTipo);

		grupo = new ButtonGroup();

		grupo.add(rdbtnProdutos);
		grupo.add(rdbtnMarca);
		grupo.add(rdbtnTipo);

		txtPesquisar = new JTextField();
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				try {
					if (rdbtnProdutos.isSelected()) {
						table.setModel(ProdutoService.listarProdutos(txtPesquisar.getText()));
					} else if (rdbtnMarca.isSelected()) {
						table.setModel(MarcaService.listarMarca(txtPesquisar.getText()));
					} else if (rdbtnTipo.isSelected()) {
						table.setModel(ProdutoService.listarProdutos(txtPesquisar.getText()));
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

	}
}
