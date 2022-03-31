package formulario;

import acoes.AlunoAcoes;
import modelo.Aluno;

public class Principal {

	public static void main(String[] args) {
		Aluno a = new Aluno("Jefferson Bisatto",8, 9,'m','m');
		AlunoAcoes.cadastrar(a);
		

	}

}
