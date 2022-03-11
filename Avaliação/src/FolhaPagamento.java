import java.util.ArrayList;

import javax.swing.JOptionPane;

public class FolhaPagamento {

	public static void main(String[] args) {
		boolean sair = true;

		ArrayList<String> nome = new ArrayList<String>();
		ArrayList<Integer> cargo = new ArrayList<Integer>();
		ArrayList<Double> qtdHoraExtra = new ArrayList<Double>();
		ArrayList<Integer> qtdFaltas = new ArrayList<Integer>();
		ArrayList<Character> plano = new ArrayList<Character>();

		while (sair) {

			String[] menupri = { "CADASTRAR", "LISTAR", "ALTERAR", "REMOVER", "FINALIZAR" };
			int response = JOptionPane.showOptionDialog(null,
					"	Desenvolver um sistema para gerenciar a folha de pagamentos, implemente as seguintes funcionalidades.\r\n"
							+ "Cadastro - Informe os seguintes dados:\r\n" + "Nome do colaborador;\r\n" + "Cargo;\r\n"
							+ "Quantidade de horas extras;\r\n" + "Quantidade de faltas;\r\n"
							+ "Se adere ao plano de saúde;\r\n"
							+ "Listar - Exiba os seguintes dados de todos os colaboradores:\r\n"
							+ "Nome do colaborador;\r\n" + "Cargo;\r\n" + "Salário bruto;\r\n"
							+ "Quantidade de horas extras;\r\n" + "Valor recebido pelas horas extras;\r\n"
							+ "Valor extra recebido pela quantidade faltas;\r\n"
							+ "Valor a ser descontado do plano de saúde;\r\n" + "Desconto do vale transporte;\r\n"
							+ "Desconto do vale alimentação;\r\n" + "Desconto do imposto de renda;\r\n"
							+ "Salário bruto;\r\n" + "Salário líquido.\r\n"
							+ "Alterar - Peça o nome, índice do vetor ou um código para poder selecionar um colaborador, peça os mesmos dados pedidos no cadastro para realizar a alteração;\r\n"
							+ "Remover - Peça o nome, índice do vetor ou um código para poder remover o colaborador;\r\n"
							+ "Sair - Finaliza o sistema.\r\n" + "",
					"Folha de Pagamento", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, menupri,
					"None of your business");
			if (response == 0) {
				nome.add(JOptionPane.showInputDialog("Informe o nome"));
				cargo.add(Integer.parseInt(
						JOptionPane.showInputDialog("Informe o cargo\n1-Desenvolvedor Jr\n2-Desenvolvedor Pleno"
								+ "\n3-Desenvolvedor Sênior\n4-DBA\n5-Arquiteto de Software")));
				qtdHoraExtra
						.add(Double.parseDouble(JOptionPane.showInputDialog("Informe a quatidade de Horas Extras")));
				qtdFaltas.add(Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Faltas")));
				plano.add(JOptionPane.showInputDialog("Tem plao de Saude(S/N)").charAt(0));
			}

			if (response == 1) {
				String lista = "Lista:\n", nomeCargo = "";
				double salarioBruto = 0, valorRecebidoHoExtr, impostoRenda = 0, valeAlimentacao = 0;
				for (int i = 0; i < nome.size(); i++) {
					switch (cargo.get(i)) {
					case 1: {
						nomeCargo = "Desenvolvedor Jr";
						salarioBruto = 2000;
						valorRecebidoHoExtr = qtdHoraExtra.get(i) * 12.5;
						impostoRenda = 200;
						valeAlimentacao = 360;
						break;
					}
					case 2: {
						nomeCargo = "Desenvolvedor Pleno";
						salarioBruto = 3200;
						valorRecebidoHoExtr = qtdHoraExtra.get(i) * 18.9;
						impostoRenda = 320;
						valeAlimentacao = 420;
						break;
					}
					case 3: {
						nomeCargo = "Desenvolvedor Sênior";
						salarioBruto = 5000;
						valorRecebidoHoExtr = qtdHoraExtra.get(i) * 25.0;
						impostoRenda = 500;
						valeAlimentacao = 500;
						break;
					}
					case 4: {
						nomeCargo = "DBA";
						salarioBruto = 7000;
						valorRecebidoHoExtr = qtdHoraExtra.get(i) * 45.0;
						impostoRenda = 700;
						valeAlimentacao = 635;
						break;
					}
					case 5: {
						nomeCargo = "Desenvolvedor Sênior";
						salarioBruto = 8500;
						valorRecebidoHoExtr = qtdHoraExtra.get(i) * 70.60;
						impostoRenda = 850;
						valeAlimentacao = 765;
						break;
					}

					default:
						throw new IllegalArgumentException("Unexpected value: " + cargo.get(i));
					}

					double valorFalta = (qtdFaltas.get(i) == 0) ? 100 : 0;

					double valorPlanoSaude = (Character.toLowerCase(plano.get(i)) == 's') ? 400 : 0;

					double salarioLiquido = (salarioBruto + valorRecebidoHoExtr + valorFalta)
							- ((salarioBruto * 0.06) + valeAlimentacao + valorPlanoSaude + impostoRenda);

					lista += "Nome: " + nome.get(i) + "\nCargo: " + nomeCargo + "\nSalario Bruto: " + salarioBruto
							+ "\nQuantidade de Hora Extras: " + qtdHoraExtra.get(i)
							+ "\nValor recebido pelas horas extras: " + valorRecebidoHoExtr
							+ "\nValor extra recebido pela quantidade faltas: " + valorFalta
							+ "\nValor a ser descontado do plano de saúde: " + valorPlanoSaude
							+ "\nDesconto do vale transporte: " + (salarioBruto * 0.06)
							+ "\nDesconto do vale alimentação: " + valeAlimentacao + "\nDesconto do imposto de renda: "
							+ impostoRenda + "\nSalário líquido: " + salarioLiquido
							+ "\n------------------------------------------------\n";

				}

				JOptionPane.showMessageDialog(null, lista);

			}

			if (response == 2) {
				String lista = "Lista:\n";
				for (int i = 0; i < nome.size(); i++) {
					lista += nome.get(i) + "\n";
				}
				String nomeAlterar = JOptionPane.showInputDialog(lista + "\nInforme o nome que deseja Alterar");
				for (int i = 0; i < nome.size(); i++) {
					if (nome.get(i).equals(nomeAlterar)) {
						nome.set(i, JOptionPane.showInputDialog("Informe o novo nome( " + nome.get(i) + " )"));

						cargo.set(i,
								Integer.parseInt(JOptionPane.showInputDialog("Informe o cargo( " + cargo.get(i)
										+ " )\n1-Desenvolvedor Jr\n2-Desenvolvedor Pleno"
										+ "\n3-Desenvolvedor Sênior\n4-DBA\n5-Arquiteto de Software")));
						qtdHoraExtra.set(i, Double.parseDouble(JOptionPane.showInputDialog(
								"Informe a nova quatidade de Horas Extras( " + qtdHoraExtra.get(i) + ")")));
						qtdFaltas.set(i, Integer.parseInt(
								JOptionPane.showInputDialog("Quantidade de Faltas( " + qtdFaltas.get(i) + ")")));
						plano.set(i,
								JOptionPane.showInputDialog("Tem plao de Saude(S/N) (" + plano.get(i) + ")").charAt(0));

					}
				}
			}

			if (response == 3) {
				String lista = "Lista:\n";
				for (int i = 0; i < nome.size(); i++) {
					lista += nome.get(i) + "\n";
				}
				String nomeRemover = JOptionPane.showInputDialog(lista + "\nInforme o nome que deseja Remover");
				for (int i = 0; i < nome.size(); i++) {
					if (nome.get(i).equals(nomeRemover)) {
						nome.remove(i);
						cargo.remove(i);
						qtdHoraExtra.get(i);
						qtdFaltas.remove(i);
						plano.remove(i);

						JOptionPane.showMessageDialog(null, "Produto Removido com sucesso!!!");
					}
				}
			}

			if (response == 4 || response == -1) {
				sair = false;
			}
		}

	}

}
