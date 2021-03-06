package exercicio11;

import javax.swing.JOptionPane;

public class ProdutoCRUD {

	public static void main(String[] args) {

		boolean parar = true;
		String nome, valor, marca;
		int numero = 0, contador = 0, remover = 0;
		String[][] produtos = new String[50][3];
		String menu = "1-Cadastrar\n2-Listar\n3-Alterar\n4-Remover\n5-Sair";

		do {
			numero = Integer.parseInt(JOptionPane.showInputDialog(menu));
			if (numero == 5) {
				parar = false;
			} else if (numero == 1) {
				nome = JOptionPane.showInputDialog("Digite o nome do Produto");
				valor = JOptionPane.showInputDialog("Digite o valor do Produto");
				marca = JOptionPane.showInputDialog("Digite a marca do Produto");
				produtos[contador][0] = nome;
				produtos[contador][1] = valor;
				produtos[contador][2] = marca;
				contador++;
				JOptionPane.showMessageDialog(null, "Produto Cadastrado!!!");
			} else if (numero == 2) {
				String lista = "Lista de Produtos:\n";
				for (int i = 0; i < contador; i++) {
					if (produtos[i][0] != null) {
						lista += "Produto: " + produtos[i][0] + ", Valor: R$" + produtos[i][1] + ", Marca: "
								+ produtos[i][2] + "\n";
					}
				}
				JOptionPane.showMessageDialog(null, lista);
			} else if (numero == 3) {
				nome = JOptionPane.showInputDialog("Digite o nome do Produto que deseja Alterar");
				for (int i = 0; i < contador; i++) {
					if (produtos[i][0].equals(nome)) {
						nome = JOptionPane.showInputDialog("Digite o nome do Produto");
						valor = JOptionPane.showInputDialog("Digite o valor do Produto");
						marca = JOptionPane.showInputDialog("Digite a marca do Produto");
						produtos[i][0] = nome;
						produtos[i][1] = valor;
						produtos[i][2] = marca;
						JOptionPane.showMessageDialog(null, "Produto Alterado!!!");
					}
				}
			} else if (numero == 4) {
				nome = JOptionPane.showInputDialog("Digite o nome do Produto que deseja Remover");
				for (int i = 0; i < contador; i++) {
					if (produtos[i][0].equals(nome)) {
						remover = Integer.parseInt(JOptionPane.showInputDialog("Deseja mesmo remover o produto:\n "
								+ produtos[i][0] + ", Valor: R$" + produtos[i][1] + ", Marca: " + produtos[i][2]
								+ "\n(Digite 1 para confirmar ou 0 para cancelar)"));
						if (remover == 1) {
							produtos[i][0] = null;
							produtos[i][1] = null;
							produtos[i][2] = null;
						}

					}
				}

			}
		} while (parar);

	}

}
