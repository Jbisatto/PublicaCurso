package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class FormAdministardor extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public FormAdministardor() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				FormPrincipal frame;
				try {
					frame = new FormPrincipal();
					frame.setTitle("Vendas de Produtos");
					frame.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setBounds(100, 100, 512, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Administrador");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(188, 29, 129, 22);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Produtos");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				FormProdutos frame;
				try {
					frame = new FormProdutos();
					frame.setTitle("Produtos");
					frame.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(10, 126, 150, 70);
		contentPane.add(btnNewButton);
		
		JButton btnMarcas = new JButton("Marcas");
		btnMarcas.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				FormMarca formMarca;
				try {
					formMarca = new FormMarca();
					formMarca.setTitle("Marcas");
					formMarca.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnMarcas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnMarcas.setBounds(172, 126, 150, 70);
		contentPane.add(btnMarcas);
		
		JButton btnTipos = new JButton("Categorias");
		btnTipos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				FormTipo formTipo;
				try {
					formTipo = new FormTipo();
					formTipo.setTitle("Categorias");
					formTipo.setVisible(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnTipos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnTipos.setBounds(333, 126, 150, 70);
		contentPane.add(btnTipos);
	}
}
