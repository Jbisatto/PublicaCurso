package exercicio02;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CrudAlunos {

	public static void main(String[] args) {

		boolean sair = true;
		String nomeBusca;
		double media = 0;
		int qtdCadastrada=0;
//	Nome, g�nero, primeira nota, segunda nota e turno,
		ArrayList<String> nome = new ArrayList<String>();
		ArrayList<String> genero = new ArrayList<String>();
		ArrayList<Double> n1 = new ArrayList<Double>();
		ArrayList<Double> n2 = new ArrayList<Double>();
		ArrayList<Character> turno = new ArrayList<Character>();

		while (sair) {
			int qtdMas=0,qtdFem=0,matutino=0,vespertino=0,noturno=0,mediaMaior=0,mediaMenor=0;
			String[] menupri = { "CADASTRAR", "LISTAR", "BUSCAR", "ALTERAR", "REMOVER","ESTAT�STICAS","FINALIZAR"};
			int response = JOptionPane.showOptionDialog(null,
					"Nessa atividade ser� necess�rio criar um CRUD para manipular os dados de um aluno, as funcionalidades da aplica��o ser�o:\r\n"
							+ "Cadastrar - Nome, g�nero, primeira nota, segunda nota e turno, cada um desses dados ser� salvo em um ArrayList diferente.\r\n"
							+ "Listar - Listar todos os dados, al�m de realizar a m�dia das duas notas.\r\n"
							+ "Pesquisar - Informe o nome do aluno para obter os dados cadastrados e a m�dia. Alunos de mesmo nome precisam ser listados e em seguida o usu�rio escolher qual deseja exibir.\r\n"
							+ "Alterar - Pesquise pelo nome e pe�a novamente os dados: nome, g�nero, primeira nota, segunda nota e turno. Cuidado para alunos com o mesmo nome;\r\n"
							+ "Remover - Pesquise pelo nome e remova o aluno, caso haja mais de um aluno com o mesmo nome, dever� ser exibida uma lista para o usu�rio escolher quem ser� removido;\r\n"
							+ "Estat�sticas - Informe os seguintes dados:\r\n" + "Quantidade de alunos cadastrados;\r\n"
							+ "Quantidade de alunos por g�nero;\r\n" + "Quantidade de alunos por turno;\r\n"
							+ "Quantidade de alunos com m�dia superior ou igual a 7;\r\n"
							+ "Quantidade de alunos com m�dia inferior a 7.\r\n" + "Sair - Finalizar o sistema.\r\n"
							+ "",
					"Alunos", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, menupri,
					"None of your business");
			if (response == 0) {
				nome.add(JOptionPane.showInputDialog("Informe o nome do aluno"));
				genero.add(JOptionPane.showInputDialog("Informe o genero"));
				n1.add(Double.parseDouble(JOptionPane.showInputDialog("Informe a nota 1:")));
				n2.add(Double.parseDouble(JOptionPane.showInputDialog("Informe a nota 2:")));
				turno.add(JOptionPane.showInputDialog("Informe o Turno(M/V/N)").charAt(0));
				qtdCadastrada++;
				System.out.println("Adicionar");
			}
			if (response == 1) {
				String listaComMedia = "Lista de Todos alunos:\n";
				for (int i = 0; i < nome.size(); i++) {
					media = ((n1.get(i)) + n2.get(i)) / 2;
					listaComMedia += "Nome: " + nome.get(i) + " Genero:" + genero.get(i) + " Nota 1:" + n1.get(i)
							+ " Nota 2:" + n2.get(i) + " " + turno.get(i) + " M�dia: " + media + "\n";
				}
				JOptionPane.showMessageDialog(null, listaComMedia);
			}
			if (response == 2) {
				String lista = "LISTA\n";
				int buscarMaisDeUm = 0, numeroBusca = 0;
				nomeBusca = JOptionPane.showInputDialog("Informe o nome do aluno para buscar");
				for (int i = 0; i < nome.size(); i++) {
					if (nome.get(i).contains(nomeBusca)) {
						lista += nome.get(i) + "  " + i + "\n";
						buscarMaisDeUm++;
						numeroBusca = i;
					}
				}
				if (buscarMaisDeUm > 1) {
					numeroBusca = Integer.parseInt(JOptionPane.showInputDialog(lista));
				}
				if (buscarMaisDeUm > 0) {
					media = ((n1.get(numeroBusca)) + n2.get(numeroBusca)) / 2;

					JOptionPane.showMessageDialog(null,
							"Nome: " + nome.get(numeroBusca) + " Genero:" + genero.get(numeroBusca) + " Nota 1:"
									+ n1.get(numeroBusca) + " Nota 2:" + n2.get(numeroBusca) + " "
									+ turno.get(numeroBusca) + " M�dia: " + media);
				}

				System.out.println("listar");
			}
			if (response == 3) {
				String lista = "LISTA\n";
				int buscarMaisDeUm = 0, numeroBusca = 0;
				nomeBusca = JOptionPane.showInputDialog("Informe o nome que deseja alterar");
				for (int i = 0; i < nome.size(); i++) {
					if (nome.get(i).contains(nomeBusca)) {
						lista += nome.get(i) + "  " + i + "\n";
						buscarMaisDeUm++;
						numeroBusca = i;
					}
				}
				if (buscarMaisDeUm > 1) {
					numeroBusca = Integer.parseInt(JOptionPane.showInputDialog(lista));
				}
				if (buscarMaisDeUm > 0) {
					nome.set(numeroBusca,
							JOptionPane.showInputDialog("Informe o novo aluno( " + nome.get(numeroBusca) + " )"));
					genero.set(numeroBusca,
							JOptionPane.showInputDialog("Informe o novo genero" + genero.get(numeroBusca)));
					n1.set(numeroBusca, Double
							.parseDouble(JOptionPane.showInputDialog("Informe a nova nota 1: " + n1.get(numeroBusca))));
					n2.set(numeroBusca, Double
							.parseDouble(JOptionPane.showInputDialog("Informe a nova nota 2: " + n2.get(numeroBusca))));
					turno.set(numeroBusca,
							JOptionPane.showInputDialog("Informe a nova cidade" + turno.get(numeroBusca)).charAt(0));
					JOptionPane.showMessageDialog(null, "Aluno Alterado!!!");
				}

				System.out.println("alterar");
			}
			if (response == 4) {
				String lista = "LISTA\n";
				int buscarMaisDeUm = 0, numeroBusca = 0;
				nomeBusca = JOptionPane.showInputDialog("Informe o nome que deseja remover");
				for (int i = 0; i < nome.size(); i++) {
					if (nome.get(i).contains(nomeBusca)) {
						lista +="Nome: " + nome.get(i) + " Genero:" + genero.get(i) + " Nota 1:"
								+ n1.get(i) + " Nota 2:" + n2.get(i) + " "
								+ turno.get(i)+"\n";
								
						buscarMaisDeUm++;
						numeroBusca = i;
					}
				}
				if (buscarMaisDeUm > 1) {
					numeroBusca = Integer.parseInt(JOptionPane.showInputDialog(lista));
				}
				if (buscarMaisDeUm > 0) {
					nome.remove(numeroBusca);
					genero.remove(numeroBusca);
					n1.remove(numeroBusca);
					n2.remove(numeroBusca);
					turno.remove(numeroBusca);
					qtdCadastrada--;
					JOptionPane.showMessageDialog(null, "Aluno Removido!!!");
				}

				System.out.println("alterar");
			}
			
			if (response == 5 || response == -1) {
				
				for (int i = 0; i < nome.size(); i++) {
					media = ((n1.get(i)) + n2.get(i)) / 2;
					if(media>=7) {
						mediaMaior++;
					}else {
						mediaMenor++;
					}
					
					if(genero.get(i).toLowerCase().charAt(0) =='m') {
						qtdMas++;
					}else {
						qtdFem++;
					}
					
					if(turno.get(i) =='m') {
						matutino++;
					}else if(turno.get(i) =='v') {
						vespertino++;
					}else {
						noturno++;
					}
				}
				
				
				JOptionPane.showMessageDialog(null, "Quantidade Cadastrada: "+qtdCadastrada+"\n"+
								"Quantidade Masculino: "+qtdMas+"\n"+
								"Quantidade Feminino: "+qtdFem+"\n"+
								"Quantidade Matutino: "+matutino+"\n"+
								"Quantidade Vespertino: "+vespertino+"\n"+
								"Quantidade Noturno: "+noturno+"\n"+
								"Quantidade Media maior que 7: "+mediaMaior+"\n"+
								"Quantidade Media menor que 7: "+mediaMenor+"\n");
			}

			for (int i = 0; i < nome.size(); i++) {
				System.out.println(nome.get(i) + " " + turno.get(i));
			}

			if (response == 6 || response == -1) {
				sair = false;
			}

		}
	}
}
