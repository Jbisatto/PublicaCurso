package DAO;

import java.util.ArrayList;

import modelo.Aluno;
import modelo.Notas;
import modelo.Provas;

public class NotasDAO {

	static ArrayList<Notas> listaNotas = new ArrayList<>();

	public void cadastrarNotas(Notas notas) {
		listaNotas.add(notas);
	}

	public String listaNotas() {
		String lista = "Lista de Notas:\n";
		Aluno aluno = new Aluno();
		AlunoDAO alunoDao = new AlunoDAO();
		Provas prova = new Provas();
		ProvasDAO provaDAO = new ProvasDAO();

		for (int i = 0; i < listaNotas.size(); i++) {
			aluno = alunoDao.buscarAluno(listaNotas.get(i).getId_aluno());
			prova = provaDAO.buscarProvaInteira(listaNotas.get(i).getId_prova());
			lista += "Codigo da Nota: " + i + " ,Nome da Prova: " + prova.getNomeProva() + " , Nome aluno: "
					+ aluno.getNome() + " Nota: " + listaNotas.get(i).getNota() + "\n";
		}

		return lista;
	}

	public String buscar(int codigoAluno) {
		String lista = "Provas:\n";
		ProvasDAO provasDAO = new ProvasDAO();
		double somaNotas = 0;
		int qtdNotas = 0;
		for (int i = 0; i < listaNotas.size(); i++) {
			if (listaNotas.get(i).getId_aluno() == codigoAluno) {
				lista += "Nome da Prova: " + provasDAO.buscarProva(listaNotas.get(i).getId_prova()) + ", nota: "
						+ listaNotas.get(i).getNota() + "\n";
				somaNotas += listaNotas.get(i).getNota();
				qtdNotas++;
			}
		}
		lista += "Média: " + (somaNotas / qtdNotas);

		return lista;
	}

	public void alterarNotas(Notas notas, int indexNota) {
		listaNotas.set(indexNota, notas);

	}

	public Notas buscarNota(int indexNota) {

		return listaNotas.get(indexNota);
	}

	public void remove(int indexNota) {
		listaNotas.remove(indexNota);

	}

	public boolean existeAluno(int alunoTurma) {
		for (int i = 0; i < listaNotas.size(); i++) {
			if(listaNotas.get(i).getId_aluno()==alunoTurma) {
				return true;
			}
		}
		return false;
	}

}
