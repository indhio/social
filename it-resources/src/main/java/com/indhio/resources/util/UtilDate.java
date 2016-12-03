package com.indhio.resources.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * @author eduardo.ribeiro
 */
public final class UtilDate {

	private static final int MILLIS_DIA = 86400000;
	private static final int MILLIS_MINUTO = 60000;
	public static final int DIA = 1;
	public static final int MES = 2;
	public static final int ANO = 3;
	public static final int SABADO = 7;
	private static final int NUM_MINUTO_HORA = 60;
	public static final int NUM_HORAS_DIA = 24;
	public static final int NUM_DIAS_ANO = 365;
	public static final int NUM_DIAS_MES = 30;
	public static final int AMOUNT = -3;
	private static final Locale LOCALE_PT_BR = new Locale("pt", "BR");

	/**
	 * @param value
	 *          data a ser formatada.
	 * @return Data no formato String dd/MM/yyyy
	 */
	public static String formatSimpleDate(Date value) {
		return formatDate(value, "dd/MM/yyyy");
	}

	/**
	 * Retorna a data no formato String de acordo com o pattern passado como parametro.
	 * 
	 * @param value
	 *          - data a ser transformada.
	 * @param pattern
	 *          - padrao para a transformacaoo da data em String.
	 * @return data como String no padrao enviado.
	 */
	public static String formatDate(Date value, String pattern) {
		if (value != null) {
			DateFormat f = new SimpleDateFormat(pattern, LOCALE_PT_BR);
			f.setLenient(false);
			return f.format(value);
		} else {
			return "";
		}
	}

	/**
	 * 
	 * @return Data atual no formato definido pelo metodo formatSimpleDate
	 */
	public static String todayAsString() {
		return formatSimpleDate(new Date());
	}

	/**
	 * 
	 * 
	 * @param value
	 *          - valor a ser convertido.
	 * @return Objeto Date com formato dd/MM/yyyy
	 * @throws ParseException
	 *           - excessao disparada se caso o parse nao seja bem sucedido
	 */
	public static Date toSimpleDate(String value) throws ParseException {
		DateFormat f = new SimpleDateFormat("dd/MM/yyyy", LOCALE_PT_BR);
		f.setLenient(false);
		return f.parse(value);
	}

	/**
	 * Validacao de datas de acordo com um formato
	 * 
	 * @param value
	 *          - valor a ser validado.
	 * @param format
	 *          - formato de data o qual o valor deve ser validado.
	 * @return true para uma data valida ou false para uma data invalida.
	 */
	public static boolean isDateValid(String value, String format) {
		try {
			DateFormat f = new SimpleDateFormat(format, LOCALE_PT_BR);
			f.setLenient(false);
			f.parse(value);

			return true;
		} catch (ParseException e) {
			return false;
		}
	}

	/**
	 * Validacao de datas de acordo com o padrao dd/MM/yyyy
	 * 
	 * @param value
	 *          - valor a ser verificado se representa uma data valida ou nao.
	 * @return true - data valida
	 */
	public static boolean isDateValid(String value) {
		return isDateValid(value, "dd/MM/yyyy");
	}

	/**
	 * Verifica se uma data e igual a data atual (hoje). O teste compara o ano, o mes e o dia.
	 * 
	 * @param date
	 *          - data a ser verificada se e igual a data atual.
	 * @return true se a data passada como parametro for igual a data atual.
	 */
	public static boolean isToday(Date date) {
		Calendar hoje = Calendar.getInstance();

		Calendar param = new GregorianCalendar();
		param.setTime(date);

		return (hoje.get(Calendar.DAY_OF_MONTH) == param.get(Calendar.DAY_OF_MONTH) && hoje.get(Calendar.MONTH) == param.get(Calendar.MONTH) && hoje.get(Calendar.YEAR) == param.get(Calendar.YEAR));
	}

	/**
	 */
	private UtilDate() {

	}

	/**
	 * @param dataStr
	 *          - data no formato string
	 * @return Date - Retorna o objeto Date correspondente ao string passado como parametro
	 * @throws ParseException
	 *           - excessao disparada caso o parse nao seja bem sucedido.
	 */
	public static Date toDate(String dataStr) throws ParseException {
		SimpleDateFormat df = null;
		Date data = null;
		if (dataStr != null && !dataStr.equals("")) {
			df = new SimpleDateFormat("dd/MM/yyyy", LOCALE_PT_BR);
			data = df.parse(dataStr);
		}
		return data;
	}

	/**
	 * @param dataStr
	 *          - data no formato string.
	 * @param pattern
	 *          - formato que tera o object Date retornado.
	 * @return Date - Retorna o objeto Date correspondente ao string passado como parametro
	 * @throws ParseException
	 *           - excessao disparada caso o parse nao seja bem sucedido.
	 */
	public static Date toDate(String dataStr, String pattern) throws ParseException {
		SimpleDateFormat df = null;
		Date data = null;
		if (dataStr != null && !dataStr.equals("")) {
			df = new SimpleDateFormat(pattern, LOCALE_PT_BR);
			data = df.parse(dataStr);
		}
		return data;
	}

	/**
	 * Converte um java.util.Date em um Calendar.
	 * 
	 * @param data
	 *          - objeto java.util.Date a ser convertido.
	 * @return data convertida para o um objeto do tipo Calendar
	 */
	public static Calendar toCalendar(Date data) {
		if (data != null) {
			Calendar result = Calendar.getInstance();
			result.setTime(data);

			return result;
		} else {
			return null;
		}
	}

	/**
	 * Converte um texto representando uma data completa para um java.util.Date
	 * 
	 * @param completeDateStr
	 *          - String representando uma data completa
	 * @return objeto do tipo java.util.Date.
	 * @throws ParseException
	 *           - excessao disparada caso o parse nao seja bem sucedido.
	 */
	public static Date toDateHour(String completeDateStr) throws ParseException {
		SimpleDateFormat df = null;
		Date data = null;
		if (completeDateStr != null && !completeDateStr.equals("")) {
			df = new SimpleDateFormat("dd/MM/yyyy HH:mm", LOCALE_PT_BR);
			data = df.parse(completeDateStr);
		}
		return data;
	}

	/**
	 * Dado um data base, obtem um Timestamp com a data no primeiro milisegundo da data em questao.
	 * 
	 * @param dataBase
	 *          - data usada como base para obtencao do Timestamp com o primeiro milisegundo.
	 * @return objeto do tipo timestamp contendo a data no primeiro milisengudo da data passada como parametro.
	 */
	public static Timestamp getMinDateTime(java.util.Date dataBase) {
		Calendar c = Calendar.getInstance();
		c.setTime(dataBase);

		/*
		 * Seta os campos de hora para ZERO
		 */
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return new Timestamp(c.getTimeInMillis());
	}

	/**
	 * Retorna os dias existentes entre duas datas.
	 * 
	 * @param dateStart
	 *          - data inicial
	 * @param dateEnd
	 *          - data final
	 * @return numero de dias existentes entre duas datas
	 * @throws Exception
	 *           - excessao disparada caso ocorra alguma falha.
	 */
	public static long getDaysBetweenDates(Date dateStart, Date dateEnd) throws Exception {
		long dias = 0;

		if (dateStart != null && dateStart != null) {
			dias = Math.abs(dateStart.getTime() - dateEnd.getTime()) / MILLIS_DIA;
		} else {
			throw new Exception("Data informada esta nula.");
		}

		return dias;
	}

	public static String getTimeBetweenDates(Date dateStart, Date dateEnd) throws Exception {
		long time = 0;
		String tipo = "minuto(s)";

		if (dateStart != null && dateStart != null) {
			time = (dateStart.getTime() - dateEnd.getTime()) / MILLIS_MINUTO;
			if (time >= NUM_MINUTO_HORA) {
				time = time / NUM_MINUTO_HORA;
				tipo = "hora(s)";
				if (time >= NUM_HORAS_DIA) {
					time = time / NUM_HORAS_DIA;
					tipo = "dia(s)";
					if (time >= NUM_DIAS_ANO) {
						time = time / NUM_DIAS_ANO;
						tipo = "ano(s)";
					}
				}
			}
		} else {
			throw new Exception("Data informada esta nula.");
		}

		return time + " " + tipo;
	}

	public static int getYearsBetweenDates(Date dateStart, Date dateEnd) {
		Calendar cStart = toCalendar(dateStart);
		Calendar cEnd = toCalendar(dateEnd);

		int anoStart = cStart.get(Calendar.YEAR);
		int anoEnd = cEnd.get(Calendar.YEAR);

		int ret = anoEnd - anoStart - 1;

		if (ret > 0) {
			int mesStart = cStart.get(Calendar.MONTH);
			int mesEnd = cEnd.get(Calendar.MONTH);

			if (mesEnd > mesStart) {
				return ret + 1;
			} else if (mesStart == mesEnd) {
				int diaStart = cStart.get(Calendar.DAY_OF_MONTH);
				int diaEnd = cEnd.get(Calendar.DAY_OF_MONTH);

				if (diaEnd >= diaStart) {
					return ret + 1;
				} else {
					return ret;
				}
			} else {
				return ret;
			}
		} else {
			return ret;
		}
	}

	/**
	 * 
	 * @param date
	 * @return Data de um ano atras da data passada como parametro
	 */
	public static Date diminuiUmAno(Date date) {
		Calendar data = toCalendar(date);

		int ano = data.get(Calendar.YEAR);
		ano--;
		data.set(Calendar.YEAR, ano);

		return data.getTime();
	}

	public static Date somaDias(Date data, int quantidadeDeDias) {
		return somaCampo(Calendar.DAY_OF_MONTH, data, quantidadeDeDias);
	}

	public static Date somaMeses(Date data, int numeroDeMeses) {
		return somaCampo(Calendar.MONTH, data, numeroDeMeses);
	}

	public static Date somaAnos(Date data, int numeroDeAnos) {
		return somaCampo(Calendar.YEAR, data, numeroDeAnos);
	}

	public static Date somaCampo(int campo, Date data, int quantidade) {
		Calendar calendar = getCalendarDaData(data);
		calendar.add(campo, quantidade);
		return calendar.getTime();
	}

	protected static Calendar getCalendarDaData(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		return calendar;
	}

	/**
	 * Converte um Date em um Timestamp.
	 * 
	 * @param date
	 *          - Data a ser convertida
	 * @return data convertida em um Timestamp
	 * @throws ParseException
	 *           - excessao disparada caso o parse nao seja bem sucedido.
	 */
	public static Timestamp toTimestamp(Date date) throws ParseException {
		return new Timestamp(date.getTime());
	}

	/**
	 * Verifica se data e depois de hoje.
	 * 
	 * @param date
	 *          - objeto do tipo date a ser verificado se e depois da data atual.
	 * @return true se a data passada como parametro e depois de hoje e false caso contrario.
	 */
	public static boolean isDateAfterToday(final Date date) {
		if (date != null) {
			Date today = getCurrentDay();
			return date.after(today);
		}
		return false;
	}

	/**
	 * Verifica se data e depois de hoje.
	 * 
	 * @param date
	 *          - objeto do tipo date a ser verificado se e depois da data atual.
	 * @param pattern
	 *          - formato da data e hora
	 * @return true se a data passada como parametro e depois de hoje e false caso contrario.
	 */
	public static boolean isDateAfterToday(final Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern, LOCALE_PT_BR);
		if (date != null) {
			Date today = new Date();
			sdf.format(today);
			return date.after(today);
		}
		return false;
	}

	/**
	 * Verifica se data e depois de hoje.
	 * 
	 * @param dateStr
	 *          - String de data a ser verificada se e depois da data atual.
	 * @return true se a data passada como parametro e depois de hoje e false caso contrario.
	 * @throws ParseException
	 *           - excessao disparada caso o parse nao seja bem sucedido.
	 */
	public static boolean isDateAfterToday(final String dateStr) throws ParseException {
		Date date = UtilDate.toDate(dateStr);
		return isDateAfterToday(date);
	}

	/**
	 * Retorna a data de hoje sem hora.
	 * 
	 * @return hoje ddMMyyyy
	 */
	public static Date getCurrentDay() {
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.HOUR_OF_DAY, 0);
		calendario.set(Calendar.MINUTE, 0);
		calendario.set(Calendar.SECOND, 0);
		calendario.set(Calendar.MILLISECOND, 0);

		return calendario.getTime();
	}

	/**
	 * Atualiza o dia do mes, mes e ano de um objeto Calendar a partir de um java.util.Date.
	 * 
	 * @param c
	 *          - objeto do tipo Calendar o qual sera atualizado o dia do mes, mes e ano.
	 * @param date
	 *          - objeto do tipo Date com o dia do mes, mes e ano a serem atualizados no objeto Calendar.
	 */
	public static void setDate(Calendar c, Date date) {
		Calendar aux = Calendar.getInstance();
		aux.setTime(date);

		c.set(Calendar.DAY_OF_MONTH, aux.get(Calendar.DAY_OF_MONTH));
		c.set(Calendar.MONTH, aux.get(Calendar.MONTH));
		c.set(Calendar.YEAR, aux.get(Calendar.YEAR));
	}

	/**
	 * Atualiza a hora, minuto, segundo e milisegundo de um objeto Calendar baseado num java.util.Date.
	 * 
	 * @param c
	 *          - objeto do tipo Calendar o qual sera atualizado com hora, minuto, segundo e milisegundos.
	 * @param time
	 *          - objeto do tipo Date com a hora, minuto, segundo e milisegundo a serem atualizados no objeto Calendar.
	 */
	public static void setTime(Calendar c, Date time) {
		Calendar aux = Calendar.getInstance();
		aux.setTime(time);

		c.set(Calendar.HOUR_OF_DAY, aux.get(Calendar.HOUR_OF_DAY));
		c.set(Calendar.MINUTE, aux.get(Calendar.MINUTE));
		c.set(Calendar.SECOND, aux.get(Calendar.SECOND));
		c.set(Calendar.MILLISECOND, aux.get(Calendar.MILLISECOND));
	}

	/**
	 * Atualiza o dia do mes, mes, ano, hora, minuto, segundo e milisegundo de um objeto Calendar a partir de um Date.
	 * 
	 * @param c
	 *          - objeto do tipo Calendar o qual sera atualizado.
	 * @param date
	 *          - objeto do tipo Date com o dia do mes, mes e ano a serem atualizados no objeto Calendar.
	 * @param time
	 *          - objeto do tipo Date com a hora, minuto, segundo e milisegundo a serem atualizados no objeto Calendar.
	 */
	public static void setDateTime(Calendar c, Date date, Date time) {
		setDate(c, date);
		setTime(c, time);
	}

	/**
	 * Retorna um java.sql.Timestamp baseado na data/hora corrente.
	 * 
	 * @return Objeto java.sql.Timestamp baseado na data/hora corrente.
	 */
	public static Timestamp getActualTimestamp() {
		Date date = new Date();

		return new Timestamp(date.getTime());
	}

	/**
	 * Verifica se a data e fim de semana.
	 * 
	 * @param data
	 *          - Objeto do tipo Date a ser verificada se e uma data de fim de semana ou neo.
	 * @return true se a data passada como parametro e fim de semana.
	 */
	public static boolean isWorkDay(Date data) {
		Calendar c = Calendar.getInstance();
		c.setTime(data);

		int diaSemana = c.get(Calendar.DAY_OF_WEEK);

		return (diaSemana == 1 || diaSemana == SABADO);

	}

	/**
	 * @param date
	 *          - Objeto do tipo java.sql.Date a ser convertido em um objeto java.util.Date.
	 * @return Objeto java.util.Date.
	 */
	public static Date toDate(java.sql.Date date) {
		if (date != null) {
			return new Date(date.getTime());
		} else {
			return null;
		}
	}

	/**
	 * @param date
	 *          - Objeto do tipo java.util.Date a ser convertido em um objeto java.sql.Date.
	 * @return Objeto java.sql.Date
	 */
	public static java.sql.Date toSqlDate(Date date) {
		if (date != null) {
			return new java.sql.Date(date.getTime());
		} else {
			return null;
		}
	}

	/**
	 * Seta todas as informacoes de hora para ZERO.
	 * 
	 * @param date
	 * @return
	 */
	public static Date resetTimeInfo(Date date) {
		Calendar c = toCalendar(date);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);

		return c.getTime();
	}

	/**
	 * Seta todas as informacoes de hora para a ultima hora do dia.
	 * 
	 * @param date
	 *          Data
	 * @return data com a hora atualizada.
	 */
	public static Date ajustarParaUltimaHora(Date date) {
		Calendar c = toCalendar(date);
		c.set(Calendar.HOUR, 11);
		c.set(Calendar.HOUR_OF_DAY, 23);
		c.set(Calendar.MINUTE, 59);
		c.set(Calendar.SECOND, 59);
		c.set(Calendar.MILLISECOND, 0);

		return c.getTime();
	}

	public static int getAno(Date data) {
		if (data == null) {
			return -1;
		}

		String ano = getDataComoString(data, "yyyy");
		return Integer.parseInt(ano);
	}

	public static int getAnoAtual() {
		return getAno(getDataAtual());
	}

	public static Date getDataAtual() {
		return new Date();
	}

	public static String getDataComoString(Date data, String formatoDaData) {
		if (data == null) {
			return "";
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat(formatoDaData, LOCALE_PT_BR);
		return dateFormat.format(data);
	}

	public static Date getDataUltimoDiaDoAno() {
		Calendar calendario = Calendar.getInstance();
		calendario.set(getAnoAtual(), Calendar.DECEMBER, 31);
		return calendario.getTime();
	}

	public static boolean isDataMenorOuIgual(Date data, Date dataComparativa) {
		return (data.compareTo(dataComparativa) <= 0);
	}

	public static boolean isDataMenor(Date data, Date dataComparativa) {
		return (data.compareTo(dataComparativa) < 0);
	}

	public static boolean isDataMaior(Date data, Date dataComparativa) {
		return (data.compareTo(dataComparativa) > 0);
	}

	public static boolean isDataMaiorOuIgual(Date data, Date dataComparativa) {
		return (data.compareTo(dataComparativa) >= 0);
	}

	public static boolean isDataIgual(Date data, Date dataComparativa) {
		return (data.compareTo(dataComparativa) == 0);
	}

	public static String retornarDiaSemana(Date data) {

		String nomeDiaSemana = null;
		String retorno = new String();

		if (data != null) {
			SimpleDateFormat f = new SimpleDateFormat("EEE");
			nomeDiaSemana = f.format(data);
		}
		if (nomeDiaSemana != null) {
			if (nomeDiaSemana.equalsIgnoreCase("dom") || nomeDiaSemana.equalsIgnoreCase("sun")) {
				retorno = "Domingo";
			} else if (nomeDiaSemana.equalsIgnoreCase("seg") || nomeDiaSemana.equalsIgnoreCase("mon")) {
				retorno = "Segunda";
			} else if (nomeDiaSemana.equalsIgnoreCase("ter") || nomeDiaSemana.equalsIgnoreCase("tue")) {
				retorno = "Terça";
			} else if (nomeDiaSemana.equalsIgnoreCase("qua") || nomeDiaSemana.equalsIgnoreCase("wed")) {
				retorno = "Quarta";
			} else if (nomeDiaSemana.equalsIgnoreCase("qui") || nomeDiaSemana.equalsIgnoreCase("thu")) {
				retorno = "Quinta";
			} else if (nomeDiaSemana.equalsIgnoreCase("sex") || nomeDiaSemana.equalsIgnoreCase("fri")) {
				retorno = "Sexta";
			} else if (nomeDiaSemana.equalsIgnoreCase("sab") || nomeDiaSemana.equalsIgnoreCase("sáb") || nomeDiaSemana.equalsIgnoreCase("sat")) {
				retorno = "Sábado";
			}
		}
		return retorno;
	}

}