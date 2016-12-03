package com.indhio.architecture.exceptions.adapter;

import java.io.Serializable;

/**
 * @author Vinicius Nascimento
 */
public abstract class AbstractExceptionMessageAdapter implements ExceptionMessageAdapter, Serializable {

	private static final long serialVersionUID = -5542763765223902664L;

	protected ExceptionAdapterContext context;

	@Override
	public void setContext(ExceptionAdapterContext context) {
		this.context = context;
	}

}
