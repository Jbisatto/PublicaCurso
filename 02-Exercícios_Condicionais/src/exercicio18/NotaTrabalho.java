package exercicio18;

import javax.swing.JOptionPane;

public class NotaTrabalho {
	
	public static void main(String[] args) {

		double n1 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota do Trabalho 1:"));
		double n2 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota do Trabalho 2:"));
		
		
		if(n1<7||n2<7) {
			JOptionPane.showMessageDialog(null, "Reprovado");
		}else {
			JOptionPane.showMessageDialog(null, "Aprovado");
		}
	}

}
