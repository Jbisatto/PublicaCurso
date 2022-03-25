package Singleton;

public class PrincipalSingleton {

	public static void main(String[] args) {
		boolean conexao;
//		ConexaoBanco conexaoBanco = new ConexaoBanco();
//		não consegue chamar o construtor pois ele é privato, a própria classe gerencia a sua crição
		ConexaoBanco conexaoBanco = ConexaoBanco.getInstance();
		
		conexao =  conexaoBanco.conectar();
		
		System.out.println((conexao)?"Conectado ao Banco":"Desconectado do Banco");
		
		conexao= conexaoBanco.desconectar();
		
		System.out.println((conexao)?"Conectado ao Banco":"Desconectado do Banco");
		
	}

}
