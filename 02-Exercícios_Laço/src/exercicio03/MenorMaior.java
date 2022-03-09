package exercicio03;

import javax.swing.JOptionPane;

public class MenorMaior {

	public static void main(String[] args) {
		int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
		int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
		int menor=(numero<numero2)?numero:numero2;
		int maior=(numero>numero2)?numero:numero2;
		for(int i=menor;i<=maior;i++) {
			System.out.println(i);
		}
	}

}
