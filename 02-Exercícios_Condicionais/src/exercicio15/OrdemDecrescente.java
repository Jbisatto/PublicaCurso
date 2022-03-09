package exercicio15;

import javax.swing.JOptionPane;

public class OrdemDecrescente {

	public static void main(String[] args) {
		int numero1 = Integer
				.parseInt(JOptionPane.showInputDialog("Informe um numero:"));
		int numero2 = Integer
				.parseInt(JOptionPane.showInputDialog("Informe um numero:"));
		int numero3 = Integer
				.parseInt(JOptionPane.showInputDialog("Informe um numero:"));
		
		if(numero1>=numero2&&numero1>=numero3&&numero2>=numero3) {
			JOptionPane.showMessageDialog(null,"Ordem decrescente:"+numero1+", "+numero2+", "+numero3);
		}else if(numero1>numero2&&numero1>numero3&&numero2<numero3) {
			JOptionPane.showMessageDialog(null,"Ordem decrescente:"+numero1+", "+numero3+", "+numero2);
		}else if(numero2>numero1&&numero2>numero3&&numero1>=numero3) {
			JOptionPane.showMessageDialog(null,"Ordem decrescente:"+numero2+", "+numero1+", "+numero3);
		}else if(numero2>numero1&&numero2>=numero3&&numero1<numero3) {
			JOptionPane.showMessageDialog(null,"Ordem decrescente:"+numero2+", "+numero3+", "+numero1);
		}else if(numero3>numero2&&numero3>numero1&&numero2>numero1) {
			JOptionPane.showMessageDialog(null,"Ordem decrescente:"+numero3+", "+numero2+", "+numero1);
		}else if(numero3>numero2&&numero3>numero1&&numero2<numero1) {
			JOptionPane.showMessageDialog(null,"Ordem decrescente:"+numero3+", "+numero1+", "+numero2);
		}
	}

}
