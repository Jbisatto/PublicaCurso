package formulario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import acao.CalculaInvestimento;
import acao.CalculoDias;
import acao.ValidaCampo;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;

import javax.swing.JComboBox;

public class FormPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField txtValor;
	private JComboBox<String> cbxTempo;
	private ChartPanel painel;
	NumberFormat z = NumberFormat.getCurrencyInstance();
	private JLabel lblQtdDiasUteis;
	private JLabel lblValorInicial;
	private JLabel lblValorRedendimesntos;
	private JLabel lblImpostosRenda;
	private JLabel lblValorTotal;
	private JLabel lblQtdDiasTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrincipal frame = new FormPrincipal();
					frame.setTitle("Calculo de Investimentos");
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
	public FormPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 656, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTitulo = new JLabel("CALCULO DE INVESTIMENTO");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitulo.setBounds(165, 0, 216, 25);
		contentPane.add(lblTitulo);

		JLabel lblInvestimento = new JLabel("Valor:");
		lblInvestimento.setBounds(26, 36, 46, 14);
		contentPane.add(lblInvestimento);

		txtValor = new JTextField();
		txtValor.setBounds(61, 33, 86, 20);
		contentPane.add(txtValor);
		txtValor.setColumns(10);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (ValidaCampo.validaDouble(txtValor.getText()) != 0 && cbxTempo.getSelectedIndex() != 0) {
					painel.setVisible(true);
					painel.setChart(criarGrafico(
							CalculaInvestimento.calcularPoupanca(Double.parseDouble(txtValor.getText()),
									buscaTempoCombo()),
							CalculaInvestimento.calcularLCI(Double.parseDouble(txtValor.getText()), buscaTempoCombo()),
							CalculaInvestimento.calcularCDB(Double.parseDouble(txtValor.getText()),
									buscaTempoCombo())));
					CalculoDias.adicionarDiasUteis(buscaTempoCombo());
					qtdTotalDias();
					qtdDiasUteis();
					valorInicial(Double.parseDouble(txtValor.getText()));
					valorTotalRendimentos(Double.parseDouble(txtValor.getText()),buscaTempoCombo());
				} else {
					painel.setVisible(false);
					txtValor.setText("");
					;
				}
			}
		});
		btnCalcular.setBounds(302, 32, 89, 23);
		contentPane.add(btnCalcular);

		painel = new ChartPanel(criarGrafico(0, 0, 0));
		painel.setVisible(false);
		painel.setBounds(10, 195, 620, 222);
		contentPane.add(painel);

		cbxTempo = new JComboBox<>();
		cbxTempo.addItem("Aplicar");
		cbxTempo.addItem("3 meses");
		cbxTempo.addItem("6 meses");
		cbxTempo.addItem("9 meses");
		cbxTempo.addItem("12 meses");
		cbxTempo.addItem("18 meses");
		cbxTempo.setBounds(175, 32, 117, 22);
		contentPane.add(cbxTempo);

		lblQtdDiasTotal = new JLabel("Quantidade de dias corridos da aplica\u00E7\u00E3o:");
		lblQtdDiasTotal.setBounds(26, 68, 355, 25);
		contentPane.add(lblQtdDiasTotal);

		lblQtdDiasUteis = new JLabel("Quantidade de dias que houve rendimento:");
		lblQtdDiasUteis.setBounds(26, 88, 355, 25);
		contentPane.add(lblQtdDiasUteis);

		lblValorInicial = new JLabel("Valor inicial da aplica\u00E7\u00E3o:");
		lblValorInicial.setBounds(26, 106, 365, 27);
		contentPane.add(lblValorInicial);

		lblValorRedendimesntos = new JLabel("Valor recebido dos rendimentos:");
		lblValorRedendimesntos.setBounds(26, 125, 604, 25);
		contentPane.add(lblValorRedendimesntos);

		lblImpostosRenda = new JLabel("Imposto de renda cobrado:");
		lblImpostosRenda.setBounds(26, 144, 355, 25);
		contentPane.add(lblImpostosRenda);

		lblValorTotal = new JLabel("Valor inicial + rendimentos");
		lblValorTotal.setBounds(26, 161, 604, 25);
		contentPane.add(lblValorTotal);
	}

	public JFreeChart criarGrafico(double poupanca, double cdb, double lci) {
		DefaultCategoryDataset barra = new DefaultCategoryDataset();
		barra.setValue(poupanca, "Poupança", "");
		barra.setValue(cdb, "CDI", "");
		barra.setValue(lci, "LCI", "");

		JFreeChart grafico = ChartFactory.createBarChart("Gráfico Comparativo de Investimentos", "Investimentos", "R$",
				barra, PlotOrientation.VERTICAL, true, true, false);

		return grafico;

	}

	public int buscaTempoCombo() {
		int mes;
		switch (cbxTempo.getSelectedIndex()) {
		case 1 -> mes = 3;
		case 2 -> mes = 6;
		case 3 -> mes = 9;
		case 4 -> mes = 12;
		case 5 -> mes = 18;
		default -> throw new IllegalArgumentException("Unexpected value: " + cbxTempo.getSelectedIndex());
		}
		return mes;
	}

	public void qtdTotalDias() {
		lblQtdDiasTotal.setText("Quantidade de dias corridos da aplicação: " + CalculoDias.qtdTotal);
	}
	
	public void qtdDiasUteis() {
		lblQtdDiasUteis.setText("Quantidade de dias que houve rendimento: " + CalculoDias.qtdDiaUteis);
	}
	
	public void valorInicial(double valor) {
		lblValorInicial.setText("Valor inicial da aplicação:" + z.format(valor));
	}
	public void valorTotalRendimentos(double valor, int tempo) {
		double poupanca=CalculaInvestimento.calcularPoupanca(valor, tempo);
		double cbd=CalculaInvestimento.calcularCDB(valor, tempo);
		double lci=CalculaInvestimento.calcularLCI(valor, tempo);		
		lblValorTotal.setText("Valor recebido dos rendimentos: Poupança: " + z.format(poupanca)+
				", CBD: "+z.format(cbd)+
				", LCI: "+z.format(lci));
	}
}
