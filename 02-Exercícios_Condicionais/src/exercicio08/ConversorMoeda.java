package exercicio08;

import javax.swing.JOptionPane;

public class ConversorMoeda {
	
	public static void main(String[] args) {
		
	
	double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o Valor que deseja converter"));
	int converte = Integer.parseInt(JOptionPane.showInputDialog(""
			+ "1-Real para D?lar"
			+ " \n 2-D?lar para Real"
			+"\n 3-Real para Euro"
			+ "\n 4-Euro para Real"));
	
	
	switch (converte) {
	case 1: 
		valor= valor/5.08;

		JOptionPane.showMessageDialog(null,"Dolar $"+valor);
		break;
	case 2: 
		valor= valor*5.08;
		JOptionPane.showMessageDialog(null,"Real R$"+valor);
		break;

	case 3: 
		valor= valor/5.51;
		JOptionPane.showMessageDialog(null,"Euro $"+valor);
		break;
	case 4: 
		valor= valor*5.51;
		JOptionPane.showMessageDialog(null,"Real R$"+valor);
		break;
	default:
		JOptionPane.showMessageDialog(null,"Informa??o incorreta!!!");
	}
	

}
}