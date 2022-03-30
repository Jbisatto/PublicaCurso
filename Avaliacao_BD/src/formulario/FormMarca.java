package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.MarcaDao;
import model.Marca;
import service.MarcaService;

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

public class FormMarca extends JFrame {

	private JPanel contentPane;
	private JTextField txtMarca;
	private JTable table;
	JButton btnRemover;
	JButton btnAlterar;
	int index=0;
	Marca marca = new Marca();
	MarcaDao marcaDao = new MarcaDao();
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public FormMarca() throws SQLException {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 355, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeProva = new JLabel("Informe a Marca");
		lblNomeProva.setBounds(10, 10, 96, 29);
		contentPane.add(lblNomeProva);

		txtMarca = new JTextField();
		txtMarca.setBounds(103, 15, 96, 19);
		contentPane.add(txtMarca);
		txtMarca.setColumns(10);

		JButton btnCadastrarMarca = new JButton("Cadastrar");
		btnCadastrarMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				marca.setMarca(txtMarca.getText());
				try {
					marcaDao.cadastrar(marca);
					table.setModel(MarcaService.listarMarca());
					txtMarca.setText("");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"Não cadastrado!!!");
				}
				
			}
		});
		btnCadastrarMarca.setBounds(219, 14, 112, 21);
		contentPane.add(btnCadastrarMarca);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 176, 125);
		contentPane.add(scrollPane);

		table = new JTable(MarcaService.listarMarca());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAlterar.setEnabled(true);
				btnRemover.setEnabled(true);
				index = Integer.parseInt(String.valueOf(table.getModel().getValueAt(table.getSelectedRow() ,0)));
				txtMarca.setText(String.valueOf(table.getModel().getValueAt(table.getSelectedRow() ,1)));
			}
		});
		scrollPane.setViewportView(table);

		btnRemover = new JButton("Remover");
		btnRemover.setEnabled(false);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					marcaDao.remover(index);
					System.out.println(index);
					table.setModel(MarcaService.listarMarca());
					btnRemover.setEnabled(false);
					btnAlterar.setEnabled(false);
					txtMarca.setText("");
					JOptionPane.showMessageDialog(null, "Marca removida");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRemover.setBounds(219, 78, 112, 21);
		contentPane.add(btnRemover);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				marca.setMarca(txtMarca.getText());
				try {
					marcaDao.alterar(marca,index);
					table.setModel(MarcaService.listarMarca());
					btnRemover.setEnabled(false);
					btnAlterar.setEnabled(false);
					txtMarca.setText("");
					JOptionPane.showMessageDialog(null, "Marca Alterada");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				

			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(219, 45, 112, 21);
		contentPane.add(btnAlterar);
	}
}
