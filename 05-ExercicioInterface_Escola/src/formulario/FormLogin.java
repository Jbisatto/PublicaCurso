package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import acoes.AlunoAcoes;
import acoes.LoginAcoes;
import modelo.Aluno;
import modelo.Login;
import javax.swing.JRadioButton;

public class FormLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JLabel lblLogin, lblSenha;
	private LoginAcoes loginacoes = new LoginAcoes();
	private AlunoAcoes alunoAcoes = new AlunoAcoes();
	private ButtonGroup grupo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		cadastrar();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(grupo.getSelection().getActionCommand().equals("Professor") &&
						loginacoes.verificarSenha(txtLogin.getText(), txtSenha.getText())) {
					FormProfessor formProfessor = new FormProfessor();
					formProfessor.setVisible(true);
					dispose();
				}else if(grupo.getSelection().getActionCommand().equals("Aluno") &&
						alunoAcoes.verificarSenha(txtLogin.getText(), txtSenha.getText())) {
					
					FormAluno formAluno = new FormAluno(alunoAcoes.buscaIdAluno(
							txtLogin.getText(),
							txtSenha.getText()));
					formAluno.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "Login invalido");
				}
			}
		});
		btnEntrar.setBounds(202, 89, 89, 23);
		contentPane.add(btnEntrar);

		lblLogin = new JLabel("Login");
		lblLogin.setBounds(61, 13, 45, 17);
		contentPane.add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.setBounds(120, 11, 86, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(61, 49, 45, 17);
		contentPane.add(lblSenha);

		txtSenha = new JTextField();
		txtSenha.setBounds(120, 46, 86, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

		JRadioButton rdtAluno = new JRadioButton("Aluno");
		rdtAluno.setActionCommand("Aluno");
		rdtAluno.setBounds(106, 89, 77, 23);
		contentPane.add(rdtAluno);

		JRadioButton rdbtnProfessor = new JRadioButton("Professor");
		rdbtnProfessor.setSelected(true);
		rdbtnProfessor.setActionCommand("Professor");
		rdbtnProfessor.setBounds(6, 89, 89, 23);
		contentPane.add(rdbtnProfessor);
		
		grupo = new ButtonGroup();

		grupo.add(rdtAluno);
		grupo.add(rdbtnProfessor);
	}

	public static void cadastrar() {
		LoginAcoes loginacoes = new LoginAcoes();
		AlunoAcoes alunoAcoes = new AlunoAcoes();
		Login login = new Login("professor", "123", 'P');
		loginacoes.cadastrar(login);

		Aluno login2 = new Aluno("aluno1", "111", 'A', "Jefferson", 'M');
		alunoAcoes.cadastrar(login2);

		Aluno login3 = new Aluno("aluno2", "111", 'A', "Maria", 'F');
		alunoAcoes.cadastrar(login3);

		Aluno login4 = new Aluno("aluno3", "111", 'A', "Mario", 'M');
		alunoAcoes.cadastrar(login4);

		Aluno login5 = new Aluno("aluno4", "111", 'A', "Ana", 'F');
		alunoAcoes.cadastrar(login5);

		Aluno login6 = new Aluno("aluno5", "111", 'A', "Joaquim", 'M');
		alunoAcoes.cadastrar(login6);
	}
}
