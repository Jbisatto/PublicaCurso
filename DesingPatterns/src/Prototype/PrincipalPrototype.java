package Prototype;

public class PrincipalPrototype {

	public static void main(String[] args) {
		
		RegistroDocumento restritoDocumento =  new RegistroDocumento();
		
		
		//Pega Prototipo de Pdf com Segurança Publica
		Documento contratoVendas = restritoDocumento.getDocumento("PdfPublico");
		
		System.out.println(contratoVendas);
		
		contratoVendas.setNome("Contrato de Vendas");
		
		System.out.println(contratoVendas);
		
		
		//Pega Prototipo de Pdf com Segurança Publica
		Documento contratoAluguel = restritoDocumento.getDocumento("PdfPublico");
		
		System.out.println(contratoAluguel);
		
		contratoAluguel.setNome("Contrato de Aluguel");
		
		System.out.println(contratoAluguel);
		
	}

}
