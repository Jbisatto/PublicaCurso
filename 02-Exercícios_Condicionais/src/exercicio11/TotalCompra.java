package exercicio11;

import javax.swing.JOptionPane;

public class TotalCompra {

	public static void main(String[] args) {
		double valorTotal = Double.parseDouble(JOptionPane.showInputDialog("Informe o Valor total da Compra:"));
		double formaPagamento = Double.parseDouble(JOptionPane.showInputDialog("Informe a forma de Pagamento: \n"
				+ "1-À Vista\n2-A Prazo"));
		
		if(valorTotal>=200.00 && formaPagamento==1) {
			valorTotal=valorTotal*0.9;
			JOptionPane.showMessageDialog(null,"O valor da compra teve um desconto de 10%, valor total= "+valorTotal);
		}else {
			JOptionPane.showMessageDialog(null,"O valor total= "+valorTotal);
		}
	}

}
