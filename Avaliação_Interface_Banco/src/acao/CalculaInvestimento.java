package acao;

public class CalculaInvestimento {

	public static double calcularPoupanca(double valor, int tempo) {
		double taxa = buscarTaxa('P');
		double montante = valor * Math.pow((1 + taxa), tempo);
		return montante;

	}

	public static double calcularLCI(double valor, int tempo) {
		double taxa = buscarTaxa('C');
		double montante = valor * Math.pow((1 + taxa), tempo);
		return montante;

	}

	public static double calcularCDB(double valor, int tempo) {
		double taxa = buscarTaxa('C'), impostoRetido = 0;
		double montante = valor * Math.pow((1 + taxa), tempo);
		impostoRetido = (montante - valor) * impostoCdb(tempo);
		return montante - impostoRetido;

	}

	public static double buscarTaxa(char tipo) {
		if (tipo == 'P') {
			return 0.005;
		} else {
			return 0.1165 / 12;
		}
	}

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
