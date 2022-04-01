package validador;

import java.text.DecimalFormat;

public class Arrendondador {
	
	
	public static String a(double valor) {
		DecimalFormat df = new DecimalFormat("#.00");
		return df.format(valor);
	}
}
