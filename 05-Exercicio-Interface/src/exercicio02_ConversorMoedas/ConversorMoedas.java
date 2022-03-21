package exercicio02_ConversorMoedas;

import java.text.NumberFormat;

import javax.swing.JOptionPane;

public class ConversorMoedas {

	public static String converteMoeda(String texto, int tipo) {
		double valor;
		try {
			valor = Double.parseDouble(texto);
			return converte(valor,tipo);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Esse Campo só aceita números!");
		}	
		
		return "";
	}
	public static String converte(double valor, int tipo) {
		NumberFormat z = NumberFormat.getInstance();
		switch (tipo) {
		case 1->valor*=4.94;
		case 2->valor*=5.45;
		case 3->valor*=6.52;
		case 4->valor*=0.041;
		case 5->valor*=0.045 ;
		}		
		return z.format(valor);
	}
}
