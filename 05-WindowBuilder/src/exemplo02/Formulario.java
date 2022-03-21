package exemplo02;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
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
		
		JComboBox cbxLista = new JComboBox();
		cbxLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbxLista.getSelectedIndex()!=0) {
				JOptionPane.showMessageDialog(null,cbxLista.getSelectedItem());
				}
			}
		});
		cbxLista.addItem("Selecione uma cidade");
		cbxLista.addItem("Blumenau");
		cbxLista.addItem("Joinville");
		cbxLista.addItem("Indaial");
		cbxLista.setBounds(10, 11, 177, 22);
		contentPane.add(cbxLista);
	}
}
