package exercicio01;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Agenda {

	public static void main(String[] args) {

		boolean sair = true;
		String nomeBusca;
//		Nome, idade, e-mail, telefone e cidade
		ArrayList<String> nome = new ArrayList<String>();
		ArrayList<Integer> idade = new ArrayList<Integer>();
		ArrayList<String> email = new ArrayList<String>();
		ArrayList<String> telefone = new ArrayList<String>();
		ArrayList<String> cidade = new ArrayList<String>();

		while (sair) {
			String[] menupri = { "CADASTRAR", "LISTAR", "BUSCAR", "ALTERAR", "REMOVER", "FINALIZAR" };
			int response = JOptionPane.showOptionDialog(null, "Criar uma agenda com as seguintes funcionalidades:\r\n"
					+ "Cadastrar - Nome, idade, e-mail, telefone e cidade (cada informação em um ArrayList);\r\n"
					+ "Listar - Exibir os dados de todos os contados;\r\n"
					+ "Pesquisar - Informe o nome do contato e retorne os dados de todos os contatos com aquele nome;\r\n"
					+ "Alterar - Pesquise pelo nome do contato, em seguida informe o nome, idade, e-mail, telefone e cidade para realizarmos a alteração.\n Tome cuidado caso haja contatos repetidos, se houver deverá aparecer uma lista com os contatos de mesmo nome para realizar a alteração;\r\n"
					+ "Remover - Através do nome do contato, será excluído o registo do ArrayList, caso haja contatos de mesmo nome,\n o usuário terá que selecionar qual o contato deseja remover;\r\n"
					+ "Sair - Finaliza o sistema.\r\n" + "", "AGENDA", JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, menupri, "None of your business");
			if (response == 0) {
				nome.add(JOptionPane.showInputDialog("Informe o nome"));
				idade.add(Integer.parseInt(JOptionPane.showInputDialog("Informe a idade")));
				email.add(JOptionPane.showInputDialog("Informe o e-mail"));
				telefone.add(JOptionPane.showInputDialog("Informe o Telefone"));
				cidade.add(JOptionPane.showInputDialog("Informe a cidade"));

				System.out.println("Adicionar");
			}
			if (response == 1) {
				String lista = "LISTA\n";
				for (int i = 0; i < nome.size(); i++) {
					lista += nome.get(i) + " -- " + idade.get(i) + " -- " + email.get(i) + " -- " + telefone.get(i)
							+ " -- " + cidade.get(i) + "\n";
				}
				JOptionPane.showMessageDialog(null, lista);

				System.out.println("listar");
			}
			if (response == 2) {
				String lista = "LISTA\n";
				nomeBusca = JOptionPane.showInputDialog("Informe o nome do aluno para buscar");
				for (int i = 0; i < nome.size(); i++) {
					if (nome.get(i).contains(nomeBusca)) {
						lista += nome.get(i) + " -- " + idade.get(i) + " -- " + email.get(i) + " -- " + telefone.get(i)
								+ " -- " + cidade.get(i) + "\n";
					}
				}
				JOptionPane.showMessageDialog(null, lista);

				System.out.println("listar");
			}
			if (response == 3) {
				nomeBusca = JOptionPane.showInputDialog("Informe o nome que deseja editar");
				for (int i = 0; i < nome.size(); i++) {
					if (nome.get(i).equals(nomeBusca)) {
						nome.set(i, JOptionPane.showInputDialog("Informe o novo nome( " + nome.get(i) + " )"));
						idade.set(i, Integer.parseInt(JOptionPane.showInputDialog("Informe a nova idade")));
						email.set(i, JOptionPane.showInputDialog("Informe o novo e-mail"));
						telefone.set(i, JOptionPane.showInputDialog("Informe o novo Telefone"));
						cidade.set(i, JOptionPane.showInputDialog("Informe a nova cidade"));
						JOptionPane.showMessageDialog(null, "Pessoa Alterado!!!");
					}
				}
				System.out.println("alterar");
			}
			if (response == 4) {
				String lista = "Possui mais de uma Pessoa com mesmo nome\n";
				int contadorRevomer = 0,numeroRemove=0;
				nomeBusca = JOptionPane.showInputDialog("Digite o nome que deseja Remover");
				for (int i = 0; i < nome.size(); i++) {
					if (nome.get(i).equals(nomeBusca)) {
						lista += nome.get(i) + " -- " + idade.get(i) + " -- " + email.get(i) + " -- " + telefone.get(i)
								+ " -- " + cidade.get(i) + " Digite :" + i + "\n";
						contadorRevomer++;
						numeroRemove=i;
					}
				}
				if (contadorRevomer > 1) {
					numeroRemove=Integer.parseInt(JOptionPane.showInputDialog(lista));
				}
				if(contadorRevomer>0) {
					nome.remove(numeroRemove);
					idade.remove(numeroRemove);
					email.remove(numeroRemove);
					telefone.remove(numeroRemove);
					cidade.remove(numeroRemove);
					JOptionPane.showMessageDialog(null, "Pessoa removida com sucesso!!!");
				}
				System.out.println(numeroRemove);
				System.out.println("remover");
			}
			for (int i = 0; i < nome.size(); i++) {
				System.out.println(nome.get(i) + " " + idade.get(i) + " " + email.get(i) + " " + telefone.get(i) + " "
						+ cidade.get(i));
			}
			if (response == 5) {
				System.out.println("finalizar");
				sair = false;
			}

		}

	}

}
