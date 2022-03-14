package DAO;

import java.util.ArrayList;

import modelo.Provas;

public class ProvasDAO {

	static ArrayList<Provas> listaProvas = new ArrayList<>();

	public void cadastrarProva(Provas prova) {
		listaProvas.add(prova);
	}

	public String listaProvas() {
		String lista = "Lista de Provas:\n";
		for (int i = 0; i < listaProvas.size(); i++) {
			lista += "Codigo da Prova: " + i + " Nome: " + listaProvas.get(i).getNomeProva() + "\n";
		}

		return lista;
	}

	public String buscarProva(int id_prova) {

		return listaProvas.get(id_prova).getNomeProva();
	}

	public Provas buscarProvaInteira(int numeroProva) {
		Provas prova = new Provas();

		return prova = listaProvas.get(numeroProva);
	}

	public void alterar(Provas prova, int numeroProva) {
	
		listaProvas.set(numeroProva, prova);
		
	}

	public void remover(int numeroProva) {
		listaProvas.remove(numeroProva);
		
	}
}
