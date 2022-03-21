package exemplo01;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtCampo;
	private JLabel lblRetorno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {//carregar todos os componetes da tela
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
	 */
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEnviar = new JButton("Clique aqui");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  lblRetorno.setText(txtCampo.getText());
			}
		});
		btnEnviar.setBackground(Color.WHITE);
		btnEnviar.setBounds(243, 10, 108, 23);
		contentPane.add(btnEnviar);
		
		txtCampo = new JTextField();
		txtCampo.setText("teste");
		txtCampo.setBounds(73, 11, 148, 20);
		contentPane.add(txtCampo);
		txtCampo.setColumns(10);
		
		JLabel lblCampo = new JLabel("Digite algo:");
		lblCampo.setBounds(6, 14, 57, 14);
		contentPane.add(lblCampo);
		
		lblRetorno = new JLabel("");
		lblRetorno.setBounds(6, 202, 418, 48);
		contentPane.add(lblRetorno);
	}
}
