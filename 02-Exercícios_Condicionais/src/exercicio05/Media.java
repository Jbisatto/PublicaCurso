package exercicio05;

import javax.swing.JOptionPane;

public class Media {

	public static void main(String[] args) {
		
		double numero1 = Double.parseDouble(JOptionPane.showInputDialog("Informe a primeira nota:"));
		double numero2 = Double.parseDouble(JOptionPane.showInputDialog("Informe a segunda nota:"));
		double numero3 = Double.parseDouble(JOptionPane.showInputDialog("Informe a terceira nota:"));
		double numero4 = Double.parseDouble(JOptionPane.showInputDialog("Informe a quarta nota:"));
		double media=(numero1+numero2+numero3+numero4)/4;
		
		if(media<=4.9) {
			JOptionPane.showMessageDialog(null,"A media foi "+media+"\nReprovado");
		} else if(media>=5 && media<=6.9){

			JOptionPane.showMessageDialog(null,"A media foi "+media+"\nExame");
		}else {
			JOptionPane.showMessageDialog(null,"A media foi "+media+"\nAprovado");
	}

}
}
