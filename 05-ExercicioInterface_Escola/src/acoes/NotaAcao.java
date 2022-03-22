package acoes;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import bd.Bd;
import modelo.Nota;

public class NotaAcao implements ICrud<Nota> {

	@Override
	public void cadastrar(Nota obj) {
		Bd.listaNota.add(obj);

	}

	@Override
	public List<Nota> lista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Nota obj, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(int index) {
		// TODO Auto-generated method stub

	}

	public DefaultTableModel listar(int numero) {
		AlunoAcoes alunoAcoes = new AlunoAcoes();
		ProvaAcao provaAcao = new ProvaAcao();
		DefaultTableModel dtm = new DefaultTableModel();
		String nomeAluno, nomeProva = provaAcao.nomeProva(numero);
		dtm.addColumn("Prova");
		dtm.addColumn("Aluno");
		dtm.addColumn("Nota");

		for (int i = 0; i < Bd.listaNota.size(); i++) {
			if (Bd.listaNota.get(i).getIdProva() == numero) {
				nomeAluno = alunoAcoes.nomeAluno(Bd.listaNota.get(i).getIdAluno());
				dtm.addRow(new Object[] { nomeProva, nomeAluno, Bd.listaNota.get(i).getNota() });
			}

		}
		return dtm;
	}
	public DefaultTableModel listarTodasProva(int index) {
		ProvaAcao provaAcao = new ProvaAcao();
		DefaultTableModel dtm = new DefaultTableModel();
		String nomeProva;
		dtm.addColumn("Prova");
		dtm.addColumn("Nota");
		for (int i = 0; i < Bd.listaNota.size(); i++) {
			if (Bd.listaNota.get(i).getIdAluno() == index) {
				nomeProva = provaAcao.nomeProva(Bd.listaNota.get(i).getIdProva());
				dtm.addRow(new Object[] { nomeProva,Bd.listaNota.get(i).getNota() });
			}

		}
		return dtm;
	}
	
	

	public boolean verificaTabela() {
		return (Bd.listaNota.size()==0)?false:true;
}

	public boolean verificaNotaCad(Nota nota) {
		for (int i = 0; i < Bd.listaNota.size(); i++) {
			if(Bd.listaNota.get(i).getIdProva()==nota.getIdProva()&&
				Bd.listaNota.get(i).getIdAluno()==nota.getIdAluno()){
					return true;
				}
			
		}
		return false;
	}

}
