package DAO;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Aluno;

public class AlunoDAO {

	static ArrayList<Aluno> listaPessoas = new ArrayList<>();

	public void cadastrarAluno(Aluno aluno) {
		listaPessoas.add(aluno);
	}

	public String listaAlunos() {
		String lista = "Lista de Alunos:\n";
		for (int i = 0; i < listaPessoas.size(); i++) {
			lista += "Codigo Aluno: " + i + " Nome: " + listaPessoas.get(i).getNome() + "\n";
		}

		return lista;
	}

	public String listaAlunos(int alunoTurma, String nome) {
		String lista = "";
		if (alunoTurma == 1) {
			for (int i = 0; i < listaPessoas.size(); i++) {
				if (listaPessoas.get(i).getNome().contains(nome)) {
					lista += "Código: " + i + ", Nome: " + listaPessoas.get(i).getNome() + "\n";
				}
			}
		} else if (alunoTurma == 2) {
			for (int i = 0; i < listaPessoas.size(); i++) {
				if (listaPessoas.get(i).getTurma().equals(nome)) {
					lista += "Código: " + i + ", Nome: " + listaPessoas.get(i).getNome() + "\n";
				}
			}
		} else {
			lista += "Informação Incorreta";
		}

		return lista;
	}

	public Aluno buscarAluno(int codigoAluno) {
		Aluno aluno = new Aluno();
		aluno.setNome(listaPessoas.get(codigoAluno).getNome());
		aluno.setTelefone(listaPessoas.get(codigoAluno).getTelefone());
		aluno.setTurma(listaPessoas.get(codigoAluno).getTurma());
		aluno.setDataNascimento(listaPessoas.get(codigoAluno).getDataNascimento());

		return aluno;
	}

	public void alterar(Aluno aluno, int alunoTurma) {
		listaPessoas.set(alunoTurma, aluno);
		
	}

	public void remover(int alunoTurma) {
		NotasDAO notasDAO = new NotasDAO();
		boolean tem = notasDAO.existeAluno(alunoTurma);
		if(!tem) {
		listaPessoas.remove(alunoTurma);
		}else {
			JOptionPane.showMessageDialog(null, "Impossivel remover Aluno, remova antes todas a notas referente a ele!!!");
		}
	}



}
