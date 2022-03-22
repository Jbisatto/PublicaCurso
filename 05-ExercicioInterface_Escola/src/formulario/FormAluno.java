package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acoes.AlunoAcoes;
import acoes.NotaAcao;
import acoes.ProvaAcao;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormAluno extends JFrame {

	private JPanel contentPane;
	AlunoAcoes alunoAcoes = new AlunoAcoes();
	JLabel lblNome;
	private JScrollPane scrollPane;
	private JTable table;
	NotaAcao notaAcao = new NotaAcao();
	private JButton btnLogout;
	/**
	 * Create the frame.
	 */
	public FormAluno(int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEditarDados = new JButton("Editar Cadastro");
		btnEditarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroAluno.formCadastrarAluno(index);
				lblNome.setText("Aluno logado: "+alunoAcoes.nomeAluno(index));
			}
		});
		btnEditarDados.setBounds(10, 47, 123, 23);
		contentPane.add(btnEditarDados);
		
		lblNome = new JLabel("Aluno logado: "+alunoAcoes.nomeAluno(index));
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNome.setBounds(10, 0, 414, 36);
		contentPane.add(lblNome);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 357, 158);
		contentPane.add(scrollPane);
		
		table = new JTable(notaAcao.listarTodasProva(index));
		scrollPane.setViewportView(table);
		
		btnLogout = new JButton("Sair");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				FormLogin frame = new FormLogin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnLogout.setBounds(335, 47, 89, 23);
		contentPane.add(btnLogout);
	}
}
