package exercicio09;

import javax.swing.JOptionPane;

public class Votacao {

	public static void main(String[] args) {
		int candidato1 = 0, candidato2 = 0, candidato3 = 0, candidato4 = 0, totalVotos = 0, voto, parar, maisVoto = 0;
		String vencedor="";
		do {
			voto = Integer.parseInt(JOptionPane.showInputDialog("1-Andr? \n2-Jo?o\n3-Maria\n4-Paulo"));
			switch (voto) {
			case 1 -> candidato1++;
			case 2 -> candidato2++;
			case 3 -> candidato3++;
			case 4 -> candidato4++;
			default -> JOptionPane.showMessageDialog(null, "Candidato n?o cadastrado!!!");
			}
			totalVotos++;
			parar = Integer.parseInt(JOptionPane.showInputDialog("Digite um 0 para encerrrar a vata??o!!!"));

		} while (parar != 0);

		if (candidato1 > maisVoto) {
			maisVoto = candidato1;
		} else if (candidato2 > maisVoto) {
			maisVoto = candidato2;
		} else if (candidato3 > maisVoto) {
			maisVoto = candidato3;
		} else if (candidato4 > maisVoto) {
			maisVoto = candidato4;
		}

		if (candidato1 == maisVoto) {
			vencedor +="Andr? ";
		}if (candidato2 == maisVoto) {
			vencedor += "\nJo?o";
		}if (candidato3 == maisVoto) {
			vencedor += "\nMaria";
		}if (candidato4 == maisVoto) {
			vencedor += "\nPaulo";
		}

			JOptionPane.showMessageDialog(null,
					"Resultado: \nAndr? " + candidato1 + " votos  " + (candidato1 * 100) / totalVotos + "%\nJo?o "
							+ candidato2 + " votos  " + (candidato2 * 100) / totalVotos + "%\nMaria " + candidato3
							+ " votos  " + (candidato3 * 100) / totalVotos + "%\nPaulo " + candidato4 + " votos  "
							+ (candidato4 * 100) / totalVotos + "%\n----------------------\n Vencedores\n"+vencedor);
	}

}
