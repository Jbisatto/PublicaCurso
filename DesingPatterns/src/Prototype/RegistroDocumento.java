package Prototype;

import java.util.HashMap;
import java.util.Map;

final class RegistroDocumento {
	
	private static final Map<String,Documento> listaPrototipoDocumento = new HashMap<>();
		
	static {
		Documento documentoPdfPublico = new Documento();
		documentoPdfPublico.setTipo("PDF");
		documentoPdfPublico.setSeguranca("Publico");
		listaPrototipoDocumento.put("PdfPublico",documentoPdfPublico);
		
		Documento documentoPdfRestrito = new Documento();
		documentoPdfRestrito.setTipo("PDF");
		documentoPdfRestrito.setSeguranca("Restrito");
		listaPrototipoDocumento.put("PdfRestrito",documentoPdfRestrito);
		
		Documento documentoDocPublico = new Documento();
		documentoDocPublico.setTipo("Doc");
		documentoDocPublico.setSeguranca("Publico");
		listaPrototipoDocumento.put("DocPublico",documentoDocPublico);
		
		Documento documentoDocRestrito = new Documento();
		documentoDocRestrito.setTipo("DOC");
		documentoDocRestrito.setSeguranca("Restrito");
		listaPrototipoDocumento.put("DocRestrito",documentoDocRestrito);
		
	}
	
	public Documento getDocumento(String chave) {
		try {
			return listaPrototipoDocumento.get(chave).clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	

}
