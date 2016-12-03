package com.indhio.architecture.exceptions.adapter;

import org.apache.commons.lang3.exception.ExceptionUtils;

import com.indhio.architecture.exceptions.message.Message;
import com.indhio.architecture.exceptions.message.MessageType;

/**
 * Adaptador padrao para implementar um objeto Message padrão para a exception.
 *
 * @author Vinicius Nascimento
 */
public class DefaultExceptionMessageAdapter extends AbstractExceptionMessageAdapter implements ExceptionMessageAdapter {

	private static final long serialVersionUID = -2049702098084826407L;

	@Override
	public Message adapt(Throwable e) {
		Message ret = new Message();
		ret.setMessage(e.getMessage());
		ret.setCode("500");
		ret.setType(MessageType.DANGER);
		ret.setDetail(ExceptionUtils.getStackTrace(e));
		return ret;
	}

}
