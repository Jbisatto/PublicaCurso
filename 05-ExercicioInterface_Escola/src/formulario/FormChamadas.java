package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import acoes.ChamadaAcao;
import acoes.DataCadastradaAcao;
import acoes.ProfessorAcao;
import acoes.ProvaAcao;
import bd.Bd;
import modelo.Chamada;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JTextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class FormChamadas extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ProfessorAcao professorAcao = new ProfessorAcao();
	private JButton btnCadastrar;
	private SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	private JTextField txtData;
	private boolean presenca;
	private ChamadaAcao chamadaAcao = new ChamadaAcao();
	private DataCadastradaAcao dataCadastrar = new  DataCadastradaAcao();



	/**
	 * Create the frame.
	 */
	public FormChamadas() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				FormProfessor formProfessor= new FormProfessor();
				formProfessor.setVisible(true);
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 324, 194);
		contentPane.add(scrollPane);
		

  
        table = new JTable(professorAcao.listaChamadas()) {

            private static final long serialVersionUID = 1L;

            /*@Override
            public Class getColumnClass(int column) {
            return getValueAt(0, column).getClass();
            }*/
            @Override
            public Class getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    default:
                        return Boolean.class;
                }
            }
        };
        table.setPreferredScrollableViewportSize(table.getPreferredSize());

		scrollPane.setViewportView(table);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				for (int i = 0; i < Bd.listaAluno.size(); i++) {
					Chamada chamada = new Chamada();
					if(table.getValueAt(i, 1).equals(true)) {
						presenca=true;
					}else {
						presenca=false;
					}
					try {
						chamada.setData(formatter.parse(txtData.getText()));
					} catch (ParseException e1) {
						JOptionPane.showMessageDialog(null,"Data informada errada");
					}
					chamada.setId_aluno(i);
					chamada.setPresenca(presenca);
					chamadaAcao.cadastrar(chamada);
				}
				try {
					dataCadastrar.cadastrar(formatter.parse(txtData.getText()));
				} catch (ParseException e1) {

				}
				JOptionPane.showMessageDialog(null, "Chamada Cadastrada!");
			}
		});
		btnCadastrar.setBounds(335, 102, 89, 23);
		contentPane.add(btnCadastrar);
		
		txtData = new JTextField();
		txtData.setBounds(338, 65, 86, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);
		
		JLabel lblTitulo = new JLabel("CHAMADA");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(146, 11, 214, 33);
		contentPane.add(lblTitulo);
	}
}
