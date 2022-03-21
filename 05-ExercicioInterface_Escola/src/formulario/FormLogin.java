package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acoes.LoginAcoes;
import bd.Bd;
import modelo.Aluno;
import modelo.Login;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FormLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JLabel lblLogin, lblSenha;
	LoginAcoes loginacoes = new LoginAcoes();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

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
		cadastrar();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 317, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (loginacoes.verificarSenha(txtLogin.getText(), txtSenha.getText())) {
					char tipo = loginacoes.buscarTipo(txtLogin.getText(), txtSenha.getText());
					if (tipo == 'A') {
						FormAluno formAluno = new FormAluno();
						formAluno.setVisible(true);
						dispose();
					} else if (tipo == 'P') {
						FormProfessor formProfessor = new FormProfessor();
						formProfessor.setVisible(true);
						dispose();
					}

				}else {
					JOptionPane.showMessageDialog(null, "Login invalido");
				}
			}
		});
		btnEntrar.setBounds(117, 89, 89, 23);
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
	}

	public void cadastrar() {

		Login login = new Login("professor", "123", 'P');
		loginacoes.cadastrar(login);

		Login login2 = new Aluno("aluno1", "111", 'A', "Jefferson", 'M');
		loginacoes.cadastrar(login2);

		Login login3 = new Aluno("aluno2", "111", 'A', "Maria", 'F');
		loginacoes.cadastrar(login3);

		Login login4 = new Aluno("aluno3", "111", 'A', "Mario", 'M');
		loginacoes.cadastrar(login4);

		Login login5 = new Aluno("aluno4", "111", 'A', "Ana", 'F');
		loginacoes.cadastrar(login5);

		Login login6 = new Aluno("aluno5", "111", 'A', "Joaquim", 'M');
		loginacoes.cadastrar(login6);
	}
}
