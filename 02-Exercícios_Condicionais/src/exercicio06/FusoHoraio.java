package exercicio06;

import javax.swing.JOptionPane;

public class FusoHoraio {

	public static void main(String[] args) {
		int hora = Integer.parseInt(JOptionPane.showInputDialog("Informe a hora de Bras�lia"));
		int cidade = Integer.parseInt(JOptionPane.showInputDialog("1- Cidade do M�xico \n 2- T�quio"
				+ "\n 3- Nova York"));
		switch (cidade) {
		case 1: 
			hora-=3;
			break;
		case 2: 
			hora+=12;
			break;

		case 3: 
			hora-=2;
			break;
		default:
			JOptionPane.showMessageDialog(null,"Informa��o incorreta!!!");
		}
		
		if(hora>24) {
			hora-=24;
			JOptionPane.showMessageDialog(null,"S�o "+hora);
	}else {

		JOptionPane.showMessageDialog(null,"S�o "+hora);
	}
		
	}

}
