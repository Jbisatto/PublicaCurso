package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acoes.ChamadaAcao;
import acoes.DataCadastradaAcao;
import acoes.NotaAcao;
import acoes.ProfessorAcao;
import acoes.ProvaAcao;
import bd.Bd;
import modelo.Chamada;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FormProfessor extends JFrame {

	private JPanel contentPane;
	private ProvaAcao provaAcao = new ProvaAcao();
	private ProfessorAcao professorAcao = new ProfessorAcao();
	private JTable table;
	private ButtonGroup grupo;
	private ChamadaAcao chamadaAcao = new ChamadaAcao();
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	DataCadastradaAcao dataCadastrada = new DataCadastradaAcao();
	


	/**
	 * Create the frame.
	 */
	public FormProfessor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadProva = new JButton("Provas");
		btnCadProva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormProva formProva = new FormProva();
				formProva.setVisible(true);

			}
		});
		btnCadProva.setBounds(10, 10, 131, 27);
		contentPane.add(btnCadProva);
		
		JButton btnCadastrarNotas = new JButton("Cadastrar Notas");
		btnCadastrarNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(provaAcao.verificaTabela()) {
					FormCadNotas formCadNota= new FormCadNotas();
					formCadNota.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"Nenhuma Prova Cadastrada");
				}

			}
		});
		btnCadastrarNotas.setBounds(10, 47, 131, 27);
		contentPane.add(btnCadastrarNotas);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				FormLogin frame = new FormLogin();
				frame.setVisible(true);
				dispose();
			}
		});
		btnSair.setBounds(486, 12, 89, 23);
		contentPane.add(btnSair);
		
		JRadioButton rdbtnMediaProva = new JRadioButton("Média da turma em cada prova");
		rdbtnMediaProva.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				table.setModel(professorAcao.listarMediaProva());
			}
		});
		rdbtnMediaProva.setSelected(true);
		rdbtnMediaProva.setActionCommand("MediaP");
		rdbtnMediaProva.setBounds(10, 81, 225, 23);
		contentPane.add(rdbtnMediaProva);
		
		JRadioButton rdbtnQuantidadeMF = new JRadioButton("Quantidade de meninos e meninas");
		rdbtnQuantidadeMF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				table.setModel(professorAcao.listarQtdMF());
			}
		});
		rdbtnQuantidadeMF.setActionCommand("QtdMF");
		rdbtnQuantidadeMF.setBounds(10, 107, 225, 23);
		contentPane.add(rdbtnQuantidadeMF);
		
		JRadioButton rdbtnMaiorSete = new JRadioButton("Média maior que 7");
		rdbtnMaiorSete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				table.setModel(professorAcao.listarMaiorSete());
			}
		});
		rdbtnMaiorSete.setActionCommand("Maior7");
		rdbtnMaiorSete.setBounds(10, 133, 225, 23);
		contentPane.add(rdbtnMaiorSete);
		
		JRadioButton rdbtnMdiaInferiorQue = new JRadioButton("Média inferior que 7");
		rdbtnMdiaInferiorQue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				table.setModel(professorAcao.listarMenorSete());
			}
		});
		rdbtnMdiaInferiorQue.setActionCommand("Menor7");
		rdbtnMdiaInferiorQue.setBounds(10, 159, 225, 23);
		contentPane.add(rdbtnMdiaInferiorQue);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 233, 565, 191);
		contentPane.add(scrollPane);
		
		grupo = new ButtonGroup();

		grupo.add(rdbtnMediaProva);
		grupo.add(rdbtnQuantidadeMF);
		grupo.add(rdbtnMaiorSete);
		grupo.add(rdbtnMdiaInferiorQue);
		
		table = new JTable(professorAcao.listarMediaProva());
		scrollPane.setViewportView(table);
		
		JButton btnChamadas = new JButton("Chamadas");
		btnChamadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnChamadas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				FormChamadas formChamadas= new FormChamadas();
				formChamadas.setVisible(true);
				dispose();
			}
		});
		btnChamadas.setBounds(258, 12, 115, 23);
		contentPane.add(btnChamadas);
		
		JComboBox cbxData = new JComboBox();
		cbxData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbxData.getSelectedIndex()!=0) {
					table.setModel(dataCadastrada.listarPorData(cbxData.getSelectedIndex()-1));
				}
			}
		});
		cbxData.addItem("Selecione uma Data");
		for (int i = 0; i < Bd.listaData.size(); i++) {
			cbxData.addItem(formatter.format(Bd.listaData.get(i)));
		}
		cbxData.setBounds(460, 69, 115, 22);
		contentPane.add(cbxData);
	}
}
