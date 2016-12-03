package com.indhio.resources.util;

public final class UtilString {

	public static String RETICENCIAS = "...";

	private final static String pattern_html = "\\<\\/?[^\\/\\>]*\\/?\\>|\\n";
	private final static String PATTERN_TEXTO = "[^0-9]";

	private UtilString() {

	}

	public static boolean isEmpty(String text) {
		return text == null || text.trim().length() == 0;
	}

	/**
	 * Metodo que faz o substring e concatena "..." ao final da String.
	 * 
	 * @param string
	 * @param tamanho
	 * @param sufixo
	 * @return
	 */

	public static String truncaValoresDesformatandoHTML(String string, int tamanho, String sufixo) {
		string = string.replaceAll(pattern_html, "");
		if (string.length() > tamanho) {
			string = string.substring(0, tamanho);
			string = string.concat(sufixo);
		}

		return string;
	}

	public static String fixeSize(String original, int size) {
		if (original != null) {
			if (original.length() > size) {
				return original.substring(0, size);
			} else if (original.length() == size) {
				return original;
			} else {
				StringBuffer buf = new StringBuffer(original);
				for (int i = 0; i < size - original.length(); i++) {
					buf.append(" ");
				}

				return buf.toString();
			}
		} else {
			StringBuffer buf = new StringBuffer();
			for (int i = 0; i < size; i++) {
				buf.append(" ");
			}

			return buf.toString();
		}
	}

	public static String appendLeftZeros(String input, int size) {
		int qtd = size - input.length();
		String original = input;
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < qtd; i++) {
			buf.append("0");
		}

		return buf.toString() + original;
	}

	public static String removeLeftZeros(String input) {
		if (UtilString.isEmpty(input)) {
			return input;
		}

		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) != '0') {
				buf.append(input.substring(i));
				break;
			}
		}

		return buf.toString();
	}

	public static String removeRightBlankSpace(String texto) {
		if (texto != null && texto.length() > 0 && texto.indexOf(" ") >= 0) {
			int i = 0;
			// String ret = "";
			for (i = texto.length() - 1; i >= 0; i--) {
				if (!Character.isSpaceChar(texto.charAt(i))) {
					break;
				}
			}

			return new String(texto.substring(0, i + 1));
		}
		return new String(texto);
	}

	/**
	 * @param texto
	 * @return
	 */
	public static String removeLeftBlankSpace(String texto) {
		if (texto != null && texto.length() > 0 && texto.indexOf(" ") >= 0) {
			int i = 0;
			// String ret = "";
			for (; i <= texto.length() - 1; i++) {
				if (!Character.isSpaceChar(texto.charAt(i))) {
					break;
				}
			}

			return new String(texto.substring(i, texto.length()));
		}
		return new String(texto);
	}

	/**
	 * Baseado na String original retorna uma String apenas com os caracteres num�ricos.
	 * 
	 * @param original
	 * @return
	 */
	public static String removeNoNumbers(String original) {
		if (original != null) {
			StringBuilder buf = new StringBuilder();
			int len = original.length();
			char ch;

			for (int i = 0; i < len; i++) {
				ch = original.charAt(i);

				if (Character.isDigit(ch)) {
					buf.append(ch);
				}
			}

			return buf.toString();
		} else {
			return null;
		}
	}

	/**
	 * Remove a acentua��o de uma string.
	 * 
	 * @param string
	 *          string
	 * @return string sem acentos.
	 */
	// TODO: Finalizar este metodo
	/*
	 * public static String removeAccent(String string) { if (!isEmpty(string)) { string = substituirString(string, "[����]", "A"); string = substituirString(string, "[����]", "a"); string = substituirString(string, "[���]", "E"); string = substituirString(string, "[���]", "e"); string = substituirString(string, "[����]", "I"); string = substituirString(string, "[����]", "i"); string = substituirString(string, "[�����]", "O"); string = substituirString(string, "[�����]", "o"); string = substituirString(string, "[����]", "U"); string = substituirString(string, "[����]", "u"); string = substituirString(string, "�", "C"); string = substituirString(string, "�", "c"); } return string; }
	 */

	/**
	 * Retorna a string sem espa�os em branco.
	 * 
	 * @param text
	 * @return
	 */
	public static String trim(String text) {
		if (!isEmpty(text)) {
			text = text.trim();
		}
		return text;
	}

	public static String removeAll(char c, String s) {
		String resposta;
		StringBuffer buffer = new StringBuffer(s);
		int pos = 0;
		while (pos < buffer.length()) {
			if (buffer.charAt(pos) == c) {
				buffer.deleteCharAt(pos);
			} else {
				pos = pos + 1;
			}
		}
		resposta = buffer.toString();
		return resposta;
	}

	/**
	 * Remove os caracteres de uma string.
	 * 
	 * @param string
	 *          string
	 * @return string sem caracteres.
	 */
	public static String removerCaracteres(String string) {

		if (!isEmpty(string)) {
			string = string.replaceAll(PATTERN_TEXTO, "");
		}
		return string;
	}

	/**
	 * toString() gerantindo o null.
	 * 
	 * @param object
	 * @return
	 */
	public static String toString(Object object) {
		if (object != null) {
			return object.toString();
		} else {
			return "";
		}
	}

	public static String toUpperCase(String text) {
		if (isEmpty(text)) {
			return text;
		}

		return text.toUpperCase();
	}

	public static String toLowerCase(String text) {
		if (isEmpty(text)) {
			return text;
		}

		return text.toLowerCase();
	}

	public static String packageToResourceFormat(String original) {
		if (original != null) {
			String ret = original.replace('.', '/');

			if (!original.startsWith("/")) {
				ret = "/" + ret;
			}

			return ret;
		} else {
			return null;
		}
	}

	public static boolean existSubString(String content, String subString) {
		if (content.indexOf(subString) != -1)
			return true;
		return false;
	}

	public static String getStringComPrimeiraLetraMaiuscula(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

	/**
	 * Verifica se a String target est� presente na String source.
	 * 
	 * @param target
	 * @param source
	 * @return
	 */
	public static boolean isIn(String target, String source, boolean caseInsensitive) {
		if (!isEmpty(source) && !isEmpty(target)) {
			if (caseInsensitive) {
				source = source.toUpperCase();
				target = target.toUpperCase();
			}

			return source.indexOf(target) > -1;
		}

		return false;
	}

	/**
	 * Retorna a String com o tamanho m�ximo, ou seja, truca a String se necess�rio.
	 * 
	 * @param text
	 * @param max
	 * @return
	 */
	public static String trunc(String text, int max) {
		if (!isEmpty(text)) {
			if (text.length() > max) {
				return text.substring(0, max);
			}
		}

		return text;
	}

	/**
	 * @param valor
	 *          valor original.
	 * @param qteCaracteres
	 *          quantidade de caracteres que o valor deve possuir.
	 * @return verdadeiro se o valor possuir a quantidade de caracteres definido em @qteCaracteres.
	 */
	public static boolean isQteCaracteres(String valor, int qteCaracteres) {
		return !isEmpty(valor) && valor.length() == qteCaracteres;
	}
}
