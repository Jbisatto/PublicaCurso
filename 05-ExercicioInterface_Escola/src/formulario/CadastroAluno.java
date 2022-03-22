package formulario;

import javax.swing.JOptionPane;

import acoes.AlunoAcoes;
import modelo.Aluno;

public class CadastroAluno {
	
	public static void formCadastrarAluno(int index) {
		Aluno aluno = new Aluno();
		AlunoAcoes alunoAcoes = new AlunoAcoes();
		try {

			aluno= alunoAcoes.buscarAluno(index);
			aluno.setNome(JOptionPane.showInputDialog("Digite o novo nome( "+aluno.getNome()+" ):"));
			aluno.setSexo(JOptionPane.showInputDialog("Digite o sexo(M/F) ( "+aluno.getSexo()+" ):").charAt(0));
			aluno.setLogin(JOptionPane.showInputDialog("Digite o novo login( "+aluno.getLogin()+" ):"));
			aluno.setSenha(JOptionPane.showInputDialog("Digite a nova Senha( "+aluno.getSenha()+" ):"));	
			alunoAcoes.alterar(aluno, index);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Informação incorreta");
		}
	}

}
