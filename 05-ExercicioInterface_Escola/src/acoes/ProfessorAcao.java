package acoes;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import bd.Bd;

public class ProfessorAcao {

	public DefaultTableModel listarMediaProva() {
		DefaultTableModel dtm = new DefaultTableModel();
		double totalNotas, media;
		int qtdNotas;
		String nomeProva;
		dtm.addColumn("Prova");
		dtm.addColumn("Média");

		for (int i = 0; i < Bd.listaProva.size(); i++) {
			totalNotas = 0;
			qtdNotas = 0;
			nomeProva = Bd.listaProva.get(i).getNomeProva();
			for (int j = 0; j < Bd.listaNota.size(); j++) {
				if (Bd.listaNota.get(j).getIdProva() == i) {
					totalNotas += Bd.listaNota.get(j).getNota();
					qtdNotas++;
				}
			}
			media = totalNotas / qtdNotas;
			dtm.addRow(new Object[] { nomeProva, media });
		}
		return dtm;
	}

	public DefaultTableModel listarQtdMF() {
		DefaultTableModel dtm = new DefaultTableModel();
		int qtdMasc = 0, qtdFemi = 0;
		dtm.addColumn("Sexo");
		dtm.addColumn("Quantidade");

		for (int i = 0; i < Bd.listaAluno.size(); i++) {
			if (Bd.listaAluno.get(i).getSexo() == 'M') {
				qtdMasc++;
			} else {
				qtdFemi++;
			}

		}
		dtm.addRow(new Object[] { "Masculino", qtdMasc });
		dtm.addRow(new Object[] { "Feminino", qtdFemi });
		return dtm;
	}

	public DefaultTableModel listarMaiorSete() {
		DefaultTableModel dtm = new DefaultTableModel();
		int qtdMaior = 0, qtdNotaAluno = 0;
		double notas = 0;
		dtm.addColumn("Quantidade de Alunos Média maior que 7");
		dtm.addColumn("Percentual");

		for (int i = 0; i < Bd.listaAluno.size(); i++) {
			notas = 0;
			qtdNotaAluno = 0;
			for (int j = 0; j < Bd.listaNota.size(); j++) {
				if (Bd.listaNota.get(j).getIdAluno() == i) {
					notas += Bd.listaNota.get(j).getNota();
					qtdNotaAluno++;
				}
			}
			if (notas / qtdNotaAluno >= 7) {
				qtdMaior++;
			}

		}
		dtm.addRow(new Object[] { qtdMaior, (100 * qtdMaior) / Bd.listaAluno.size() });
		return dtm;
	}

	public DefaultTableModel listarMenorSete() {
		DefaultTableModel dtm = new DefaultTableModel();
		int qtdMaior = 0, qtdNotaAluno = 0;
		double notas = 0;
		dtm.addColumn("Quantidade de Alunos Média menor que 7");
		dtm.addColumn("Percentual");

		for (int i = 0; i < Bd.listaAluno.size(); i++) {
			notas = 0;
			qtdNotaAluno = 0;
			for (int j = 0; j < Bd.listaNota.size(); j++) {
				if (Bd.listaNota.get(j).getIdAluno() == i) {
					notas += Bd.listaNota.get(j).getNota();
					qtdNotaAluno++;
				}
			}
			if (notas / qtdNotaAluno < 7) {
				qtdMaior++;
			}

		}
		dtm.addRow(new Object[] { qtdMaior, (100 * qtdMaior) / Bd.listaAluno.size() });
		return dtm;
	}

	public void camadas() {

	}

	public DefaultTableModel listaChamadas() {
		AlunoAcoes alunoAcoes = new AlunoAcoes();
		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Alunos");
		dtm.addColumn("Presença");

		for (int i = 0; i < Bd.listaAluno.size(); i++) {
			dtm.addRow(new Object[] {Bd.listaAluno.get(i).getNome(), false });
		}

		return dtm;

	}
}
