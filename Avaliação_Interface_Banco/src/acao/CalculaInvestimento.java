package acao;

public class CalculaInvestimento {
	public static double impostoRetido;
	
	
	/**
	 * Calcula o Investimento da Poupança
	 * @param tipo
	 * @return
	 */
	public static double calcularPoupanca(double valor, int tempo) {
		double taxa = buscarTaxa('P');
		double montante = valor * Math.pow((1 + taxa), tempo);
		return montante;

	}

	/**
	 * Calcula o Investimento LCI
	 * @param tipo
	 * @return
	 */
	public static double calcularLCI(double valor, int tempo) {
		double taxa = buscarTaxa('C');
		double montante = valor * Math.pow((1 + taxa), tempo);
		return montante;

	}

	
	/**
	 * Calcula o Investimento retirando os imposto referente ao valor e tempo de aplicação
	 * @param tipo
	 * @return
	 */
	public static double calcularCDB(double valor, int tempo) {
		double taxa = buscarTaxa('C');
		impostoRetido = 0;
		double montante = valor * Math.pow((1 + taxa), tempo);
		impostoRetido = (montante - valor) * impostoCdb(tempo);
		return montante - impostoRetido;

	}
/**
 * retorna a taxa referente ao tipo investimento
 * P= Poupança;
 * 
 * @param tipo
 * @return
 */
	public static double buscarTaxa(char tipo) {
		if (tipo == 'P') {
			return 0.005;
		} else {
			return 0.1165 / 12;
		}
	}

	/**
	 * retorna o percentual de imposto referente ao tempo de aplicação
	 * 
	 * @param tipo
	 * @return
	 */
	public static double impostoCdb(int tempo) {
		if (tempo <= 6) {
			return 0.225;
		} else if (tempo > 6 && tempo < 13) {
			return 0.20;
		} else if (tempo >= 13 && tempo < 25) {
			return 0.175;
		} else {
			return 0.15;
		}
	}

}
