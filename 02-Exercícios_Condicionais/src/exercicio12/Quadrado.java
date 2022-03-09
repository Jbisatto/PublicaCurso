package exercicio12;

import javax.swing.JOptionPane;

public class Quadrado {

	public static void main(String[] args) {
		int lado1 = Integer.parseInt(JOptionPane.showInputDialog("Informe as dimensões do Quadrado (Lado 1)"));
		int lado2 = Integer.parseInt(JOptionPane.showInputDialog("Informe as dimensões do Quadrado (Lado 2)"));
		int lado3 = Integer.parseInt(JOptionPane.showInputDialog("Informe as dimensões do Quadrado (Lado 3)"));
		int lado4 = Integer.parseInt(JOptionPane.showInputDialog("Informe as dimensões do Quadrado (Lado 4)"));
		
		if(lado1==lado2&&lado1==lado3&&lado1==lado4
				&&lado2==lado3&&lado2==lado4
				&&lado3==lado4) {

			JOptionPane.showMessageDialog(null,"É um quadrado!!!");
		}else {

			JOptionPane.showMessageDialog(null,"Não é um quadrado!!!");
		}
			
	}

}
