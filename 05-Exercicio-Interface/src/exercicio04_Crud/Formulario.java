package exercicio04_Crud;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Formulario extends JFrame {

	private JPanel contentPane;
	private JTextField txtProduto;
	private JTextField txtMarca;
	private JTextField txtSegmento;
	private JTextField txtQuantidade;
	private JTable table;
	private JButton btnRemover,btnAlterar ;
	private int index;

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
		ProdutoAcao produtoAcao = new ProdutoAcao();
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 483, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("Cadastro de Produtos");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(10, 11, 179, 26);
		contentPane.add(lblTitulo);

		JLabel lblNome = new JLabel("Produto");
		lblNome.setBounds(20, 51, 46, 14);
		contentPane.add(lblNome);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(20, 76, 46, 14);
		contentPane.add(lblMarca);

		JLabel lblSegmento = new JLabel("Segmento");
		lblSegmento.setBounds(20, 101, 66, 14);
		contentPane.add(lblSegmento);

		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(20, 126, 66, 14);
		contentPane.add(lblQuantidade);

		txtProduto = new JTextField();
		txtProduto.setBounds(94, 48, 86, 20);
		contentPane.add(txtProduto);
		txtProduto.setColumns(10);

		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(94, 73, 86, 20);
		contentPane.add(txtMarca);

		txtSegmento = new JTextField();
		txtSegmento.setColumns(10);
		txtSegmento.setBounds(94, 98, 86, 20);
		contentPane.add(txtSegmento);

		txtQuantidade = new JTextField();
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(94, 123, 86, 20);
		contentPane.add(txtQuantidade);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 164, 447, 207);
		contentPane.add(scrollPane);

		table = new JTable(produtoAcao.listar());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnRemover.setEnabled(true);
				ProdutoModelo produto = new ProdutoModelo();
				index=table.getSelectedRow();
				produto = produtoAcao.buscarId(index);
				txtProduto.setText(produto.getNomeProduto());
				txtMarca.setText(produto.getMarca());
				txtSegmento.setText(produto.getSegmento());
				txtQuantidade.setText(Integer.toString(produto.getQuantidade()));
				
			}
		});
		scrollPane.setViewportView(table);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProdutoModelo produto = new ProdutoModelo();
				produto.setNomeProduto(txtProduto.getText());
				produto.setMarca(txtMarca.getText());
				produto.setSegmento(txtSegmento.getText());
				produto.setQuantidade(produtoAcao.validaQuantidade(txtQuantidade.getText()));
				if (produto.getQuantidade() >= 0) {
					produtoAcao.cadastra(produto);
					btnAlterar.setEnabled(true);
					table.setModel(produtoAcao.listar());
					limpaTexto();
					JOptionPane.showMessageDialog(null, "Produto cadastrado!!!");
				}else {
					JOptionPane.showMessageDialog(null, "Erro em algum dado");
				}
			}
		});
		btnCadastrar.setBounds(197, 47, 102, 23);
		contentPane.add(btnCadastrar);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produtoAcao.remover(index);
				JOptionPane.showMessageDialog(null, "Produto removido");
				table.setModel(produtoAcao.listar());
				System.out.println(produtoAcao.quantidadeCadastrado());
				if(produtoAcao.quantidadeCadastrado()==0) {
					btnAlterar.setEnabled(false);
				}
				btnRemover.setEnabled(false);
				limpaTexto();
			}
		});
		btnRemover.setEnabled(false);
		btnRemover.setBounds(197, 72, 102, 23);
		contentPane.add(btnRemover);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(index!=-1) {
					ProdutoModelo produto = new ProdutoModelo();
					produto.setNomeProduto(txtProduto.getText());
					produto.setMarca(txtMarca.getText());
					produto.setSegmento(txtSegmento.getText());
					produto.setQuantidade(produtoAcao.validaQuantidade(txtQuantidade.getText()));
					if (produto.getQuantidade() >= 0) {
						produtoAcao.alterar(produto,index);
						table.setModel(produtoAcao.listar());
						limpaTexto();
						JOptionPane.showMessageDialog(null, "Produto alterado!!!");
					}else {
						JOptionPane.showMessageDialog(null, "Erro em algum dado");
					}
				}
				
			}
		});
		btnAlterar.setEnabled(false);
		btnAlterar.setBounds(197, 97, 102, 23);
		contentPane.add(btnAlterar);
	}
	
	public void limpaTexto() {
		txtProduto.setText("");
		txtMarca.setText("");
		txtSegmento.setText("");
		txtQuantidade.setText("");
		index=-1;
	}
}
