package exercicio01;

import java.util.Iterator;

import javax.swing.JOptionPane;

public class DoisVeroresCalculo {

	public static void main(String[] args) {
		
		int[] v1 =new int[10];
		int[] v2 =new int[10];
		int[] vRetorno =new int[10];
		String resultado="";
		
		for (int i = 0; i < v1.length; i++) {
			v1[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe um numero para primeiro vetor!!!"));
		}
		for (int i = 0; i < v2.length; i++) {
			v2[i] = Integer.parseInt(JOptionPane.showInputDialog("Informe um numero para segundo vetor!!!"));
		}
		
		int operacao= Integer.parseInt(JOptionPane.showInputDialog("Escolha o tipo de opera��o:\n1-Adi��o\n2-Subtra��o\n3-Multiplica��o\n4-Divis�o"));
		
		switch (operacao) {
		case 1:
			for (int i = 0; i < vRetorno.length; i++) {
				vRetorno[i]=(v1[i]+v2[i]);
			}
			break;
		case 2:
			for (int i = 0; i < vRetorno.length; i++) {
				vRetorno[i]=(v1[i]-v2[i]);			}
			break;
		case 3:
			for (int i = 0; i < vRetorno.length; i++) {
				vRetorno[i]=(v1[i]*v2[i]);			}
			break;
		case 4:
			for (int i = 0; i < vRetorno.length; i++) {
				vRetorno[i]=(v1[i]/v2[i]);			}
			break;
		default:
			JOptionPane.showMessageDialog(null, "Operador Invalido!!");
		}
		
		for (int i = 0; i < vRetorno.length; i++) {
			if(i < (vRetorno.length-1)) {
					resultado=resultado+vRetorno[i]+", ";
			}else {
				resultado=resultado+vRetorno[i];
			}
		}
		
		JOptionPane.showMessageDialog(null, "Resultado: "+resultado);
	}

}
