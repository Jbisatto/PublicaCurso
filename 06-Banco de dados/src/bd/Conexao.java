package bd;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.plaf.synth.SynthStyleFactory;

public class Conexao {
	
	///Realizar a conexao
	public Connection  conectar() {
		Connection obj =null;
		try {
			obj = DriverManager.getConnection("jdbc:mysql://localhost:3306/projeto", "root", "admin");
			System.out.println("Conexão realizada");
		} catch (Exception e) {
			System.out.println("Falha ao conectar "+ e.getMessage());
		}
		
		return obj;
	}
	
}
