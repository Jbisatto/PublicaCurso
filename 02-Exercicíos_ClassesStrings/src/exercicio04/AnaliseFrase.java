package exercicio04;

import javax.swing.JOptionPane;

public class AnaliseFrase {

	public static void main(String[] args) {
		while(true) {
		String verbo = JOptionPane.showInputDialog("Informe uma frase");
		String maiusculo = verbo.toUpperCase();
		int qtdMaisc = 0, qtdMinu = 0,qtdEspaco=0,qtdNumero=0;
		
		for (int i = 0; i < verbo.length(); i++) {
			if (verbo.charAt(i) != ' ') {
				if (verbo.charAt(i) == maiusculo.charAt(i)) {
					qtdMaisc++;
				} else {
					qtdMinu++;
				}
			}else {
				qtdEspaco++;
			}
			if((int)verbo.charAt(i)>47&&verbo.charAt(i)<58) {
				qtdNumero++;
			}
			System.out.println((int)verbo.charAt(i));			
			
		}
		JOptionPane.showMessageDialog(null, "Quantidade de Maisculo= "+qtdMaisc+
				"\nQuantidade de Minusculo= "+qtdMinu+
				"\nQuantidade de Espaços= "+qtdEspaco+
				"\nQuantidade de Numeros= "+qtdNumero);
		}

	}

}
