package com.indhio.architecture.exceptions.adapter;

import java.io.Serializable;

/**
 * @author Vinicius Nascimento
 */
public class ExceptionAdapterContext implements Serializable {

	private static final long serialVersionUID = -5966684881604387166L;

	private boolean resolved;

	public boolean isResolved() {
		return resolved;
	}

	public void setResolved() {
		this.resolved = true;
	}
}
