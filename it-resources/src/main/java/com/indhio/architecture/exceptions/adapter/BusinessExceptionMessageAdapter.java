package com.indhio.architecture.exceptions.adapter;

import com.indhio.architecture.exceptions.message.Message;
import com.indhio.architecture.exceptions.message.MessageType;

/**
 * @author Vinicius Nascimento
 */
public class BusinessExceptionMessageAdapter extends AbstractExceptionMessageAdapter implements ExceptionMessageAdapter {

	private static final long serialVersionUID = -8450563551554482574L;

	@Override
	public Message adapt(Throwable e) {
		Message ret = new Message();
		ret.setMessage(e.getMessage());
		ret.setType(MessageType.INFO);
		return ret;
	}

}
