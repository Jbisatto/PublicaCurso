package exercicio09;

import java.util.Random;

import javax.swing.JOptionPane;

public class JogoForcaAutomatizado {

	public static void main(String[] args) {

		Random aleatorio = new Random();
		char[][] palavras = { { 'j', 'a', 'v', 'a' }, { 'p', 'r', 'o', 'w', 'a', 'y' },
				{ 'p', 'u', 'b', 'l', 'i', 'c', 'a' }, { 'r', 'a', 'l', 'f' } };
		int palavra = aleatorio.nextInt(4);
//quantidade de colunas	
		System.out.println(palavra);
		int erro = 0;
		int acertou = 0, aux = 0;
		char letra;
		boolean parar = true, contem = false, teste = false;
		char[] alfabeto = new char[26];

		while (parar) {
			letra = Character
					.toLowerCase(JOptionPane.showInputDialog("Digite uma letra!!! Erro: " + erro + acertou).charAt(0));

			for (int i = 0; i < alfabeto.length; i++) {
				if (alfabeto[i] == letra) {
					contem = true;
				}
			}
			if (contem == false) {

				alfabeto[aux] = letra;
				aux++;
				for (int i = 0; i < palavras[palavra].length; i++) {
					if (palavras[palavra][i] == letra) {
						acertou++;
						teste = true;
					}
				}
				if (teste) {
					teste = false;
				} else {
					erro++;
				}

			} else {
				System.out.println("s");
				erro++;
			}
			if (acertou == palavras[palavra].length) {
				JOptionPane.showMessageDialog(null, "Venceu!!!");
				parar = false;
			}
			if (erro == palavras[palavra].length) {
				JOptionPane.showMessageDialog(null, "Perdeu!!!");
				parar = false;
			}
			contem = false;
		}

	}
}
