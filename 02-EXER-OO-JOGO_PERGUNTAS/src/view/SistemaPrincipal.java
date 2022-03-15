package view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.JOptionPane;

import calssesDAO.JogadorDAO;
import calssesDAO.PerguntasDAO;
import modelo.Jogador;
import modelo.Perguntas;

public class SistemaPrincipal {

	public static void main(String[] args) {
		Perguntas pergunta = new Perguntas();
		PerguntasDAO perguntasDAO = new PerguntasDAO();
		perguntasDAO.populadorPerguntas();
		Random aleatorio = new Random();
		int qtdJogador=0;

		boolean sair = true, sairJogo = true, perguntaSelecionada = true;
		
		JogadorDAO jogadorDAO = new JogadorDAO();

		while (sairJogo) {
			int contadorPerguntas = 0, qtdjogadasValidas = 0;
			int pular = 0, dica = 0, erros = 0, acertos = 0;
			int[] perguntasFeitas = { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 };
			int sorteioPergunta = -1, eliminar = 0;
			Jogador jogador = new Jogador();
			jogador.setNomeJogador(JOptionPane.showInputDialog("Digite o nome do Jogador!"));
			qtdJogador++;
			Date dataHoraAtual = new Date();
			while (sair) {
//			int valor = aleatorio.nextInt(4) + 1;

				while (perguntaSelecionada) {
					sorteioPergunta = aleatorio.nextInt(10);
					boolean verifica = false;
					for (int i = 0; i < perguntasFeitas.length; i++) {
						if (sorteioPergunta == perguntasFeitas[i]) {
							verifica = true;
						}
					}
					if (!verifica) {
						perguntasFeitas[contadorPerguntas] = sorteioPergunta;
						contadorPerguntas++;
						perguntaSelecionada = false;
					}
				}
				System.out.println(sorteioPergunta);
				int resposta = Integer.parseInt(
						JOptionPane.showInputDialog("Pulou: " + pular + " - Dica: " + dica + " - Erros: " + erros
								+ " - Acertos: " + acertos + "\n" + perguntasDAO.buscaPergunta(sorteioPergunta)));

				if (resposta > 0 && resposta < 5) {
					String respCerta = perguntasDAO.verificaResposta(sorteioPergunta, resposta);
					pergunta = perguntasDAO.buscarPergunta(sorteioPergunta);
					if (pergunta.getResposta().equals(respCerta)) {
						JOptionPane.showMessageDialog(null, "Acertou");
						acertos++;
						qtdjogadasValidas++;
						perguntaSelecionada = true;
					} else {
						JOptionPane.showMessageDialog(null, "Errou");
						erros++;
						qtdjogadasValidas++;
						perguntaSelecionada = true;
					}

				} else if (resposta == 5) {
					if (pular == 3) {
						JOptionPane.showMessageDialog(null, "Vc nao pode mais pular!!!");
					} else {
						pular++;
						perguntaSelecionada = true;
					}
				} else if (resposta == 6) {
					if (dica == 2) {
						JOptionPane.showMessageDialog(null, "Vc nao tem mais dicas!!!");
					} else {
						JOptionPane.showMessageDialog(null, perguntasDAO.buscaDica(sorteioPergunta));
						dica++;
					}
				} else if (resposta == 7) {
					if (eliminar == 1) {
						JOptionPane.showMessageDialog(null, "Vc nao pode elimar mais!!!");
					} else {
						JOptionPane.showMessageDialog(null, perguntasDAO.eliminarUma(sorteioPergunta));
						eliminar++;
					}
				}

				if (qtdjogadasValidas == 5) {
					jogador.setQtdAcertos(acertos);
					jogador.setQtdErros(erros);
					jogador.setHora(dataHoraAtual);
					jogadorDAO.salvar(jogador);
					sair = false;
				}
				for (int i = 0; i < perguntasFeitas.length; i++) {
					System.out.println(perguntasFeitas[i]);
				}
			}
			int termino= Integer.parseInt(JOptionPane.showInputDialog("Novo jogador?\n1-Sim\n2-Não"));
			if(termino!=1) {
				sairJogo=false;
			}
		}

		JOptionPane.showInputDialog(jogadorDAO);

	}

}
