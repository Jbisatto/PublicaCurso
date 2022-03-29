package formulario;

import java.sql.SQLException;

import dao.AcoesSql;

public class Principal {

	public static void main(String[] args) throws SQLException {
		
//		AcoesSql.cadastrarMarca("Nitendo");
		AcoesSql.selecionar();
		
	}

}
