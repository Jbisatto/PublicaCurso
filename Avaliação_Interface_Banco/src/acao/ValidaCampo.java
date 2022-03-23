package acao;

import javax.swing.JOptionPane;

public class ValidaCampo {
	
	public static double validaDouble(String texto) {
		double valor=0;
		try {
			valor = Double.parseDouble(texto);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Valor invalido!!!");
		}
		return valor;
	}
	
	

}
