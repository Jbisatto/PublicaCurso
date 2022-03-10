package exercicio13;



import javax.swing.JOptionPane;

public class MaisVelhoENovo {

	public static void main(String[] args) {

		String[][] pessoa = new String[10][2];
		int aux=0,maisVelho=0,maisNovo=0;
		double media=0;
		for (int i = 0; i < pessoa.length; i++) {
			pessoa[i][0] = JOptionPane.showInputDialog("Digite o nome da Pessoa: " + i);
			pessoa[i][1] = JOptionPane.showInputDialog("Digite a idade da Pessoa: " + i);
		}
		for (int i = 0; i < pessoa.length; i++) {
			media+=Integer.parseInt(pessoa[i][1]);
			System.out.println(pessoa[i][0]+" "+pessoa[i][1]);
			if(Integer.parseInt(pessoa[i][1])>aux) {
				aux=Integer.parseInt(pessoa[i][1]);
				maisVelho=i;
			}
		}
		for (int i = 0; i < pessoa.length; i++) {
			if(Integer.parseInt(pessoa[i][1])<aux) {
				aux=Integer.parseInt(pessoa[i][1]);
				maisNovo=i;
			}
		}
		System.out.println("\n"+pessoa[maisVelho][0]+" "+pessoa[maisVelho][1]);
		System.out.println(pessoa[maisNovo][0]+" "+pessoa[maisNovo][1]);
		System.out.println("Média de idade é :"+(media/(pessoa.length+1)));
		
	}
}
