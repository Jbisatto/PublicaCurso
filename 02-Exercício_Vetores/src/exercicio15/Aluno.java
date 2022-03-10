package exercicio15;

import javax.swing.JOptionPane;

public class Aluno {

	public static void main(String[] args) {

		String[][] alunos = new String[30][5];
		boolean sair = true;
		String nome, genero, n1, n2, n3;
		int contador = 0, remover = 0;
		while (sair) {
			String[] menupri = { "ADICIONAR", "LISTAR", "ALTERAR", "REMOVER", "ESTATÍSTICAS", "FINALIZAR" };
			int response = JOptionPane.showOptionDialog(null, "SISTEMAS DE CONTROLE DE ALUNOS", "Produtos",
					JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, menupri, "None of your business");

			if (response == 0) {
				nome = JOptionPane.showInputDialog("Informe o nome do Aluno");
				genero = JOptionPane.showInputDialog("Informe o Genero(M/F)");
				n1 = JOptionPane.showInputDialog("Informe a nota 1");
				n2 = JOptionPane.showInputDialog("Informe a nota 2");
				n3 = JOptionPane.showInputDialog("Informe a nota 3");
				alunos[contador][0] = nome;
				alunos[contador][1] = genero;
				alunos[contador][2] = n1;
				alunos[contador][3] = n2;
				alunos[contador][4] = n3;
				contador++;
				System.out.println("Adicionar");
			}
			if (response == 1) {
				String listaAlunos = "Lista de Alunos\n";
				for (int i = 0; i < alunos.length; i++) {
					if (alunos[i][0] != null) {
						int media = (Integer.parseInt(alunos[i][2]) + Integer.parseInt(alunos[i][3])
								+ Integer.parseInt(alunos[i][4])) / 3;
						String situacao = media >= 7 ? "Aprovado" : "Reprovado";

						listaAlunos += "Nome: " + alunos[i][0] + " -- Gênero: " + alunos[i][1] + " -- Nota(1): "
								+ alunos[i][2] + " -- Nota(2): " + alunos[i][3] + " -- Nota(3): " + alunos[i][4]
								+ " -- Média: " + media + "Situação: " + situacao + "\n";
					}
				}
				JOptionPane.showMessageDialog(null, listaAlunos);

				System.out.println("listar");
			}
			if (response == 2) {
				nome = JOptionPane.showInputDialog("Informe o nome do aluno que deseja editar");
				for (int i = 0; i < contador; i++) {
					if (alunos[i][0].equals(nome)) {
						nome = JOptionPane.showInputDialog("Informe o nome do Aluno( " + alunos[i][0] + " )");
						genero = JOptionPane.showInputDialog("Informe o Genero(M/F)( " + alunos[i][1] + " )");
						n1 = JOptionPane.showInputDialog("Informe a nota 1( " + alunos[i][2] + " )");
						n2 = JOptionPane.showInputDialog("Informe a nota 2( " + alunos[i][3] + " )");
						n3 = JOptionPane.showInputDialog("Informe a nota 3( " + alunos[i][4] + " )");
						alunos[i][0] = nome;
						alunos[i][1] = genero;
						alunos[i][2] = n1;
						alunos[i][3] = n2;
						alunos[i][4] = n3;
						JOptionPane.showMessageDialog(null, "Aluno Alterado!!!");
					}
				}
				System.out.println("alterar");
			}
			if (response == 3) {
				nome = JOptionPane.showInputDialog("Digite o nome do Aluno que deseja Remover");
				for (int i = 0; i < contador; i++) {
					if (alunos[i][0].equals(nome)) {
						remover = Integer.parseInt(JOptionPane.showInputDialog("Deseja mesmo remover o Aluno:\n "
								+ alunos[i][0] + "\n(Digite 1 para confirmar ou 0 para cancelar)"));
						if (remover == 1) {
							alunos[i][0] = null;
							alunos[i][1] = null;
							alunos[i][2] = null;
							alunos[i][3] = null;
							alunos[i][4] = null;
						}

					}
				}
				System.out.println("remover");
			}
			if (response == 4) {
				
				int qtdRegistro = 0, qtdHomens = 0, qtdMulheres = 0, aprovado = 0, reprovado = 0;
				for (int i = 0; i < alunos.length; i++) {
					if (alunos[i][0] != null) {
						int media = (Integer.parseInt(alunos[i][2]) + Integer.parseInt(alunos[i][3])
								+ Integer.parseInt(alunos[i][4])) / 3;
						String situacao = media >= 7 ? "Aprovado" : "Reprovado";
						if (  Character.toString(alunos[i][1].toLowerCase().charAt(0)).equals("m")) {
							qtdHomens++;
						} else {
							qtdMulheres++;
						}
						if (situacao == "Aprovado") {
							aprovado++;
						}else {
							reprovado++;
						}
						qtdRegistro++;
					}
				}
				String estatisticas="Estatísticas\nQuantidade de Registros: "+qtdRegistro+
						"\nQuantidade de Homens: "+qtdHomens+
						"\nQuantidade de Mulheres: "+qtdMulheres+
						"\nAprovados: "+aprovado+
						"\nReprovados: "+reprovado;
				JOptionPane.showMessageDialog(null, estatisticas);
				System.out.println(qtdRegistro);
				System.out.println("estatísticas");
			}
			if (response == 5) {
				System.out.println("finalizar");
				sair = false;
			}

		}
	}

}
