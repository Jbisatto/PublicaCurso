package acoes;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import bd.Bd;
import modelo.Prova;

public class ProvaAcao implements ICrud<Prova> {

	@Override
	public void cadastrar(Prova obj) {
		Bd.listaProva.add(obj);
		
	}


	
	public DefaultTableModel listar() {

		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Código");
		dtm.addColumn("Nome da Prova");

		for (int i = 0; i < Bd.listaProva.size(); i++) {
			dtm.addRow(new Object[] { i,Bd.listaProva.get(i).getNomeProva()});
		}
		return dtm;
	}

	@Override
	public void alterar(Prova obj, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int index) {
		Bd.listaProva.remove(index);
		
	}
	

	@Override
	public List<Prova> lista() {
		return Bd.listaProva;
	}
	
	public String nomeProva(int index) {
		return Bd.listaProva.get(index).getNomeProva();
	}



	public boolean verificaTabela() {
		return (Bd.listaProva.size()==0)?false:true;
	}

}
