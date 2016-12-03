package com.indhio.architecture.exceptions.message;

import java.io.Serializable;

/**
 * Representa uma mensagem.
 * 
 * @author Vinicius Nascimento
 *
 */
public class Message implements Serializable {

	private static final long serialVersionUID = -7068610434721512579L;

	private String code;
	private String message;
	private MessageType type;
	private String detail;
	private String messageProperties;

	public Message() {
		this.type = MessageType.DANGER;
	}

	public Message(String code, String message) {
		this();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getMessageProperties() {
		return messageProperties;
	}

	public void setMessageProperties(String messageProperties) {
		this.messageProperties = messageProperties;
	}
}
