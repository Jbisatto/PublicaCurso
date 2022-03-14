package View;

import java.awt.HeadlessException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import Modelo.Pessoa;

public class Principal {

	public static void main(String[] args) throws HeadlessException, ParseException {

		boolean sair = true;
		String nome;
		ArrayList<Pessoa> listaPessoas = new ArrayList<>();

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		while (sair) {

			String[] menupri = { "CADASTRAR", "PESQUISAR", "ALTERAR", "REMOVER","ANIVERSARIANTE DO MÊS", "FINALIZAR" };
			int response = JOptionPane.showOptionDialog(null,
					"Criar uma agenda de contatos com as seguintes funcionalidades:\r\n"
							+ "Cadastrar - Nome, e-mail, telefone, nascimento, estado e cidade;\r\n"
							+ "Pesquisar - Informe o nome do contato, índice da linha do vetor ou um código específico para listar os dados de um determinado contato;\r\n"
							+ "Alterar - Atualiza os dados do contato;\r\n" + "Remover - Exclui contato;\r\n"
							+ "Aniversariantes do mês, retorne todos os aniversariantes do mês atual e informe qual a idade aquele contato irá fazer;\r\n"
							+ "Sair - Finaliza a aplicação.\r\n" + "",
					"Agenda", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, menupri,
					"None of your business");
			if (response == 0) {
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(JOptionPane.showInputDialog("Informe o nome da Pessoa: "));
				pessoa.setEmail(JOptionPane.showInputDialog("Informe o email da Pessoa:"));
				pessoa.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Informe o telefone da Pessoa: ")));
				pessoa.setDataNacimento(
						formato.parse(JOptionPane.showInputDialog("Informe a date de Nascimento(dd/mm/aaaa)")));
				pessoa.setCidade(JOptionPane.showInputDialog("Informe a cidade: "));
				pessoa.setEstado(JOptionPane.showInputDialog("Informe a estado: "));
				listaPessoas.add(pessoa);
				JOptionPane.showMessageDialog(null, "Pessoa cadastrada!!!\n" + pessoa);
			}
			if (response == 1) {
				nome = JOptionPane.showInputDialog("Digite o nome para buscar: ");
				Pessoa pessoa = new Pessoa();
				boolean tem = false;
				for (int i = 0; i < listaPessoas.size(); i++) {
					if (listaPessoas.get(i).getNome().equals(nome)) {
						tem = true;
						pessoa.setNome(listaPessoas.get(i).getNome());
						pessoa.setEmail(listaPessoas.get(i).getEmail());
						pessoa.setTelefone(listaPessoas.get(i).getTelefone());
						pessoa.setDataNacimento(listaPessoas.get(i).getDataNacimento());
						pessoa.setCidade(listaPessoas.get(i).getCidade());
						pessoa.setEstado(listaPessoas.get(i).getEstado());
					}
				}
				if (tem) {
					JOptionPane.showMessageDialog(null, pessoa);
					tem = false;
				} else {
					JOptionPane.showMessageDialog(null, "Pessoa não encontrada");
				}

			}
			if (response == 2) {
				nome = JOptionPane.showInputDialog("Digite o nome para alterar: ");
				Pessoa pessoa = new Pessoa();
				int indexPessoa = 0;
				for (int i = 0; i < listaPessoas.size(); i++) {
					if (listaPessoas.get(i).getNome().equals(nome)) {
						indexPessoa = i;
						pessoa.setNome(listaPessoas.get(i).getNome());
						pessoa.setEmail(listaPessoas.get(i).getEmail());
						pessoa.setTelefone(listaPessoas.get(i).getTelefone());
						pessoa.setDataNacimento(listaPessoas.get(i).getDataNacimento());
						pessoa.setCidade(listaPessoas.get(i).getCidade());
						pessoa.setEstado(listaPessoas.get(i).getEstado());
					}
				}

				pessoa.setNome(
						JOptionPane.showInputDialog("Informe o novo nome da Pessoa( " + pessoa.getNome() + "):"));
				pessoa.setEmail(
						JOptionPane.showInputDialog("Informe o  novo email da Pessoa(" + pessoa.getEmail() + "):"));
				pessoa.setTelefone(Integer.parseInt(JOptionPane
						.showInputDialog("Informe o novo telefone da Pessoa(" + pessoa.getTelefone() + "):")));
				pessoa.setDataNacimento(
						formato.parse(JOptionPane.showInputDialog("Informe a nova data de Nascimento(dd/mm/aaaa)("
								+ formato.format(pessoa.getDataNacimento()) + "):")));
				pessoa.setCidade(JOptionPane.showInputDialog("Informe a nova cidade(" + pessoa.getCidade() + "):"));
				pessoa.setEstado(JOptionPane.showInputDialog("Informe a nova estado(" + pessoa.getEstado() + "):"));
				listaPessoas.set(indexPessoa, pessoa);
				JOptionPane.showMessageDialog(null, "Pessoa alterada!!!\n" + pessoa);

			}
			
			if(response==3) {
				nome = JOptionPane.showInputDialog("Digite o nome para remover: ");
				Pessoa pessoa = new Pessoa();
				boolean tem = false;
				int indexPessoa = 0;
				for (int i = 0; i < listaPessoas.size(); i++) {
					if (listaPessoas.get(i).getNome().equals(nome)) {
						tem = true;
						indexPessoa=i;
						pessoa.setNome(listaPessoas.get(i).getNome());
						pessoa.setEmail(listaPessoas.get(i).getEmail());
						pessoa.setTelefone(listaPessoas.get(i).getTelefone());
						pessoa.setDataNacimento(listaPessoas.get(i).getDataNacimento());
						pessoa.setCidade(listaPessoas.get(i).getCidade());
						pessoa.setEstado(listaPessoas.get(i).getEstado());
					}
				}
				if (tem) {
					String remover = JOptionPane.showInputDialog("Deseja realmente remover o contato(S/N):\n"+ pessoa);
					if(Character.toLowerCase(remover.charAt(0))=='s'){
						listaPessoas.remove(indexPessoa);
						JOptionPane.showMessageDialog(null, "Contato removido com sucesso!");
						
					}else {
						JOptionPane.showMessageDialog(null, "Remover contato Cancelado!");
					}
					
					
					tem = false;
				} else {
					JOptionPane.showMessageDialog(null, "Pessoa não encontrada");
				}
								
				
			}
			
			if(response==4) {
				String listaAniversariantes="\nLista de aniversariantes: \n";
				LocalDate localDate= LocalDate.now();
				Pessoa pessoa = new Pessoa();
				boolean tem=false;
				for (int i = 0; i < listaPessoas.size(); i++) {
					if((listaPessoas.get(i).getDataNacimento().getMonth()+1)==localDate.getMonthValue()) {
						listaAniversariantes+=listaPessoas.get(i).getNome()+"\n";
						tem=true;
					}
				}
				if(tem) {
					JOptionPane.showMessageDialog(null, listaAniversariantes);
				}else {
					JOptionPane.showMessageDialog(null, "Nem um aninversariante neste mês!!!");
				}
			
				
				
				System.out.println(localDate.getMonthValue());
			}
			
			for (int i = 0; i < listaPessoas.size(); i++) {
				System.out.println(listaPessoas.get(i));
			}

			if (response == 5 || response == -1) {
				sair = false;
			}
		}

	}

}
