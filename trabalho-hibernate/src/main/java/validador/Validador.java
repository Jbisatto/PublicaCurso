package validador;

import javax.swing.JOptionPane;

public class Validador {

	public static double validaDouble(String text) {
		double valor = -1;
		try {
			valor = Double.parseDouble(text);
			if (valor > 10)
				throw new NumberFormatException();
			return (valor >= 0) ? valor : 0;
		} catch (Exception e) {
			valor = -1;
			JOptionPane.showMessageDialog(null, "Insira um valor válido");
		}
		return valor;

	}

}
