package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import acoes.AlunoAcoes;
import modelo.Aluno;
import validador.Arrendondador;

public class AlunoService {

	public DefaultTableModel listarAlunos() throws SQLException {
		double media;
		List<Aluno> listaAluno = new ArrayList<Aluno>();
		listaAluno = AlunoAcoes.selecionar();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Código");
		dtm.addColumn("Aluno");
		dtm.addColumn("Nota 1");
		dtm.addColumn("Nota 2");
		dtm.addColumn("Média");
		dtm.addColumn("Situação");
		dtm.addColumn("Turno");
		dtm.addColumn("Gênero");
		for (int i = 0; i < listaAluno.size(); i++) {
			media = (listaAluno.get(i).getN1() + listaAluno.get(i).getN2()) / 2;
			dtm.addRow(new Object[] { listaAluno.get(i).getCodigo(), listaAluno.get(i).getNomeAluno(),
					listaAluno.get(i).getN1(), listaAluno.get(i).getN2(), Arrendondador.a(media),
					(media < 7) ? "Reprovado" : "Aprovado",
					(listaAluno.get(i).getTurno() == 'M') ? "Matutino"
							: (listaAluno.get(i).getTurno() == 'V') ? "Vespertino" : "Noturno",
					(listaAluno.get(i).getGenero() == 'M') ? "Masculino" : "Feminino" });
		}

		return dtm;
	}

//	- Quantidade de alunos aprovados;
//	- Quantidade de alunos reprovados;
//	- Quantidade de homens e mulheres;
//	- Quantidade de alunos por turno;
//	- Quantidade de alunos cadastrados.
	public String estatisticas() {
		double media;
		List<Aluno> listaAluno = new ArrayList<Aluno>();
		listaAluno = AlunoAcoes.selecionar();
		int qtdAprovados = 0, qtdReprovados = 0, qtdMasc = 0, qtdFem = 0, qtdMat = 0, qtdVesp = 0, qtdNot = 0,
				qtdAlunos=listaAluno.size();
		for (int i = 0; i < listaAluno.size(); i++) {
			media = (listaAluno.get(i).getN1() + listaAluno.get(i).getN2()) / 2;
			if(media<7) {qtdReprovados++;}else{qtdAprovados++;};
			if(listaAluno.get(i).getGenero() == 'M') {qtdMasc++;}else {qtdFem++;};
			if(listaAluno.get(i).getTurno() == 'M') {qtdMat++;}else
				if(listaAluno.get(i).getTurno() == 'V') {qtdVesp++;}else {
					qtdNot++;
				}
		}

		return "ESTATÍSTICAS \n"
				+ "\nQuantidade de alunos aprovados: "+qtdAprovados
				+ "\n\nQuantidade de alunos reprovados: "+qtdReprovados
				+ "\n\nQuantidade de Homens: "+qtdMasc+" -- Mulheres: "+qtdFem
				+ "\n\nQuantidade de alunos por turno:"
				+ "\nMatutino: "+qtdMat+" -- Vespertino: "+qtdVesp+" -- Noturno: "+qtdNot
				+ "\n\nTotal de alunos: "+qtdAlunos;
	}
}
