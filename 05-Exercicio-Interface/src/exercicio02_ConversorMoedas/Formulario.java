package exercicio02_ConversorMoedas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;
	JLabel lblResultado;

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

		JLabel lblTitulo = new JLabel("Conversor Moedas");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(10, 11, 129, 14);
		contentPane.add(lblTitulo);

		JLabel lblValor = new JLabel("Valor R$");
		lblValor.setBounds(10, 36, 53, 20);
		contentPane.add(lblValor);

		txtValor = new JTextField();
		txtValor.setBounds(73, 36, 53, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);

		JComboBox cbxTipoMoeda = new JComboBox();
		cbxTipoMoeda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(cbxTipoMoeda.getSelectedIndex());
				if (cbxTipoMoeda.getSelectedIndex() != 0) {
					lblResultado.setText(
							ConversorMoedas.converteMoeda(txtValor.getText(), cbxTipoMoeda.getSelectedIndex()));
				}
			}
		});
		cbxTipoMoeda.addItem("Selecione a moeda");
		cbxTipoMoeda.addItem("Dólar");
		cbxTipoMoeda.addItem("Euro");
		cbxTipoMoeda.addItem("Libra");
		cbxTipoMoeda.addItem("Iene japonês");
		cbxTipoMoeda.addItem("Peso argentino");
		cbxTipoMoeda.setBounds(10, 67, 116, 22);
		contentPane.add(cbxTipoMoeda);

		lblResultado = new JLabel("");
		lblResultado.setBounds(17, 100, 109, 28);
		contentPane.add(lblResultado);
	}
}
