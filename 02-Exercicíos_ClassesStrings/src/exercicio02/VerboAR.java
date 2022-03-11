package exercicio02;

import javax.swing.JOptionPane;

public class VerboAR {

	public static void main(String[] args) {

		String verbo = JOptionPane.showInputDialog("Informe um verbo terminado em AR");
		verbo=verbo.toLowerCase();
		if (verbo.endsWith("ar")) {
			JOptionPane.showMessageDialog(null, "Esse verbo Termina em AR");
			System.out.println("Esse verbo Termina em AR");
		}else {
			JOptionPane.showMessageDialog(null, "Esse verbo não Termina em AR");
			System.out.println("Esse verbo não Termina em AR");
		}
	}

}
