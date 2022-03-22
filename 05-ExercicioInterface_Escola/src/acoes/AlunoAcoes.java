package acoes;

import java.util.List;

import bd.Bd;
import modelo.Aluno;

public class AlunoAcoes implements ICrud<Aluno>{

	@Override
	public void cadastrar(Aluno obj) {
		Bd.listaAluno.add(obj);
		
	}

	@Override
	public List<Aluno> lista() {
		
		return Bd.listaAluno;
	}

	@Override
	public void alterar(Aluno obj, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int index) {
		// TODO Auto-generated method stub
		
	}

	public String nomeAluno(int idAluno) {
		
		return Bd.listaAluno.get(idAluno).getNome();
	}
	public boolean verificarSenha(String login, String senha) {
		for (int i = 0; i < Bd.listaAluno.size(); i++) {
			if(Bd.listaAluno.get(i).getLogin().equals(login)&&
			Bd.listaAluno.get(i).getSenha().equals(senha)){
				return true;
			}
		}
		return false;
	}
	
	public int buscaIdAluno(String login, String senha) {
		for (int i = 0; i <Bd.listaAluno.size(); i++) {
			if(Bd.listaAluno.get(i).getLogin().equals(login)&&
					Bd.listaAluno.get(i).getSenha().equals(senha)){
						return i;
					}

		}
		return -1;
	}
	public Aluno buscarAluno(int index) {
		return Bd.listaAluno.get(index);
	}

}
