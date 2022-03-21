package exercicio01_Tabuada;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumero;
	private JTextPane txtResultado;

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
	 */
	public Formulario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 315, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTextoTabuada = new JLabel("Tabuada");
		lblTextoTabuada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTextoTabuada.setBounds(10, 11, 99, 22);
		contentPane.add(lblTextoTabuada);
		
		JLabel lblDigite = new JLabel("Digite um numero:");
		lblDigite.setBounds(10, 44, 106, 14);
		contentPane.add(lblDigite);
		
		txtNumero = new JTextField();
		txtNumero.setBounds(121, 41, 43, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtResultado.setText(CalculaTabuada.calculaTabuada(txtNumero.getText()));
			}
		});
		btnCalcular.setBounds(188, 40, 89, 23);
		contentPane.add(btnCalcular);
		
		txtResultado = new JTextPane();
		txtResultado.setBounds(10, 75, 279, 174);
		contentPane.add(txtResultado);
	}
}
