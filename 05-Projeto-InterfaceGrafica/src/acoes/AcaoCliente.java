package acoes;

import javax.swing.table.DefaultTableModel;

import db.dados;
import modelo.Cliente;

public class AcaoCliente {

	// Cadastro
	public static void cadastrar(Cliente cliente) {
		dados.listaCLiente.add(cliente);
	}

	// Lista de Cliente
	public static DefaultTableModel listar() {

		DefaultTableModel dtm = new DefaultTableModel();
		dtm.addColumn("Nome");
		dtm.addColumn("Email");
		dtm.addColumn("Cidade");
		for (int i = 0; i < dados.listaCLiente.size(); i++) {
			dtm.addRow(new Object[] { 
					dados.listaCLiente.get(i).getNome(),
					dados.listaCLiente.get(i).getEmail(),
					dados.listaCLiente.get(i).getCidade() });
		}
		return dtm;
	}
}
