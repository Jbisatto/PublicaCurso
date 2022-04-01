package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acoes.AlunoAcoes;
import modelo.Aluno;
import service.AlunoService;
import validador.Validador;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtAluno;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTable table;
	private JButton btnRemover, btnAlterar;
	private int index;
	double n1, n2;
	JButton btnLimpar;
	Aluno aluno = new Aluno();
	JComboBox<String> cbxTurno;
	JComboBox<String> cbxGenero;
	AlunoService alunoService = new AlunoService();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formulario frame = new Formulario();
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
	public Formulario() throws SQLException {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Cadastro de Alunos");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(10, 11, 179, 26);
		contentPane.add(lblTitulo);

		JLabel lblNome = new JLabel("Aluno");
		lblNome.setBounds(20, 51, 46, 14);
		contentPane.add(lblNome);

		JLabel lblMarca = new JLabel("Nota 1");
		lblMarca.setBounds(20, 76, 46, 14);
		contentPane.add(lblMarca);

		JLabel lblSegmento = new JLabel("Nota 2");
		lblSegmento.setBounds(20, 101, 66, 14);
		contentPane.add(lblSegmento);

		JLabel lblQuantidade = new JLabel("Turno");
		lblQuantidade.setBounds(20, 126, 66, 14);
		contentPane.add(lblQuantidade);

		txtAluno = new JTextField();
		txtAluno.setBounds(94, 48, 86, 20);
		contentPane.add(txtAluno);
		txtAluno.setColumns(10);

		txtNota1 = new JTextField();
		txtNota1.setColumns(10);
		txtNota1.setBounds(94, 73, 86, 20);
		contentPane.add(txtNota1);

		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setBounds(94, 98, 86, 20);
		contentPane.add(txtNota2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 193, 532, 178);
		contentPane.add(scrollPane);

		table = new JTable(alunoService.listarAlunos());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnLimpar.setEnabled(true);
				btnRemover.setEnabled(true);
				btnAlterar.setEnabled(true);
				index = Integer.parseInt(String.valueOf(table.getModel().getValueAt(table.getSelectedRow(), 0)));
				aluno = AlunoAcoes.filtrar(index);
				txtAluno.setText(aluno.getNomeAluno());
				txtNota1.setText(Double.toString(aluno.getN1()));
				txtNota2.setText(Double.toString(aluno.getN2()));
				cbxTurno.setSelectedIndex((aluno.getGenero() == 'M') ? 1 : ((aluno.getGenero() == 'V') ? 2 : 3));
				cbxGenero.setSelectedIndex((aluno.getGenero() == 'M') ? 1 : 2);
			}
		});
		scrollPane.setViewportView(table);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (cbxTurno.getSelectedIndex() != 0 && cbxGenero.getSelectedIndex() != 0) {
					n1 = Validador.validaDouble(txtNota1.getText());
					n2 = Validador.validaDouble(txtNota2.getText());
					if (n1 >= 0 && n2 >= 0) {
						Aluno aluno = new Aluno();
						aluno.setNomeAluno(txtAluno.getText());
						aluno.setN1(n1);
						aluno.setN2(n2);
						aluno.setGenero(cbxGenero.getSelectedItem().toString().charAt(0));
						aluno.setTurno(cbxTurno.getSelectedItem().toString().charAt(0));
						AlunoAcoes.cadastrar(aluno);
						limpaTexto();
					}
					try {
						table.setModel(alunoService.listarAlunos());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Turno ou Gênero Incorretos");
				}

			}
		});
		btnCadastrar.setBounds(197, 47, 102, 23);
		contentPane.add(btnCadastrar);

		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlunoAcoes.remover(index);

				JOptionPane.showMessageDialog(null, "Aluno removido");
				try {
					table.setModel(alunoService.listarAlunos());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				btnAlterar.setEnabled(false);
				btnRemover.setEnabled(false);
				limpaTexto();
			}
		});
		btnRemover.setEnabled(false);
		btnRemover.setBounds(197, 72, 102, 23);
		contentPane.add(btnRemover);

		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbxTurno.getSelectedIndex() != 0 && cbxGenero.getSelectedIndex() != 0) {
					Aluno aluno = new Aluno();
					aluno.setCodigo(index);
					aluno.setNomeAluno(txtAluno.getText());
					aluno.setN1(Validador.validaDouble(txtNota1.getText()));
					aluno.setN2(Validador.validaDouble(txtNota2.getText()));
					aluno.setGenero(cbxGenero.getSelectedItem().toString().charAt(0));
					aluno.setTurno(cbxTurno.getSelectedItem().toString().charAt(0));
					AlunoAcoes.alterar(aluno);
					limpaTexto();
					try {
						table.setModel(alunoService.listarAlunos());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(null, "Turno ou Gênero Incorretos");
				}
			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(197, 97, 102, 23);
		contentPane.add(btnAlterar);

		JLabel lblGenero = new JLabel("Genero");
		lblGenero.setBounds(20, 151, 66, 14);
		contentPane.add(lblGenero);

		cbxGenero = new JComboBox<String>();
		cbxGenero.setModel(new DefaultComboBoxModel(new String[] { "G\u00EAnero", "Masculino", "Feminino" }));
		cbxGenero.setBounds(94, 147, 86, 22);
		contentPane.add(cbxGenero);

		cbxTurno = new JComboBox<String>();
		cbxTurno.setModel(new DefaultComboBoxModel(new String[] { "Turno", "Matutino", "Vespertino", "Noturno" }));
		cbxTurno.setBounds(94, 122, 86, 22);
		contentPane.add(cbxTurno);

		JButton btnEstatisticas = new JButton("Estat\u00EDsticas");
		btnEstatisticas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				JOptionPane.showMessageDialog(null, alunoService.estatisticas());
			}
		});
		btnEstatisticas.setBounds(427, 47, 115, 23);
		contentPane.add(btnEstatisticas);

		btnLimpar = new JButton("Limpar");
		btnLimpar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				btnAlterar.setEnabled(false);
				btnRemover.setEnabled(false);
				btnLimpar.setEnabled(false);
				limpaTexto();
			}
		});
		btnLimpar.setEnabled(false);
		btnLimpar.setBounds(197, 122, 102, 23);
		contentPane.add(btnLimpar);
	}

	public void limpaTexto() {
		table.clearSelection();
		txtAluno.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		cbxTurno.setSelectedIndex(0);
		cbxGenero.setSelectedIndex(0);
	}
}
