package acao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CalculoDias {

	public double redimentoPoupanca = 0, redimentoLCI = 0, redimentoCDB = 0;

	/**
	 * Retorna a quantidade de dias uteis ou total de dia referente ao mes
	 * informado, se o tipo for T iria retornar o total
	 * 
	 * @param mes
	 * @param tipo
	 * @return
	 */

	public int diasTotalUteis(int mes, char tipo) {
		int qtdTotal = 0, qtdDiaUteis = 0;
		Calendar dataInicial = Calendar.getInstance();
		Calendar dataFinal = Calendar.getInstance();
		dataFinal.setTime(dataInicial.getTime());
		dataFinal.add(Calendar.MONTH, mes);

		while (dataInicial.before(dataFinal)) {
			if (verificaFimSemana(dataInicial))
				qtdDiaUteis++;
			qtdTotal++;
			dataInicial.add(Calendar.DATE, 1);
		}
		if (tipo == 'T') {
			return qtdTotal;
		} else {
			return qtdDiaUteis;
		}

	}

	/**
	 * verifica se o dia é um fim de semana
	 * 
	 * @param dataInicial
	 * @return
	 */
	public boolean verificaFimSemana(Calendar dataInicial) {
		if (dataInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY
				&& dataInicial.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
			if (verificaFeriado(dataInicial)) {
				return true;
			}
		}
		return false;
	}

	
	/**
	 * Verifica se o dia é um feriado
	 * @param dataInicial
	 * @return
	 */
	public boolean verificaFeriado(Calendar dataInicial) {
		for (Calendar data : listaFeriado()) {
			if (data.get(Calendar.DATE) == dataInicial.get(Calendar.DATE)
					&& data.get(Calendar.MONTH) == dataInicial.get(Calendar.MONTH)) {
				return false;
			}
		}

		return true;
	}

	public List<Calendar> listaFeriado() {
		List<Calendar> feriados = new ArrayList<>();
		feriados.add(new GregorianCalendar(0, 0, 1));
		feriados.add(new GregorianCalendar(0, 1, 20));
		feriados.add(new GregorianCalendar(0, 1, 21));
		feriados.add(new GregorianCalendar(0, 3, 15));
		feriados.add(new GregorianCalendar(0, 3, 21));
		feriados.add(new GregorianCalendar(0, 4, 1));
		feriados.add(new GregorianCalendar(0, 5, 16));
		feriados.add(new GregorianCalendar(0, 8, 7));
		feriados.add(new GregorianCalendar(0, 9, 12));
		feriados.add(new GregorianCalendar(0, 10, 2));
		feriados.add(new GregorianCalendar(0, 10, 15));
		feriados.add(new GregorianCalendar(0, 11, 25));

		return feriados;
	}

}
