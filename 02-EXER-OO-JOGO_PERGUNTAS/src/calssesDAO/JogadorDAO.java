package calssesDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import modelo.Jogador;
public class JogadorDAO {

	public static ArrayList<Jogador> listaJogador = new ArrayList<>();

	public void salvar(Jogador jogador) {
		listaJogador.add(jogador);
		
	}

	public String buscarTodos() {
		String lista="Lista de Jogadores:\n";
		for (int i = 0; i < listaJogador.size(); i++) {
			String data = new SimpleDateFormat("dd/MM/yyyy").format(listaJogador.get(i).getHora());
			String hora = new SimpleDateFormat("HH:mm:ss").format(listaJogador.get(i).getHora());
			lista+="Nome: "+listaJogador.get(i).getNomeJogador()+
					" Acertos: "+listaJogador.get(i).getQtdAcertos()+
					" Erros: "+listaJogador.get(i).getQtdErros()+
					"Data: "+data+" Hora: "+hora;
		}

		return null;
	}
}
