package exemplo04;

import javax.swing.JOptionPane;

public class Aluno {
	
	private double nota1, nota2;
	
	public void executar() {
		nota1 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota 1: "));
		nota2 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota 2: "));
		
		double calculo = media();
		String situacao = situacao(calculo);
		JOptionPane.showMessageDialog(null, situacao+" com média: "+calculo);
	}
	
	private double media() {
		return (nota1+nota2)/2;
	}
	
	private String situacao(double media) {
		return media>=7?"Aprovado(a)":"Reprovado(a)";
	}
	

}
