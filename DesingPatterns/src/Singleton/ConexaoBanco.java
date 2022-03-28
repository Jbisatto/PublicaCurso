package Singleton;


public class ConexaoBanco {
	private static ConexaoBanco conexaoBanco;
	private boolean conexao;
//	private String driver = "com.mysql.cj.jdbc.Driver";
//	private String url = "jdbc:mysql://localhost:3306/dbagenda?useTimezone=true&serverTimezone=UTC";
//	private String user = "root";
//	private String passorwd = "bisatto";
	
	
	
	public static synchronized ConexaoBanco getInstance() {
		if (conexaoBanco == null)
			conexaoBanco = new ConexaoBanco();

		return conexaoBanco;
	}
	
	private  ConexaoBanco() {

	}
	
	public Boolean conectar() {
		conexao=true;
		return this.conexao;
	}
	
	public boolean desconectar() {
		conexao=false;
		return conexao;
	}
}
