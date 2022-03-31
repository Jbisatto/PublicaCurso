package formulario;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class FormLogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLogin;
	private JTextField txtSenha;
	private JLabel lblLogin, lblSenha;


	/**
	 * Create the frame.
	 */
	public FormLogin() {
		String login="admin", senha="admin";
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 317, 169);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(txtLogin.getText().equals(login)&&txtSenha.getText().equals(senha)) {
						FormAdministardor frame = new FormAdministardor();
						frame.setTitle("Administrador");
						frame.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null,"Login Incorreto");
					}
				}
			}
		});
		btnEntrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if(txtLogin.getText().equals(login)&&txtSenha.getText().equals(senha)) {
					FormAdministardor frame = new FormAdministardor();
					frame.setTitle("Administrador");
					frame.setVisible(true);
					dispose();
				}else {
					JOptionPane.showMessageDialog(null,"Login Incorreto");
				}
				
			}
		});

		btnEntrar.setBounds(202, 89, 89, 23);
		contentPane.add(btnEntrar);

		lblLogin = new JLabel("Login");
		lblLogin.setBounds(61, 13, 45, 17);
		contentPane.add(lblLogin);

		txtLogin = new JTextField();
		txtLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					btnEntrar.requestFocus();
				}
			}
		});
		txtLogin.setBounds(120, 11, 86, 20);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(61, 49, 45, 17);
		contentPane.add(lblSenha);

		txtSenha = new JTextField();
		txtSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()== KeyEvent.VK_ENTER) {
					btnEntrar.requestFocus();
				}
			}
		});
		txtSenha.setBounds(120, 46, 86, 20);
		contentPane.add(txtSenha);
		txtSenha.setColumns(10);

	}

}
