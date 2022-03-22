package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acoes.ProvaAcao;
import modelo.Prova;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class FormProva extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeProva;
	private JTable table;
	JButton btnRemover;
	int index=0;

	/**
	 * Create the frame.
	 */
	public FormProva() {

		ProvaAcao provaAcao = new ProvaAcao();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 355, 238);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeProva = new JLabel("Nome da Prova");
		lblNomeProva.setBounds(10, 10, 96, 29);
		contentPane.add(lblNomeProva);

		txtNomeProva = new JTextField();
		txtNomeProva.setBounds(103, 15, 96, 19);
		contentPane.add(txtNomeProva);
		txtNomeProva.setColumns(10);

		JButton btnCadastrarProva = new JButton("Cadastrar");
		btnCadastrarProva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prova prova = new Prova();

				prova.setNomeProva(txtNomeProva.getText());
				provaAcao.cadastrar(prova);
				table.setModel(provaAcao.listar());
				txtNomeProva.setText("");
			}
		});
		btnCadastrarProva.setBounds(219, 14, 112, 21);
		contentPane.add(btnCadastrarProva);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 176, 125);
		contentPane.add(scrollPane);

		table = new JTable(provaAcao.listar());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRemover.setEnabled(true);
				index = table.getSelectedRow();
			}
		});
		scrollPane.setViewportView(table);

		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				provaAcao.remover(index);
				JOptionPane.showMessageDialog(null, "Produto removido");
				table.setModel(provaAcao.listar());
				btnRemover.setEnabled(false);

			}
		});
		btnRemover.setBounds(219, 45, 112, 21);
		contentPane.add(btnRemover);
	}
}
