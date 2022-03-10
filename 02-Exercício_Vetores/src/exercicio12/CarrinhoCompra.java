package exercicio12;

import javax.swing.JOptionPane;

public class CarrinhoCompra {

	public static void main(String[] args) {
		String listaCarrinho="\nCARRINHO:";
		boolean parar=true;
		String nome;
		int qtdProduto=0,contador=0;
		String[][] produtos = new String[30][3];
		String[][] carrinho = new String[30][3];
		produtos[0][0]="Tv";produtos[0][1]="10";produtos[0][2]="500";
		produtos[1][0]="Celular";produtos[1][1]="15";produtos[1][2]="1500";
		produtos[2][0]="Cama";produtos[2][1]="4";produtos[2][2]="800";
		produtos[3][0]="Mesa";produtos[3][1]="14";produtos[3][2]="200";
		produtos[4][0]="Geladeira";produtos[4][1]="5";produtos[4][2]="2500";
		produtos[5][0]="Fogão";produtos[5][1]="3";produtos[5][2]="900";
		produtos[6][0]="Maquina Lavar";produtos[6][1]="6";produtos[6][2]="1500";
		produtos[7][0]="Liquidificador";produtos[7][1]="10";produtos[7][2]="500";
		produtos[8][0]="Cafeteira";produtos[8][1]="20";produtos[8][2]="100";
		produtos[9][0]="Microondas";produtos[9][1]="0";produtos[9][2]="400";
		produtos[10][0]="Forno Elétrico";produtos[10][1]="5";produtos[10][2]="500";
		
		
		while(parar) {
		String lista="";
		
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i][0] != null) {
				int qtd=Integer.parseInt(produtos[i][1]);
				if(qtd!=0) {
					lista += "Produto: " + produtos[i][0] + ", Quantidade: " + produtos[i][1] + ", Valor: R$"
					+ produtos[i][2] + "\n";

				}
			}
		}	
		
		String[] menupri = { "ADD CARRINHO", "FINALIZAR" };
		int response = JOptionPane
		.showOptionDialog(null,lista+listaCarrinho,"Produtos", JOptionPane.YES_NO_OPTION
				, JOptionPane.PLAIN_MESSAGE, null, menupri, "None of your business");
		System.out.println(response);
		if(response==1) {
			int total=0;
			for (int i = 0; i < carrinho.length; i++) {
				if(carrinho[i][0]!=null) {
					total+=(Integer.parseInt(carrinho[i][2])*Integer.parseInt(carrinho[i][1]));
				}
			}
			JOptionPane.showMessageDialog(null, listaCarrinho+"\nTotal: "+Integer.toString(total));
			
				parar=false;
		}else {
			
			nome=JOptionPane.showInputDialog("Informe o nome do produto");
				for (int i = 0; i < produtos.length; i++) {
					if (produtos[i][0]!=null&&produtos[i][0].equals(nome)) {
						qtdProduto=Integer.parseInt(JOptionPane.showInputDialog("Quantidade"));
						int qtd=Integer.parseInt(produtos[i][1]);
						if(qtd!=0&&qtd>=qtdProduto) {
							carrinho[contador][0]=nome;
							carrinho[contador][1]= Integer.toString(qtdProduto);
							carrinho[contador][2]=produtos[i][2];
							produtos[i][1]=  Integer.toString(qtd-qtdProduto);
							listaCarrinho += "\nProduto: " + carrinho[contador][0] + ", Quantidade: " + carrinho[contador][1] + ", Valor: R$"
									+ carrinho[contador][2];
							contador++;
						}
					}
				
				}	
			}
		
		}

		
	}

}
