package com.indhio.architecture.exceptions.message;

/**
 * @author Vinicius Nascimento
 */
public class MessageProvider {

	public Message buildMessage(String code, MessageType type, String text, String detail) {
		Message message = new Message();
		message.setCode(code);
		message.setType(type);
		message.setMessage(text);
		message.setDetail(detail);
		return message;
	}

	public Message warn(String text) {
		return buildMessage(null, MessageType.WARNING, text, null);
	}

	public Message warn(String code, String text) {
		return buildMessage(code, MessageType.WARNING, text, null);
	}

	public Message warn(String code, String text, String detail) {
		return buildMessage(code, MessageType.WARNING, text, detail);
	}

	public Message danger(String text) {
		return buildMessage(null, MessageType.DANGER, text, null);
	}

	public Message danger(String code, String text) {
		return buildMessage(code, MessageType.DANGER, text, null);
	}

	public Message danger(String code, String text, String detail) {
		return buildMessage(code, MessageType.DANGER, text, detail);
	}

	public Message info(String text) {
		return buildMessage(null, MessageType.INFO, text, null);
	}

	public Message info(String code, String text) {
		return buildMessage(code, MessageType.INFO, text, null);
	}

	public Message info(String code, String text, String detail) {
		return buildMessage(code, MessageType.INFO, text, detail);
	}

	public Message success(String text) {
		return buildMessage(null, MessageType.SUCCESS, text, null);
	}

	public Message success(String code, String text) {
		return buildMessage(code, MessageType.SUCCESS, text, null);
	}

	public Message success(String code, String text, String detail) {
		return buildMessage(code, MessageType.SUCCESS, text, detail);
	}
}
