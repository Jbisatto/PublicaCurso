package exercicio08;

import javax.swing.JOptionPane;

public class JogoForca {

	public static void main(String[] args) {
		
		int erro=0;
		int acertou=0;
		char letra;
		boolean e=false;
		boolean s=false;
		boolean t=false;
		boolean u=false;
		boolean d=false;
		boolean a=false;
		boolean r=false;
		while(erro!=7&&acertou!=7) {
			letra=  Character.toLowerCase(JOptionPane.showInputDialog("Digite uma letra!!!").charAt(0));
			if(letra=='e'&&e==false) {
				JOptionPane.showMessageDialog(null,"Certo");
				acertou++;
				e=true;
			}else if(letra=='s' && s==false) {
				JOptionPane.showMessageDialog(null,"Certo");
				acertou++;
				s=true;	
			}else if(letra=='t'&& t==false) {
				JOptionPane.showMessageDialog(null,"Certo");
				acertou++;
				t=true;
			}else if(letra=='u' && u==false) {
				JOptionPane.showMessageDialog(null,"Certo");
				acertou++;
				u=true;
			}else if(letra=='d' && d==false) {
				JOptionPane.showMessageDialog(null,"Certo");
				acertou++;
				d=true;
			}else if(letra=='a' && a==false) {
				JOptionPane.showMessageDialog(null,"Certo");
				acertou++;
				a=true;
			}else if(letra=='r' && r==false) {
				JOptionPane.showMessageDialog(null,"Certo");
				acertou++;
				r=true;
			}else {
				erro++;
				JOptionPane.showMessageDialog(null,"Vc errou "+erro+" vez.");
			}
		}
		if(acertou==7) {

			JOptionPane.showMessageDialog(null,"Parabens, a palavra era ESTUDAR !!!");
		}else {

			JOptionPane.showMessageDialog(null,"Game Over!!!");
		}
			

	}

}