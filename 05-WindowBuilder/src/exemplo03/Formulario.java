package exemplo03;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton rdbtnJava = new JRadioButton("Java");
		rdbtnJava.setBounds(6, 29, 109, 23);
		rdbtnJava.setActionCommand("Java");
		contentPane.add(rdbtnJava);
		
		JRadioButton rdbtnCSharp = new JRadioButton("C#");
		rdbtnCSharp.setBounds(6, 51, 109, 23);
		rdbtnCSharp.setActionCommand("C#");
		contentPane.add(rdbtnCSharp);
		
		JRadioButton rdbtnPHP = new JRadioButton("PHP");
		rdbtnPHP.setBounds(6, 77, 109, 23);
		rdbtnPHP.setActionCommand("PHP");
		contentPane.add(rdbtnPHP);
	
		ButtonGroup grupo = new ButtonGroup();
		
		grupo.add(rdbtnPHP);
		grupo.add(rdbtnCSharp);
		grupo.add(rdbtnJava);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, grupo.getSelection().getActionCommand());
			}
		});
		btnEnviar.setBounds(335, 227, 89, 23);
		contentPane.add(btnEnviar);
	}
}
