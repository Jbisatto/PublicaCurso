package view;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.AlunoDAO;
import DAO.NotasDAO;
import DAO.ProvasDAO;
import modelo.Aluno;
import modelo.Notas;
import modelo.Provas;

public class Principal {

	public static void main(String[] args) throws HeadlessException, ParseException {

		boolean sair = true;
		String nome;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		while (sair) {

			String[] menupri = { "ADD ALUNO", "ADD PROVA", "ADD NOTAS", "BSC ALUNO", "ALT ALUNO", "ALT PROVA",
					"ALT NOTAS", "RVM ALUNO", "RVM PROVA", "RVM NOTAS", "FINALIZAR" };
			int response = JOptionPane.showOptionDialog(null,
					"Desenvolver um sistema para gerenciar uma escola, esse sistema terá as seguintes funcionalidades:\r\n"
							+ "Cadastrar alunos - Nome, turma, aniversário (dia/mês/ano) e telefone;\r\n"
							+ "Cadastrar prova - Informe o nome da prova e a matéria;\r\n"
							+ "Cadastrar notas - Informe a prova, aluno e a nota;\r\n"
							+ "Selecionar alunos - Peça se deseja selecionar por: nome ou turma, liste os alunos contendo um código/índice, quando selecionado o código, retorne todos os dados do aluno, incluindo suas notas e média de todas as provas;\r\n"
							+ "Alterar alunos;\r\n" + "Alterar provas;\r\n" + "Alterar notas;\r\n"
							+ "Remover alunos;\r\n" + "Remover provas;\r\n" + "Remover notas;\r\n"
							+ "Sair do sistema.\r\n" + "",
					"Escola", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, menupri,
					"None of your business");
			if (response == 0) {
				Aluno aluno = new Aluno();
				AlunoDAO alunoDao = new AlunoDAO();
				aluno.setNome(JOptionPane.showInputDialog("Digite o nome do Aluno:"));
				aluno.setTurma(JOptionPane.showInputDialog("Digite a Turma:"));
				aluno.setDataNascimento(formato.parse(JOptionPane.showInputDialog("Data de nascimento(dd/mm/aaaa):")));
				aluno.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Digite o telefone:")));
				alunoDao.cadastrarAluno(aluno);
			}

			if (response == 1) {
				Provas prova = new Provas();
				ProvasDAO provaDAO = new ProvasDAO();
				prova.setNomeProva(JOptionPane.showInputDialog("Digite o nome da prova:"));
				prova.setMateria(JOptionPane.showInputDialog("Digite a matéria: "));
				provaDAO.cadastrarProva(prova);

			}

			if (response == 2) {
				Notas notas = new Notas();
				NotasDAO notasDAO = new NotasDAO();
				ProvasDAO provasDAO = new ProvasDAO();
				AlunoDAO alunosDAo = new AlunoDAO();

				notas.setId_prova(Integer.parseInt(
						JOptionPane.showInputDialog("Digite o código referente a prova:\n" + provasDAO.listaProvas())));
				notas.setId_aluno(Integer.parseInt(JOptionPane
						.showInputDialog("Digite o código referente ao aluno:\n" + alunosDAo.listaAlunos())));
				notas.setNota(Integer.parseInt(JOptionPane.showInputDialog("Digite a nota da Provas:")));
				notasDAO.cadastrarNotas(notas);
				System.out.println(notasDAO.listaNotas());

			}
			if (response == 3) {
				int alunoTurma = Integer.parseInt(JOptionPane.showInputDialog("Digite para buscar:\n1-Aluno\n2-Turma"));
				nome = JOptionPane.showInputDialog("Digite " + (alunoTurma == 1 ? " o nome do Aluno:" : " a Turma:"));
				Aluno aluno = new Aluno();
				AlunoDAO alunoDAO = new AlunoDAO();
				NotasDAO notas = new NotasDAO();
				String listaAlunos = alunoDAO.listaAlunos(alunoTurma, nome);
				int codigoAluno = Integer.parseInt(JOptionPane.showInputDialog(listaAlunos));
				aluno = alunoDAO.buscarAluno(codigoAluno);
				JOptionPane.showMessageDialog(null, aluno + notas.buscar(codigoAluno));
			}

			if (response == 4) {
				Aluno aluno = new Aluno();
				AlunoDAO alunoDao = new AlunoDAO();
				int alunoTurma = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o código do Aluno que dejesa Alterar:\n" + alunoDao.listaAlunos()));
				aluno = alunoDao.buscarAluno(alunoTurma);
				aluno.setNome(JOptionPane.showInputDialog("Digite o novo nome do Aluno( " + aluno.getNome() + " ):"));
				aluno.setTurma(JOptionPane.showInputDialog("Digite a nova turma:( " + aluno.getTurma() + " ):"));
				aluno.setDataNascimento(
						formato.parse(JOptionPane.showInputDialog("Data a nova de nascimento(dd/mm/aaaa)( "
								+ formato.format(aluno.getDataNascimento()) + " ):")));
				aluno.setTelefone(Integer.parseInt(
						JOptionPane.showInputDialog("Digite o novo nome do Aluno( " + aluno.getTelefone() + " ):")));
				alunoDao.alterar(aluno, alunoTurma);

			}

			if (response == 5) {
				Provas prova = new Provas();
				ProvasDAO provasDao = new ProvasDAO();
				int numeroProva = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o código da Prova que dejesa Alterar:\n" + provasDao.listaProvas()));
				prova = provasDao.buscarProvaInteira(numeroProva);
				prova.setNomeProva(
						JOptionPane.showInputDialog("Digite o novo nome da prova( " + prova.getNomeProva() + "):"));
				prova.setMateria(
						JOptionPane.showInputDialog("Digite o novo nome da Materia( " + prova.getMateria() + "):"));
				provasDao.alterar(prova, numeroProva);
			}

			if (response == 6) {
				NotasDAO notasDAO = new NotasDAO();
				int indexNota = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o codigo da nota que deseja Alterar:\n" + notasDAO.listaNotas()));
				Notas notas = new Notas();
				ProvasDAO provasDAO = new ProvasDAO();
				AlunoDAO alunosDAo = new AlunoDAO();
				notas = notasDAO.buscarNota(indexNota);
				notas.setId_prova(
						Integer.parseInt(JOptionPane.showInputDialog("Digite o novo código referente a prova( "
								+ notas.getId_prova() + " ):\n" + provasDAO.listaProvas())));
				notas.setId_aluno(
						Integer.parseInt(JOptionPane.showInputDialog("Digite o novo código referente ao aluno( "
								+ notas.getId_aluno() + " ):\n" + alunosDAo.listaAlunos())));
				notas.setNota(Integer.parseInt(
						JOptionPane.showInputDialog("Digite a nova nota da Provas( " + notas.getNota() + " ):")));
				notasDAO.alterarNotas(notas, indexNota);

			}

			if (response == 7) {
				Aluno aluno = new Aluno();
				AlunoDAO alunoDao = new AlunoDAO();
				int alunoTurma = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o código do Aluno que dejesa Remover:\n" + alunoDao.listaAlunos()));
				alunoDao.remover(alunoTurma);

			}
			
			if (response == 8) {
				Provas prova = new Provas();
				ProvasDAO provasDao = new ProvasDAO();
				int numeroProva = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o código da Prova que dejesa Remover:\n" + provasDao.listaProvas()));
				provasDao.remover(numeroProva);

			}
			if (response == 9) {
				NotasDAO notasDAO = new NotasDAO();
				int indexNota = Integer.parseInt(JOptionPane
						.showInputDialog("Digite o codigo da nota que deseja Remover:\n" + notasDAO.listaNotas()));
				notasDAO.remove(indexNota);

			}
			if (response == 10 || response == -1) {
				sair = false;
			}
		}

	}

	public boolean cadastrarAluno(Aluno aluno) {
		return true;
	}

}
