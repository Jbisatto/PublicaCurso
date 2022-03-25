package Singleton;

public class PrincipalSingleton {

	public static void main(String[] args) {
		boolean conexao;
//		ConexaoBanco conexaoBanco = new ConexaoBanco();
//		n�o consegue chamar o construtor pois ele � privato, a pr�pria classe gerencia a sua cri��o
		ConexaoBanco conexaoBanco = ConexaoBanco.getInstance();
		
		conexao =  conexaoBanco.conectar();
		
		System.out.println((conexao)?"Conectado ao Banco":"Desconectado do Banco");
		
		conexao= conexaoBanco.desconectar();
		
		System.out.println((conexao)?"Conectado ao Banco":"Desconectado do Banco");
		
	}

}
