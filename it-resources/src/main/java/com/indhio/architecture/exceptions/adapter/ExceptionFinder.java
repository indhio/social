package com.indhio.architecture.exceptions.adapter;

/**
 * @author Vinicius Nascimento
 */
public class ExceptionFinder {

	/**
	 * Erro.
	 */
	private Throwable error;

	/**
	 * Define o erro a ser trabalhado.
	 * 
	 * @param error
	 *           Erro
	 * @return
	 */
	public ExceptionFinder with(Throwable error) {
		this.error = error;

		return this;
	}

	/**
	 * Busca na pilha de erro um tipo especifico.
	 * 
	 * @param type
	 *           Tipo objetivo
	 * @return Erro
	 */
	public Throwable cause(Class<? extends Throwable> type) {
		return locateType(error, type);
	}

	/**
	 * Recupera a excecao causa.
	 *
	 * @return this
	 */
	public Throwable cause() {
		return cause(error);
	}

	private Throwable cause(Throwable error) {
		if (error.getCause() == null) {
			return error;
		}

		return cause(error.getCause());
	}

	private Throwable locateType(Throwable e, Class<? extends Throwable> type) {
		if (e.getClass() == type) {
			return e;
		} else {
			if (e.getCause() != null) {
				return locateType(e.getCause(), type);
			} else {
				return null;
			}
		}
	}
}
