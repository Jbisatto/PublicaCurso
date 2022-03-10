package exercicio14;

import java.util.Random;

import javax.swing.JOptionPane;

public class JogoPerguntas {

	public static void main(String[] args) {

		boolean parar=true,perguntaValida=true, geradorcompleto=true;
		Random aleatorio = new Random();
		String[][]jogadores = new String[10][2];
		String [][] jogo = new String [20][6];
		
		jogo[0][0]="2+2";jogo[0][1]="5";jogo[0][2]="7";jogo[0][3]="3";jogo[0][4]="4";jogo[0][5]="4";
		jogo[1][0]="2+3";jogo[1][1]="5";jogo[1][2]="7";jogo[1][3]="3";jogo[1][4]="4";jogo[1][5]="5";
		jogo[2][0]="2+4";jogo[2][1]="5";jogo[2][2]="7";jogo[2][3]="3";jogo[2][4]="6";jogo[2][5]="6";
		jogo[3][0]="2+5";jogo[3][1]="5";jogo[3][2]="7";jogo[3][3]="3";jogo[3][4]="4";jogo[3][5]="7";
		jogo[4][0]="2+6";jogo[4][1]="8";jogo[4][2]="7";jogo[4][3]="3";jogo[4][4]="4";jogo[4][5]="8";
		jogo[5][0]="2+7";jogo[5][1]="5";jogo[5][2]="7";jogo[5][3]="9";jogo[5][4]="4";jogo[5][5]="9";
		jogo[6][0]="2+8";jogo[6][1]="5";jogo[6][2]="10";jogo[6][3]="3";jogo[6][4]="4";jogo[6][5]="10";
		jogo[7][0]="2+9";jogo[7][1]="5";jogo[7][2]="7";jogo[7][3]="11";jogo[7][4]="4";jogo[7][5]="11";
		jogo[8][0]="2+10";jogo[8][1]="5";jogo[8][2]="7";jogo[8][3]="3";jogo[8][4]="12";jogo[8][5]="12";
		jogo[9][0]="2+11";jogo[9][1]="5";jogo[9][2]="7";jogo[9][3]="13";jogo[9][4]="4";jogo[9][5]="13";
		
		int numeroJogadas=0;
		do {
			String nomeJogador= JOptionPane.showInputDialog("Nome do Jogador");
			int contador=0;
			int [] listaPerguntas = new int[5];
			
			//Gerador de Pergunta			
			while(geradorcompleto) {
				perguntaValida=true;
				int geradorPergunta = aleatorio.nextInt(9);
				for (int i = 0; i < listaPerguntas.length; i++) {
					if(listaPerguntas[i]==geradorPergunta) {
						perguntaValida=false;
					}
				}
				if(perguntaValida) {
				listaPerguntas[contador]=geradorPergunta;
				contador++;
				}if(contador==4) {
					geradorcompleto=false;
				}
				
			}
			geradorcompleto=true;
			int acertos=0;
			for (int i = 0; i < 5; i++) {
				int pergunta=listaPerguntas[i];
				int resposta = Integer.parseInt(JOptionPane.showInputDialog("Quanto é a soma de "+jogo[pergunta][0]));
				if(resposta==Integer.parseInt(jogo[pergunta][5])) {
					acertos++;
				}
			}
			numeroJogadas++;
			jogadores[numeroJogadas][0]=nomeJogador;
			jogadores[numeroJogadas][1]=Integer.toString(acertos);
			
			int response=0;
			if(numeroJogadas!=2) {
			String[] menupri = { "CONTINUAR", "FINALIZAR" };
			response = JOptionPane
			.showOptionDialog(null,"Você já Respondeu suas 5 Perguntas!!!","JOGO PERGUNTAS", JOptionPane.YES_NO_OPTION
					, JOptionPane.PLAIN_MESSAGE, null, menupri, "None of your business");
			}
			
			if(numeroJogadas==2||response==1) {
			  parar=false;
			}
		}while(parar);
		
		String resultado="Resultado\n";
		
		for (int i = 0; i < jogadores.length; i++) {
			if(jogadores[i][0]!=null) {
				resultado+= jogadores[i][0]+" acertos: "+jogadores[i][1]+"\n";
			}
		}
		JOptionPane.showMessageDialog(null, resultado);

	}

}
