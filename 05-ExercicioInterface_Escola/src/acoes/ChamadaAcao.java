package acoes;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import bd.Bd;
import modelo.Chamada;

public class ChamadaAcao implements ICrud<Chamada> {

	@Override
	public void cadastrar(Chamada obj) {
		Bd.listaChamada.add(obj);

	}

	@Override
	public List<Chamada> lista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Chamada obj, int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(int index) {
		// TODO Auto-generated method stub

	}

	public DefaultTableModel listarChamadas() {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		DefaultTableModel dtm = new DefaultTableModel();
		Object[] columnNamesObjects= new Object[Bd.listaData.size()+1];
		columnNamesObjects[0]="Alunos";
		for (int i = 1; i < columnNamesObjects.length; i++) {
			columnNamesObjects[i]=formatter.format(Bd.listaData.get(i-1).getTime());
		}
			dtm.addColumn(columnNamesObjects, columnNamesObjects);
			dtm.addColumn(columnNamesObjects);
		
		for (int i = 0; i < Bd.listaAluno.size(); i++) {

			dtm.addRow(new Object[] { Bd.listaAluno.get(i).getNome(), false });

		}
		return dtm;
	}

}
