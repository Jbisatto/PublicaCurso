package exercicio01;


import javax.swing.JOptionPane;

public class QtdVogaisConsoantes {

	public static void main(String[] args) {

		int qtdVogal = 0,qtdConsoante=0;
		String frase = JOptionPane.showInputDialog("Informe uma frase");
		for (int i = 0; i < frase.length(); i++) {
			char letra = frase.charAt(i);
			if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
				qtdVogal++;
			}else if(letra!=' ') {
				qtdConsoante++;
				
			}
		}
		JOptionPane.showMessageDialog(null, "A frase \""+frase+"\" possue "+qtdVogal+" vogais e "+qtdConsoante+" consoantes.");

	}

}
