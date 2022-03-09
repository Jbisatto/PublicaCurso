package exercicio08;

import java.util.Random;

import javax.swing.JOptionPane;

public class JogoVelhaAutomatico {

	public static void main(String[] args) {
		char[][] jogo = new char[3][3];
		boolean parar = true, numeroRepetido = true;
		int contador = 1, posicao, valor;
		Random aleatorio = new Random();
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				jogo[i][j] = Integer.toString(contador).charAt(0);
				contador++;

			}

		}		while (parar) {

			System.out.println("");
			for (int i = 0; i < 3; i++) {
				System.out.println("");
				for (int j = 0; j < 3; j++) {
					System.out.print(jogo[i][j] + "  ");
				}

			}

			while (numeroRepetido) {
				posicao = Integer.parseInt(JOptionPane.showInputDialog("Jogador X Informe a posi��o"));

				switch (posicao) {
				case 1:
					if (jogo[0][0] == '1') {
						jogo[0][0] = 'X';
						numeroRepetido=false;
					}else {
						JOptionPane.showMessageDialog(null, "Posi��o j� marcada!!!");
					}
					break;
				case 2:
					if (jogo[0][1] == '2') {
						jogo[0][1] = 'X';
						numeroRepetido=false;
					}else {
						JOptionPane.showMessageDialog(null, "Posi��o j� marcada!!!");
					}
					break;
				case 3:
					if (jogo[0][2] == '3') {
						jogo[0][2] = 'X';
						numeroRepetido=false;
					}else {
						JOptionPane.showMessageDialog(null, "Posi��o j� marcada!!!");
					}
					break;
				case 4:
					if (jogo[1][0] == '4') {
						jogo[1][0] = 'X';
						numeroRepetido=false;
					}else {
						JOptionPane.showMessageDialog(null, "Posi��o j� marcada!!!");
					}
					break;
				case 5:
					if (jogo[1][1] == '5') {
						jogo[1][1] = 'X';
						numeroRepetido=false;
					}else {
						JOptionPane.showMessageDialog(null, "Posi��o j� marcada!!!");
					}
					break;
				case 6:
					if (jogo[1][2] == '6') {
						jogo[1][2] = 'X';
						numeroRepetido=false;
					}else {
						JOptionPane.showMessageDialog(null, "Posi��o j� marcada!!!");
					}
					break;
				case 7:
					if (jogo[2][0] == '7') {
						jogo[2][0] = 'X';
						numeroRepetido=false;
					}else {
						JOptionPane.showMessageDialog(null, "Posi��o j� marcada!!!");
					}
					break;
				case 8:
					if (jogo[2][1] == '8') {
						jogo[2][1] = 'X';
						numeroRepetido=false;
					}else {
						JOptionPane.showMessageDialog(null, "Posi��o j� marcada!!!");
					}
					break;
				case 9:
					if (jogo[2][2] == '9') {
						jogo[2][2] = 'X';
						numeroRepetido=false;
					}else {
						JOptionPane.showMessageDialog(null, "Posi��o j� marcada!!!");
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "Posi�ao invalida!!!");
				}
			}
			numeroRepetido=true;
			System.out.println("");
			
			for (int i = 0; i < 3; i++) {
				System.out.println("");
				for (int j = 0; j < 3; j++) {
					System.out.print(jogo[i][j] + "  ");
				}

			}
//Linhas			
			if(jogo[0][0]=='X'&&jogo[0][1]=='X'&&jogo[0][2]=='X') {
				parar=false;
				JOptionPane.showMessageDialog(null, "Jogador X venceu!!!");
			}else if(jogo[1][0]=='X'&&jogo[1][1]=='X'&&jogo[1][2]=='X') {
				parar=false;
				JOptionPane.showMessageDialog(null, "Jogador X venceu!!!");
			}else if(jogo[2][0]=='X'&&jogo[2][1]=='X'&&jogo[2][2]=='X') {
				parar=false;
				JOptionPane.showMessageDialog(null, "Jogador X venceu!!!");
			}else 
//Colunas		
				if(jogo[0][0]=='X'&&jogo[1][0]=='X'&&jogo[2][0]=='X') {
				parar=false;
				JOptionPane.showMessageDialog(null, "Jogador X venceu!!!");
			}else if(jogo[0][1]=='X'&&jogo[1][1]=='X'&&jogo[1][1]=='X') {
				parar=false;
				JOptionPane.showMessageDialog(null, "Jogador X venceu!!!");
			}else if(jogo[0][2]=='X'&&jogo[1][2]=='X'&&jogo[2][2]=='X') {
				parar=false;
				JOptionPane.showMessageDialog(null, "Jogador X venceu!!!");
			}else
//Diagonais				
				if(jogo[0][0]=='X'&&jogo[1][1]=='X'&&jogo[2][2]=='X') {
					parar=false;
					JOptionPane.showMessageDialog(null, "Jogador X venceu!!!");
				}else if(jogo[2][0]=='X'&&jogo[1][1]=='X'&&jogo[0][2]=='X') {
					parar=false;
					JOptionPane.showMessageDialog(null, "Jogador X venceu!!!");
				}
			
			
			
			
			
			while (numeroRepetido) { 
				
				posicao= aleatorio.nextInt(9) + 1;
				switch (posicao) {
				case 1:
					if (jogo[0][0] == '1') {
						jogo[0][0] = 'O';
						numeroRepetido=false;
					}
					break;
				case 2:
					if (jogo[0][1] == '2') {
						jogo[0][1] = 'O';
						numeroRepetido=false;
					}
					break;
				case 3:
					if (jogo[0][2] == '3') {
						jogo[0][2] = 'O';
						numeroRepetido=false;
					}
					break;
				case 4:
					if (jogo[1][0] == '4') {
						jogo[1][0] = 'O';
						numeroRepetido=false;
					}
					break;
				case 5:
					if (jogo[1][1] == '5') {
						jogo[1][1] = 'O';
						numeroRepetido=false;
					}
					break;
				case 6:
					if (jogo[1][2] == '6') {
						jogo[1][2] = 'O';
						numeroRepetido=false;
					}
					break;
				case 7:
					if (jogo[2][0] == '7') {
						jogo[2][0] = 'O';
						numeroRepetido=false;
					}
					break;
				case 8:
					if (jogo[2][1] == '8') {
						jogo[2][1] = 'O';
						numeroRepetido=false;
					}
					break;
				case 9:
					if (jogo[2][2] == '9') {
						jogo[2][2] = 'O';
						numeroRepetido=false;
					}
					break;
				default:
					JOptionPane.showMessageDialog(null, "Posi�ao invalida!!!");
				}
			}
			numeroRepetido=true;
//Linhas			
			if(jogo[0][0]=='O'&&jogo[0][1]=='O'&&jogo[0][2]=='O') {
				parar=false;
				JOptionPane.showMessageDialog(null, "Jogador O venceu!!!");
			}else if(jogo[1][0]=='O'&&jogo[1][1]=='O'&&jogo[1][2]=='O') {
				parar=false;
				JOptionPane.showMessageDialog(null, "Jogador O venceu!!!");
			}else if(jogo[2][0]=='O'&&jogo[2][1]=='O'&&jogo[2][2]=='O') {
				parar=false;
				JOptionPane.showMessageDialog(null, "Jogador O venceu!!!");
			}else 
//Colunas		
				if(jogo[0][0]=='O'&&jogo[1][0]=='O'&&jogo[2][0]=='O') {
				parar=false;
				JOptionPane.showMessageDialog(null, "Jogador O venceu!!!");
			}else if(jogo[0][1]=='O'&&jogo[1][1]=='O'&&jogo[1][1]=='O') {
				parar=false;
				JOptionPane.showMessageDialog(null, "Jogador O venceu!!!");
			}else if(jogo[0][2]=='O'&&jogo[1][2]=='O'&&jogo[2][2]=='O') {
				parar=false;
				JOptionPane.showMessageDialog(null, "Jogador O venceu!!!");
			}else
//Diagonais				
				if(jogo[0][0]=='O'&&jogo[1][1]=='O'&&jogo[2][2]=='O') {
					parar=false;
					JOptionPane.showMessageDialog(null, "Jogador O venceu!!!");
				}else if(jogo[2][0]=='O'&&jogo[1][1]=='O'&&jogo[0][2]=='O') {
					parar=false;
					JOptionPane.showMessageDialog(null, "Jogador O venceu!!!");
				}

//			parar=false;

		}		System.out.println("");
		for (int i = 0; i < 3; i++) {
			System.out.println("");
			for (int j = 0; j < 3; j++) {
				System.out.print(jogo[i][j] + "  ");
			}

		}

	}

}
