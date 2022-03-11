import java.util.ArrayList;

import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.JOptionPane;

public class Impostos {

	public static void main(String[] args) {
		boolean sair = true;
		String nomeBusca;
		double impM = 0, impE = 0, impF = 0;
		int qtdCadastrada = 0, qtdSeg1 = 0, qtdSeg2 = 0, qtdSeg3 = 0, qtdSeg4 = 0, qtdSeg5 = 0;
		double valorTotalImposto = 0, valorSemImposto = 0;
		ArrayList<String> produto = new ArrayList<String>();
		ArrayList<Double> valor = new ArrayList<Double>();
		ArrayList<Integer> segmento = new ArrayList<Integer>();

		while (sair) {
			int qtdMas = 0, qtdFem = 0, matutino = 0, vespertino = 0, noturno = 0, mediaMaior = 0, mediaMenor = 0;
			String[] menupri = { "CADASTRAR", "LISTAR TODOS", "LISTAR SEGMENTO", "ALTERAR", "REMOVER", "ESTATÍSTICAS",
					"FINALIZAR" };
			int response = JOptionPane.showOptionDialog(null,
					"Neste simulado iremos criar um sistema para extrair os impostos municipais, estaduais e federais de alguns produtos, para isso implemente as seguintes funcionalidades:\r\n"
							+ "Cadastrar: Informe o nome do produto, valor e segmento. Não poderá haver produtos de mesmo nome;\r\n"
							+ "Listar: Informe o nome do produto, valor, segmento, valor de cada tipo de imposto e o valor do produto sem os impostos;\r\n"
							+ "Listar por segmento: Liste os segmentos, escolha um e exiba todos os produtos, valores e impostos de cada produto daquele segmento;\r\n"
							+ "Alterar: Pesquise pelo nome do produto, em seguida informe o novo nome do produto, valor e segmento;\r\n"
							+ "Remover: Informe o nome do produto e exclua;\r\n"
							+ "Estatísticas: Exiba a quantidade de produtos cadastrados, quantidade de produtos por segmento e a média de impostos (exiba cada um dos três) por segmento;\r\n"
							+ "Sair: Finaliza o sistema.\r\n" + "",
					"Calculo de Impostos do Produtos", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, menupri,
					"None of your business");

//			Cadastrar: Informe o nome do produto, valor e segmento. Não poderá haver produtos de mesmo nome;		
			if (response == 0) {
				String verificaProduto = JOptionPane.showInputDialog("Informe o nome do produto");
				boolean jacadastrado = false;
				for (int i = 0; i < produto.size(); i++) {
					if (produto.get(i).equals(verificaProduto)) {
						jacadastrado = true;
					}
				}
				if (!jacadastrado) {
					int aux=0;
					produto.add(verificaProduto);
					valor.add(Double.parseDouble(JOptionPane.showInputDialog("Informe o valor do produto")));
					aux=Integer.parseInt(JOptionPane.showInputDialog(
							"Sequementos(Digiteo numero referente a cada opção): \n1-Áudio e vídeo" + "\n2-Alimentício"
									+ "\n3-Eletrodomésticos" + "\n4-Informática" + "\n5-Vestuário"));
					segmento.add(aux);
					if (aux== 1) {
						qtdSeg1++;
					} else if (aux == 2) {
						qtdSeg2++;
					} else if (aux == 3) {
						qtdSeg3++;
					} else if (aux == 4) {
						qtdSeg4++;
					} else {
						qtdSeg5++;
					}
					qtdCadastrada++;
					jacadastrado = false;
					System.out.println("Adicionar");
				}
			}
			for (int i = 0; i < produto.size(); i++) {
				System.out.println(produto.get(i) + " " + valor.get(i) + " " + segmento.get(i));
			}
			if (response == 1) {
				String lista = "Lista:\n", seqmentoNome = "";
				for (int i = 0; i < produto.size(); i++) {
					if (segmento.get(i) == 1) {
						seqmentoNome = "Áudio e vídeo";
						impM = valor.get(i) * 0.03;
						impE = valor.get(i) * 0.05;
						impF = valor.get(i) * 0.07;
						valorTotalImposto = impM + impF + impE;
					} else if (segmento.get(i) == 2) {
						seqmentoNome = "Alimentício";
						impM = valor.get(i) * 0.01;
						impE = valor.get(i) * 0.03;
						impF = valor.get(i) * 0.06;
						valorTotalImposto = impM + impF + impE;
					} else if (segmento.get(i) == 3) {
						seqmentoNome = "Eletrodomésticos";
						impM = valor.get(i) * 0.03;
						impE = valor.get(i) * 0.08;
						impF = valor.get(i) * 0.09;
						valorTotalImposto = impM + impF + impE;
					} else if (segmento.get(i) == 4) {
						seqmentoNome = "Informática";
						impM = valor.get(i) * 0.04;
						impE = valor.get(i) * 0.10;
						impF = valor.get(i) * 0.16;
						valorTotalImposto = impM + impF + impE;
					} else {
						seqmentoNome = "Vestuário";
						impM = valor.get(i) * 0.02;
						impE = valor.get(i) * 0.03;
						impF = valor.get(i) * 0.05;
						valorTotalImposto = impM + impF + impE;
					}
					valorSemImposto = valor.get(i) - valorTotalImposto;
					lista += produto.get(i) + " valor: R$" + valor.get(i) + " segmento: " + seqmentoNome
							+ " Imposto Municipal: " + impM + " Imposto Estadual: " + impE + " Imposto Federal: " + impF
							+ " Valor sem Imposto: R$" + valorSemImposto + "   \n";

				}
				JOptionPane.showMessageDialog(null, lista);

			}
			if (response == 2) {
				String lista = "Lista:\n", seqmentoNome = "";

				int valorEscolhidoSeg = Integer.parseInt(JOptionPane
						.showInputDialog("Sequementos(Digiteo numero referente a cada opção): \n1-Áudio e vídeo"
								+ "\n2-Alimentício" + "\n3-Eletrodomésticos" + "\n4-Informática" + "\n5-Vestuário"));
				if (valorEscolhidoSeg == 1) {
					lista += "Segmento Áudio e vídeo\n";
				} else if (valorEscolhidoSeg == 2) {
					lista += "Segmento Alimentício\n";
				} else if (valorEscolhidoSeg == 3) {
					lista += "Segmento Eletrodomésticos\n";
				} else if (valorEscolhidoSeg == 4) {
					lista += "Segmento Informática\n";
				} else {
					lista += "Vestuário\n";
				}

				for (int i = 0; i < segmento.size(); i++) {
					if (segmento.get(i) == valorEscolhidoSeg) {
						if (segmento.get(i) == 1) {
							seqmentoNome = "Áudio e vídeo";
							impM = valor.get(i) * 0.03;
							impE = valor.get(i) * 0.05;
							impF = valor.get(i) * 0.07;
							valorTotalImposto = impM + impF + impE;
						} else if (segmento.get(i) == 2) {
							seqmentoNome = "Alimentício";
							impM = valor.get(i) * 0.01;
							impE = valor.get(i) * 0.03;
							impF = valor.get(i) * 0.06;
							valorTotalImposto = impM + impF + impE;
						} else if (segmento.get(i) == 3) {
							seqmentoNome = "Eletrodomésticos";
							impM = valor.get(i) * 0.03;
							impE = valor.get(i) * 0.08;
							impF = valor.get(i) * 0.09;
							valorTotalImposto = impM + impF + impE;
						} else if (segmento.get(i) == 4) {
							seqmentoNome = "Informática";
							impM = valor.get(i) * 0.04;
							impE = valor.get(i) * 0.10;
							impF = valor.get(i) * 0.16;
							valorTotalImposto = impM + impF + impE;
						} else {
							seqmentoNome = "Vestuário";
							impM = valor.get(i) * 0.02;
							impE = valor.get(i) * 0.03;
							impF = valor.get(i) * 0.05;
							valorTotalImposto = impM + impF + impE;
						}
						valorSemImposto = valor.get(i) - valorTotalImposto;
						lista += produto.get(i) + " valor: R$" + valor.get(i) + " Imposto Municipal: " + impM
								+ " Imposto Estadual: " + impE + " Imposto Federal: " + impF + "   \n";

					}
				}
				JOptionPane.showMessageDialog(null, lista);
			}
			if (response == 3) {
				nomeBusca = JOptionPane.showInputDialog("Informe o nome do produto que deseja alterar");
				for (int i = 0; i < produto.size(); i++) {
					if (produto.get(i).equals(nomeBusca)) {
						String verificaProduto = JOptionPane
								.showInputDialog("Informe o novo nome do Produto( " + produto.get(i) + " )");
						boolean jacadastrado = false;
						for (int j = 0; j < produto.size(); j++) {
							if (produto.get(j).equals(verificaProduto) && !produto.get(j).equals(nomeBusca)) {
								jacadastrado = true;
								JOptionPane.showMessageDialog(null, "Esse produto já existe!!!");
							}
						}
						if (!jacadastrado) {
							int numeroSegNovo=0;
							produto.set(i, verificaProduto);

							valor.set(i, Double.parseDouble(
									JOptionPane.showInputDialog("Informe o novo valor(" + valor.get(i) + ")")));
							
							numeroSegNovo=Integer.parseInt(JOptionPane.showInputDialog("Informe o novo segmento("
											+ segmento.get(i) + ")\n1-Áudio e vídeo" + "\n2-Alimentício"
											+ "\n3-Eletrodomésticos" + "\n4-Informática" + "\n5-Vestuário"));
						    if(segmento.get(i)!=numeroSegNovo) {
								if (segmento.get(i)== 1) {
									qtdSeg1--;
								} else if (segmento.get(i) == 2) {
									qtdSeg2--;
								} else if (segmento.get(i) == 3) {
									qtdSeg3--;
								} else if (segmento.get(i) == 4) {
									qtdSeg4--;
								} else {
									qtdSeg5--;
								}
								
								if (numeroSegNovo== 1) {
									qtdSeg1++;
								} else if (numeroSegNovo == 2) {
									qtdSeg2++;
								} else if (numeroSegNovo == 3) {
									qtdSeg3++;
								} else if (numeroSegNovo == 4) {
									qtdSeg4++;
								} else {
									qtdSeg5++;
								}
						    }
							
							
							segmento.set(i,numeroSegNovo);
											JOptionPane.showMessageDialog(null, "Produto Alterado!!!");
							jacadastrado = false;
						}
					}
				}

				System.out.println("alterar");

			}
			if (response == 4) {
				nomeBusca = JOptionPane.showInputDialog("Informe o nome do produto que deseja Remover");
				for (int i = 0; i < produto.size(); i++) {
					if (produto.get(i).equals(nomeBusca)) {
						produto.remove(i);
						valor.remove(i);
						segmento.get(i);
						if (segmento.get(i) == 1) {
							qtdSeg1--;
						} else if (segmento.get(i) == 2) {
							qtdSeg2--;
						} else if (segmento.get(i) == 3) {
							qtdSeg3--;
						} else if (segmento.get(i) == 4) {
							qtdSeg4--;
						} else {
							qtdSeg5--;
						}
						qtdCadastrada--;
						JOptionPane.showMessageDialog(null, "Produto Removido com sucesso!!!");
					}
				}

			}

			if (response == 5) {
				double seg1ImpM = 0, seg1ImpE = 0, seg1ImpF = 0,

						seg2ImpM = 0, seg2ImpE = 0, seg2ImpF = 0,

						seg3ImpM = 0, seg3ImpE = 0, seg3ImpF = 0,

						seg4ImpM = 0, seg4ImpE = 0, seg4ImpF = 0,

						seg5ImpM = 0, seg5ImpE = 0, seg5ImpF = 0;
				
				for (int i = 0; i < valor.size(); i++) {
					if (segmento.get(i) == 1) {
						seg1ImpM += valor.get(i) * 0.03;
						seg1ImpE += valor.get(i) * 0.05;
						seg1ImpF += valor.get(i) * 0.07;
					} else if (segmento.get(i) == 2) {
						seg2ImpM += valor.get(i) * 0.01;
						seg2ImpE += valor.get(i) * 0.03;
						seg2ImpF += valor.get(i) * 0.06;
					} else if (segmento.get(i) == 3) {
						seg3ImpM += valor.get(i) * 0.03;
						seg3ImpE += valor.get(i) * 0.08;
						seg3ImpF += valor.get(i) * 0.09;
					} else if (segmento.get(i) == 4) {
						seg4ImpM += valor.get(i) * 0.04;
						seg4ImpE += valor.get(i) * 0.10;
						seg4ImpF += valor.get(i) * 0.16;
					} else {
						seg5ImpM += valor.get(i) * 0.02;
						seg5ImpE += valor.get(i) * 0.03;
						seg5ImpF += valor.get(i) * 0.05;
					}
				}
				if(qtdCadastrada>0) {
				seg1ImpM = seg1ImpM/qtdSeg1;
				seg1ImpE = seg1ImpE/qtdSeg1;
				seg1ImpF = seg1ImpF/qtdSeg1;
				seg2ImpM = seg2ImpM/qtdSeg2;
				seg2ImpE = seg2ImpE/qtdSeg2;
				seg2ImpF = seg2ImpF/qtdSeg2;
				seg3ImpM = seg3ImpM/qtdSeg3;
				seg3ImpE = seg3ImpE/qtdSeg3;
				seg3ImpF = seg3ImpF/qtdSeg3;
				seg4ImpM = seg4ImpM/qtdSeg4;
				seg4ImpE = seg4ImpE/qtdSeg4;
				seg4ImpF = seg4ImpF/qtdSeg4;
				seg5ImpM = seg5ImpM/qtdSeg5;
				seg5ImpE = seg5ImpE/qtdSeg5;
				seg5ImpF = seg5ImpF/qtdSeg5;
				}
				JOptionPane.showMessageDialog(null,""
						+ "Quantidade de produtos cadastrados: "+qtdCadastrada
						+ "\nQuantidade de produtos por segmento: "
						+ "\n1-Áudio e vídeo: "+qtdSeg1
						+ "\n2-Alimentício"+qtdSeg2
						+ "\n3-Eletrodomésticos"+qtdSeg3
						+ "\n4-Informática"+qtdSeg4
						+ "\n5-Vestuário"+qtdSeg5
						+ "\n "
						+ "\nMédia de impostos por Segmentos: "
						+ "\nÁudio e vídeo: Municipal: "+seg1ImpM+" Estadual: "+seg1ImpE+" Federal: "+seg1ImpF
						+ "\nAlimentício: Municipal: "+seg2ImpM+" Estadual: "+seg2ImpE+" Federal: "+seg2ImpF
						+ "\nEletrodomésticos: Municipal: "+seg3ImpM+" Estadual: "+seg3ImpE+" Federal: "+seg3ImpF
						+ "\nInformática: Municipal: "+seg4ImpM+" Estadual: "+seg4ImpE+" Federal: "+seg4ImpF
						+ "\nVestuário: Municipal: "+seg5ImpM+" Estadual: "+seg5ImpE+" Federal: "+seg5ImpF);

			}
			System.out.println(response);
			if (response == 6 || response == -1) {
				sair = false;
			}

		}
	}

}
