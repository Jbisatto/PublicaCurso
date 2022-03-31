package formulario;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.TipoDao;
import model.Tipo;
import service.MarcaService;
import service.TipoService;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FormTipo extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTipo;
	private JTable table;
	JButton btnRemover;
	JButton btnAlterar;
	int index=0;
	Tipo tipo = new Tipo();
	TipoDao tipoDao = new TipoDao();
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public FormTipo() throws SQLException {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeProva = new JLabel("Categoria");
		lblNomeProva.setBounds(32, 11, 58, 29);
		contentPane.add(lblNomeProva);

		txtTipo = new JTextField();
		txtTipo.setBounds(103, 15, 96, 19);
		contentPane.add(txtTipo);
		txtTipo.setColumns(10);

		JButton btnCadastrarMarca = new JButton("Cadastrar");
		btnCadastrarMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo.setNomeTipo(txtTipo.getText());
				try {
					tipoDao.cadastrar(tipo);
					table.setModel(TipoService.listarTipo());
					txtTipo.setText("");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"Não cadastrado!!!");
				}
				
			}
		});
		btnCadastrarMarca.setBounds(252, 14, 112, 21);
		contentPane.add(btnCadastrarMarca);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 232, 126);
		contentPane.add(scrollPane);

		table = new JTable(TipoService.listarTipo());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAlterar.setEnabled(true);
				btnRemover.setEnabled(true);
				index = Integer.parseInt(String.valueOf(table.getModel().getValueAt(table.getSelectedRow() ,0)));
				txtTipo.setText(String.valueOf(table.getModel().getValueAt(table.getSelectedRow() ,1)));
			}
		});
		scrollPane.setViewportView(table);

		btnRemover = new JButton("Remover");
		btnRemover.setEnabled(false);
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					tipoDao.remover(index);
					table.setModel(MarcaService.listarMarca());
					btnRemover.setEnabled(false);
					btnAlterar.setEnabled(false);
					txtTipo.setText("");
					JOptionPane.showMessageDialog(null, "Categoria removida");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnRemover.setBounds(252, 78, 112, 21);
		contentPane.add(btnRemover);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tipo.setNomeTipo(txtTipo.getText());
				try {
					tipoDao.alterar(tipo,index);
					table.setModel(TipoService.listarTipo());
					btnRemover.setEnabled(false);
					btnAlterar.setEnabled(false);
					txtTipo.setText("");
					JOptionPane.showMessageDialog(null, "Categoria Alterada");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				

			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(252, 45, 112, 21);
		contentPane.add(btnAlterar);
	}
}
