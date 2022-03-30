package validador;

import javax.swing.JOptionPane;

public class Validador {
	
	public double validaDouble(String text) {
		double valor=0;
		try {
			valor=Double.parseDouble(text);
			return (valor>=0)?valor:0;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insira um valor válido");
		}
		return valor;
	}

}
