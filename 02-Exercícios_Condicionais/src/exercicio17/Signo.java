package exercicio17;

import javax.swing.JOptionPane;

public class Signo {
	
	public static void main(String[] args) {
		
		int dia = Integer.parseInt(JOptionPane.showInputDialog("Informe o dia do Nacimento: "));
		int mes = Integer.parseInt(JOptionPane.showInputDialog("Informe o m?s do Nascimento: "));
		
		if((dia>=21&&mes==3)||((dia<=20)&&(mes==4))){
			JOptionPane.showMessageDialog(null,"O Signo ? ?ries!!!");
			
		}else if((dia>=21&&mes==4)||((dia<=20)&&(mes==5))){
			JOptionPane.showMessageDialog(null,"O Signo ? Touro!!!");
			
		}else if((dia>=21&&mes==5)||((dia<=20)&&(mes==6))){
			JOptionPane.showMessageDialog(null,"O Signo ? G?meos!!!");
			
		}else if((dia>=21&&mes==6)||((dia<=21)&&(mes==7))){
			JOptionPane.showMessageDialog(null,"O Signo ? C?ncer!!!");
			
		}else if((dia>=22&&mes==7)||((dia<=22)&&(mes==8))){
			JOptionPane.showMessageDialog(null,"O Signo ? Le?o!!!");
			
		}else if((dia>=23&&mes==8)||((dia<=22)&&(mes==9))){
			JOptionPane.showMessageDialog(null,"O Signo ? Virgem!!!");
			
		}else if((dia>=23&&mes==9)||((dia<=22)&&(mes==10))){
			JOptionPane.showMessageDialog(null,"O Signo ? Libra!!!");
			
		}else if((dia>=23&&mes==10)||((dia<=21)&&(mes==11))){
			JOptionPane.showMessageDialog(null,"O Signo ? Escorpi?o!!!");
			
		}else if((dia>=22&&mes==11)||((dia<=21)&&(mes==12))){
			JOptionPane.showMessageDialog(null,"O Signo ? Sagit?rio!!!");
			
		}else if((dia>=22&&mes==12)||((dia<=20)&&(mes==1))){
			JOptionPane.showMessageDialog(null,"O Signo ? Capric?rnio!!!");
			
		}else if((dia>=21&&mes==1)||((dia<=19)&&(mes==2))){
			JOptionPane.showMessageDialog(null,"O Signo ? Aqu?rio!!!");
			
		}else if((dia>=20&&mes==2)||((dia<=20)&&(mes==3))){
			JOptionPane.showMessageDialog(null,"O Signo ? Peixes!!!");
			
		}else
			JOptionPane.showMessageDialog(null,"Signo n?o encontrado!!!");
		
		
//		?ries 21/Mar?o - 20/Abril
//		Touro 21/Abril - 20/Maio
//		G?meos 21/Maio - 20/Junho
//		C?ncer 21/Junho - 21/Julho
//		Le?o 22/Julho - 22/Agosto
//		Virgem 23/Agosto - 22/Setembro
//		Libra 23/Setembro - 22/Outubro
//		Escorpi?o 23/Outubro - 21/Novembro
//		Sagit?rio 22/Novembro - 21/Dezembro
//		Capric?rnio 22/Dezembro - 20/Janeiro
//		Aqu?rio 21/Janeiro - 19/Fevereiro
//		Peixes 20/Fevereiro - 20/Mar?o
		
		
	}

}
