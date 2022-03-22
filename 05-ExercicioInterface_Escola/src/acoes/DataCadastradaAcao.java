package acoes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import bd.Bd;

public class DataCadastradaAcao implements ICrud<Date> {

	@Override
	public void cadastrar(Date obj) {
		Bd.listaData.add(obj);
		
	}

	@Override
	public List<Date> lista() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void alterar(Date obj, int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int index) {
		// TODO Auto-generated method stub
		
	}

	public DefaultTableModel listarPorData(int i) {
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			DefaultTableModel dtm = new DefaultTableModel();
			String presenca="";
			dtm.addColumn("Aluno");
			dtm.addColumn(formatter.format(Bd.listaData.get(i)));
			for (int j = 0; j < Bd.listaAluno.size(); j++) {
				for (int k = 0; k < Bd.listaChamada.size(); k++) {
					if(Bd.listaChamada.get(k).getId_aluno()==j&&
							Bd.listaChamada.get(k).getData().equals(Bd.listaData.get(i))) {
						presenca=(Bd.listaChamada.get(k).isPresenca())?"Presente":"Faltou";
						dtm.addRow(new Object[] { Bd.listaAluno.get(j).getNome(),
								presenca  });
					}
				}
				
			}

			return dtm;
		}

}
