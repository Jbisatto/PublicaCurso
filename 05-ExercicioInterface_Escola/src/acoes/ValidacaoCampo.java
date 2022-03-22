package acoes;

import javax.swing.JOptionPane;

public class ValidacaoCampo {
	
	public static double verificaCampoDouble(String texto) {
		try {
			return Double.parseDouble(texto);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro nas informações");
		}
		return -1;
	}

}
