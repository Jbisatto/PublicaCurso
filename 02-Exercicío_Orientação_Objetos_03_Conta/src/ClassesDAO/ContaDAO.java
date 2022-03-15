package ClassesDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import modelo.Conta;

public class ContaDAO {

	static ArrayList<Conta> listaConta = new ArrayList<>();
	static String extrato = "Extrato:\n";

	public void addlista(Conta conta) {
		listaConta.add(conta);

	}

	public Conta buscaConta(int id_conta) {
		return listaConta.get(id_conta);
	}

	public boolean verifaSaldo(int id_conta, double sacar) {
		return (listaConta.get(id_conta).getSaldo() >= sacar) ? true : false;
	}

	public void sacar(int id_conta, double valor) {
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		extrato += hora + "-" + data + " valor: " + valor + "- Saque\n ";
		listaConta.get(id_conta).setSaldo(listaConta.get(id_conta).getSaldo() - valor);

	}

	public void depositar(int id_conta, double valor) {
		Date dataHoraAtual = new Date();
		String data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
		String hora = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
		extrato += hora + "-" + data + " valor: " + valor + "- Deposito\n ";
		listaConta.get(id_conta).setSaldo(listaConta.get(id_conta).getSaldo() + valor);

	}

	public String buscaExtrato() {
		
		return extrato;
	}

}
