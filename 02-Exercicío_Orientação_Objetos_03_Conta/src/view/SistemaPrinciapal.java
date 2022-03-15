package view;

import java.awt.JobAttributes;

import javax.swing.JOptionPane;

import ClassesDAO.ContaDAO;
import modelo.Conta;
import modelo.Login;

public class SistemaPrinciapal {

	public static void main(String[] args) {
		Conta conta = new Conta();
		ContaDAO contaDAO = new ContaDAO();
		contaDAO.addlista(conta);
		Login login = new Login();
		String log = JOptionPane.showInputDialog("Digite o login:");
		int senha = Integer.parseInt(JOptionPane.showInputDialog("Digite a senha:"));
		boolean verifica = login.autenticacao(log, senha);
		double valor;
		
		while(verifica) {
			int id_conta=login.buscarIdConta(log,senha);
			conta=contaDAO.buscaConta(id_conta);
			int acao = Integer.parseInt(JOptionPane.showInputDialog("Numero conta: "+conta.getNumeroConta()+
					" - Tipo da Conta: "+conta.getTipoConta()+" - Correntista: "+conta.getCorrentiista()
					+"\nSaldo: "+conta.getSaldo()+"\n1-Sacar\n2-Depositar\n3-Extrato\n4-Sair"));
			switch(acao) {
			case 1:{
				valor = Double.parseDouble(JOptionPane.showInputDialog("Digite quanto deseja sacar"));
				boolean temsaldo = contaDAO.verifaSaldo(id_conta,valor);
				if(temsaldo) {
					contaDAO.sacar(id_conta,valor);
					JOptionPane.showMessageDialog(null,"Saque efetuado!!!");
				}else {
					JOptionPane.showMessageDialog(null, "Saldo Insuficiente!!!!");
				}
								
				break;
			}
			case 2:{
				valor = Double.parseDouble(JOptionPane.showInputDialog("Digite quanto deseja depositar"));
				contaDAO.depositar(id_conta,valor);
				JOptionPane.showMessageDialog(null,"Deposito efetuado!!!");
				break;
			}
			case 3 :{
				JOptionPane.showMessageDialog(null,contaDAO.buscaExtrato());
				
				break;
			}
			case 4:{
				verifica=false;
				break;
			}
			default:
				
			}
			
			
			
			
			
		}
	}

}
