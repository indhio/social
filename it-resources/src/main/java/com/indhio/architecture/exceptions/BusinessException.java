package com.indhio.architecture.exceptions;

import com.indhio.architecture.exceptions.message.Message;

/**
 * Representa excecao de negocio.
 * 
 * @author Vinicius Nascimento
 */
public class BusinessException extends Exception {

	private static final long serialVersionUID = -1843127229338175593L;

	private Message messageObj;

	public BusinessException() {
		super();
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}

	public BusinessException(Message messageObj, Throwable cause) {
		super(cause);
		this.messageObj = messageObj;

	}

	public BusinessException(Message messageObj) {
		this.messageObj = messageObj;
	}

	public Message getMessageObj() {
		return messageObj;
	}
}
