package com.indhio.architecture.exceptions;

import com.indhio.architecture.exceptions.message.Message;

/**
 * @author Vinicius Nascimento
 */
public class SystemException extends RuntimeException {

	private static final long serialVersionUID = 8080551472318323163L;

	private Message messageObj;

	public SystemException() {
		super();
	}

	public SystemException(String message) {
		super(message);
	}

	public SystemException(Throwable cause) {
		super(cause);
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemException(Message messageObj) {
		this.messageObj = messageObj;
	}

	public Message getMessageObj() {
		return messageObj;
	}
}
