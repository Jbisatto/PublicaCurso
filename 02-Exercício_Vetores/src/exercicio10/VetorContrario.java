package exercicio10;

import javax.swing.JOptionPane;

public class VetorContrario {

	public static void main(String[] args) {
		int [] numeros=new int [10];
		
		for (int i = 0; i < numeros.length; i++) {
			numeros[i]=Integer.parseInt(JOptionPane.showInputDialog("Informe um numero: ("+i+"):"));
		}

		for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i]+" ");
		}
		System.out.println("\n");
		for (int i =numeros.length-1; i >= 0 ; i--) {
			System.out.print(numeros[i]+" ");
		}
	}

}
