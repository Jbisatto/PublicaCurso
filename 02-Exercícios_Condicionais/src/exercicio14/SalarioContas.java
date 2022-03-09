package exercicio14;

import javax.swing.JOptionPane;

public class SalarioContas {

	public static void main(String[] args) {
		double salario = Double.parseDouble(JOptionPane.showInputDialog("Informe o Sálario:"));
		double luz = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da conta da Luz:"));
		double telefone = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da conta do Telefone:"));
		double agua = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da conta da Água:"));
		double mercado = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da conta do Mercado:"));
		double lazer = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da conta do Lazer:"));
		double aluguel = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor da conta do Aluguel:"));
		double totalDeContas= luz+telefone+agua+mercado+lazer+aluguel;
		
		if(salario<=totalDeContas) {
			JOptionPane.showMessageDialog(null, "Infelizmente de BO esse mês, vc gastou mais que ganhou. Saldo atual é de R$ "+(salario-totalDeContas));
		}else {

			JOptionPane.showMessageDialog(null, "Ira sobra do seu salário R$"+(salario-totalDeContas));
		}
	}

}
