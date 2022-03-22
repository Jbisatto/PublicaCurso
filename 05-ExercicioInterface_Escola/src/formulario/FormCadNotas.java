package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acoes.AlunoAcoes;
import acoes.NotaAcao;
import acoes.ProvaAcao;
import acoes.ValidacaoCampo;
import modelo.Aluno;
import modelo.Nota;
import modelo.Prova;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class FormCadNotas extends JFrame {

	private JPanel contentPane;
	ProvaAcao provaAcao = new ProvaAcao();
	AlunoAcoes alunoAcoes = new AlunoAcoes();
	NotaAcao notaAcao = new NotaAcao();
	private JTable table;
	private JTextField txtNota;

	/**
	 * Create the frame.
	 */
	public FormCadNotas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 468, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JComboBox<Prova> cbxProvas = new JComboBox();
		for (Prova prova : provaAcao.lista()) {
			cbxProvas.addItem(prova);
		}
		cbxProvas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (notaAcao.verificaTabela()) {
					table.setModel(notaAcao.listar(cbxProvas.getSelectedIndex()));
				}
			}
		});

		cbxProvas.setBounds(10, 10, 133, 21);
		contentPane.add(cbxProvas);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 77, 338, 176);
		contentPane.add(scrollPane);

		table = new JTable(notaAcao.listar(cbxProvas.getSelectedIndex()));
		scrollPane.setViewportView(table);

		JComboBox cbxAlunos = new JComboBox();
		for (Aluno aluno : alunoAcoes.lista()) {
			cbxAlunos.addItem(aluno);
		}
		cbxAlunos.setBounds(164, 10, 140, 21);
		contentPane.add(cbxAlunos);

		txtNota = new JTextField();
		txtNota.setBounds(383, 11, 62, 19);
		contentPane.add(txtNota);
		txtNota.setColumns(10);

		JLabel lblNewLabel = new JLabel("Nota");
		lblNewLabel.setBounds(345, 14, 31, 13);
		contentPane.add(lblNewLabel);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (ValidacaoCampo.verificaCampoDouble(txtNota.getText()) != -1) {
					Nota nota = new Nota();
					nota.setIdProva(cbxProvas.getSelectedIndex());
					nota.setIdAluno(cbxAlunos.getSelectedIndex());
					nota.setNota(ValidacaoCampo.verificaCampoDouble(txtNota.getText()));
					if (!notaAcao.verificaNotaCad(nota)) {
						notaAcao.cadastrar(nota);
						table.setModel(notaAcao.listar(cbxProvas.getSelectedIndex()));
					} else {
						JOptionPane.showMessageDialog(null, "Nota e Aluno ja cadastrado!");
					}
				}
			}
		});
		btnCadastrar.setBounds(345, 40, 100, 21);
		contentPane.add(btnCadastrar);
	}
}
