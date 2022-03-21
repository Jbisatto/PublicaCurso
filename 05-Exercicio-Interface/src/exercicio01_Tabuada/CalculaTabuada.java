package exercicio01_Tabuada;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CalculaTabuada {

	public static String calculaTabuada(String texto) {
		long numero;
		try {
			numero = Long.parseLong(texto);
			return montarTabuada(numero);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Esse Campo só aceita números!");
		}

		return null;

	}

	public static String montarTabuada(long numero) {
		String tabuada="";
		for (int i = 1; i < 11; i++) {
			tabuada+= numero+" x "+i+" = "+(i*numero)+"\n";
		}
		System.out.println(tabuada);
		return tabuada;
	}

}
