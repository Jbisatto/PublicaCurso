package calssesDAO;

import java.util.ArrayList;
import java.util.Random;

import modelo.Perguntas;

public class PerguntasDAO {

	public static ArrayList<Perguntas> listaPerguntas = new ArrayList<>();

	public void populadorPerguntas() {
		Perguntas pergunta = new Perguntas();

		pergunta.setPergunta("Qual a soma de 2+2: ");
		pergunta.setAlternativa1("Quatro(4)");
		pergunta.setAlternativa2("Cinco(5)");
		pergunta.setAlternativa3("Três(3)");
		pergunta.setAlternativa4("Zero(0)");
		pergunta.setResposta("Quatro(4)");
		pergunta.setDica("Maior que Três(3)");
		adicionarLista(pergunta);

		Perguntas pergunta2 = new Perguntas();
		pergunta2.setPergunta("Qual a soma de 2+3: ");
		pergunta2.setAlternativa1("Quatro(4)");
		pergunta2.setAlternativa2("Cinco(5)");
		pergunta2.setAlternativa3("Três(3)");
		pergunta2.setAlternativa4("Zero(0)");
		pergunta2.setResposta("Cinco(5)");
		pergunta2.setDica("Maior que Quatro(4)");
		adicionarLista(pergunta2);

		Perguntas pergunta3 = new Perguntas();
		pergunta3.setPergunta("Qual a soma de 2+1: ");
		pergunta3.setAlternativa1("Quatro(4)");
		pergunta3.setAlternativa2("Cinco(5)");
		pergunta3.setAlternativa3("Três(3)");
		pergunta3.setAlternativa4("Zero(0)");
		pergunta3.setResposta("Três(3)");
		pergunta3.setDica("Menor que Quatro(4)");
		adicionarLista(pergunta3);

		Perguntas pergunta4 = new Perguntas();
		pergunta4.setPergunta("Qual a soma de 2+5: ");
		pergunta4.setAlternativa1("Quatro(4)");
		pergunta4.setAlternativa2("Cinco(5)");
		pergunta4.setAlternativa3("Sete(7)");
		pergunta4.setAlternativa4("Zero(0)");
		pergunta4.setResposta("Sete(7)");
		pergunta4.setDica("Maior que Cinco(5)");
		adicionarLista(pergunta4);

		Perguntas pergunta5 = new Perguntas();
		pergunta5.setPergunta("Qual a soma de 2+4: ");
		pergunta5.setAlternativa1("Quatro(4)");
		pergunta5.setAlternativa2("Cinco(5)");
		pergunta5.setAlternativa3("Três(3)");
		pergunta5.setAlternativa4("Seis(6)");
		pergunta5.setResposta("Seis(6)");
		pergunta5.setDica("Maior que Cinco(5)");
		adicionarLista(pergunta5);

		Perguntas pergunta6 = new Perguntas();
		pergunta6.setPergunta("Qual a soma de 2+0: ");
		pergunta6.setAlternativa1("Dois(2)");
		pergunta6.setAlternativa2("Cinco(5)");
		pergunta6.setAlternativa3("Três(3)");
		pergunta6.setAlternativa4("Seis(6)");
		pergunta6.setResposta("Dois(2)");
		pergunta6.setDica("Menor que Três(3)");
		adicionarLista(pergunta6);

		Perguntas pergunta7 = new Perguntas();
		pergunta7.setPergunta("Qual a soma de 2+4: ");
		pergunta7.setAlternativa1("Quatro(4)");
		pergunta7.setAlternativa2("Cinco(5)");
		pergunta7.setAlternativa3("Três(3)");
		pergunta7.setAlternativa4("Seis(6)");
		pergunta7.setResposta("Seis(6)");
		pergunta7.setDica("Maior que Cinco(5)");
		adicionarLista(pergunta7);

		Perguntas pergunta8 = new Perguntas();
		pergunta8.setPergunta("Qual a soma de 2-1: ");
		pergunta8.setAlternativa1("Quatro(4)");
		pergunta8.setAlternativa2("Um(1)");
		pergunta8.setAlternativa3("Três(3)");
		pergunta8.setAlternativa4("Seis(6)");
		pergunta8.setResposta("Um(1)");
		pergunta8.setDica("Menor que Dois(2)");
		adicionarLista(pergunta8);

		Perguntas pergunta9 = new Perguntas();
		pergunta9.setPergunta("Qual a soma de 2+6: ");
		pergunta9.setAlternativa1("Quatro(4)");
		pergunta9.setAlternativa2("Oito(8)");
		pergunta9.setAlternativa3("Três(3)");
		pergunta9.setAlternativa4("Seis(6)");
		pergunta9.setResposta("Oito(8)");
		pergunta9.setDica("Maior que Seis(6)");
		adicionarLista(pergunta9);

		Perguntas pergunta0 = new Perguntas();
		pergunta0.setPergunta("Qual a soma de 2+7: ");
		pergunta0.setAlternativa1("Quatro(4)");
		pergunta0.setAlternativa2("Cinco(5)");
		pergunta0.setAlternativa3("Três(3)");
		pergunta0.setAlternativa4("Nove(9)");
		pergunta0.setResposta("Nove(9)");
		pergunta0.setDica("Maior que Cinco(5)");
		adicionarLista(pergunta0);
	}

	private void adicionarLista(Perguntas pergunta) {
		listaPerguntas.add(pergunta);
	}

	public String listaPerguntas() {
		String lista = "Listas de Perguntas:\n";
		for (int i = 0; i < listaPerguntas.size(); i++) {
			lista += listaPerguntas.get(i).toString();
		}
		return lista;
	}

	public String buscaPergunta(int sorteioPergunta) {
		String pergunta = "";
		pergunta = "PERGUNTA:\n" + listaPerguntas.get(sorteioPergunta).getPergunta() + "\n1-"
				+ listaPerguntas.get(sorteioPergunta).getAlternativa1() + "\n2-"
				+ listaPerguntas.get(sorteioPergunta).getAlternativa2() + "\n3-"
				+ listaPerguntas.get(sorteioPergunta).getAlternativa3() + "\n4-"
				+ listaPerguntas.get(sorteioPergunta).getAlternativa4()
				+ "\n----------------------------------------------------------" + "\n5-Pular" + "\n6-Dica"
				+ "\n7-Elimar uma alternativa";
		return pergunta;
	}

	public Perguntas buscarPergunta(int sorteioPergunta) {

		return listaPerguntas.get(sorteioPergunta);
	}

	public String verificaResposta(int sorteioPergunta, int resposta) {
		if (resposta == 1) {
			return listaPerguntas.get(sorteioPergunta).getAlternativa1();
		} else if (resposta == 2) {
			return listaPerguntas.get(sorteioPergunta).getAlternativa2();
		} else if (resposta == 3) {
			return listaPerguntas.get(sorteioPergunta).getAlternativa3();
		} else if (resposta == 4) {
			return listaPerguntas.get(sorteioPergunta).getAlternativa4();
		}
		return null;
	}

	public String buscaDica(int sorteioPergunta) {

		return listaPerguntas.get(sorteioPergunta).getDica();
	}

	public String eliminarUma(int sorteioPergunta) {
		Random aleatorio = new Random();
		boolean sair = true;
		int resposta=0;

		if (listaPerguntas.get(sorteioPergunta).getAlternativa1()
				.equals(listaPerguntas.get(sorteioPergunta).getResposta())) {
			resposta = 1;
		}

		if (listaPerguntas.get(sorteioPergunta).getAlternativa2()
				.equals(listaPerguntas.get(sorteioPergunta).getResposta())) {
			resposta = 2;
		}

		if (listaPerguntas.get(sorteioPergunta).getAlternativa3()
				.equals(listaPerguntas.get(sorteioPergunta).getResposta())) {
			resposta = 3;
		}
		if (listaPerguntas.get(sorteioPergunta).getAlternativa4()
				.equals(listaPerguntas.get(sorteioPergunta).getResposta())) {
			resposta = 4;
		}
		while (sair) {
			int valor = aleatorio.nextInt(4) + 1;
			if(valor!=resposta) {
				if(valor==1) {
					return listaPerguntas.get(sorteioPergunta).getAlternativa1();
				}else if(valor==2) {
					return listaPerguntas.get(sorteioPergunta).getAlternativa2();
				}else if(valor==3) {
					return listaPerguntas.get(sorteioPergunta).getAlternativa3();
				}else if(valor==4) {
					return listaPerguntas.get(sorteioPergunta).getAlternativa4();
				}
			}
		}
		return null;
	}

}
