package com.indhio.architecture.exceptions;

import com.indhio.architecture.exceptions.message.Message;

public class SecurityException extends SystemException {

	private static final long serialVersionUID = 6873368677674193752L;

	private Message messageObj;

	public SecurityException() {
		super();
	}

	public SecurityException(String message) {
		super(message);
	}

	public SecurityException(Throwable cause) {
		super(cause);
	}

	public SecurityException(String message, Throwable cause) {
		super(message, cause);
	}

	public SecurityException(Message messageObj) {
		this.messageObj = messageObj;
	}

	public Message getMessageObj() {
		return messageObj;
	}
}
