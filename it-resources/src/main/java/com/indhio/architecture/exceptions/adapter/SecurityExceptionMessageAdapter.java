package com.indhio.architecture.exceptions.adapter;

import com.indhio.architecture.exceptions.SystemException;
import com.indhio.architecture.exceptions.message.Message;

/**
 * @author Vinicius Nascimento
 */
public class SecurityExceptionMessageAdapter extends AbstractExceptionMessageAdapter implements ExceptionMessageAdapter {

	private static final long serialVersionUID = -2479474033160437402L;

	@Override
	public Message adapt(Throwable e) {
		if (e instanceof SystemException) {
			SystemException systemException = (SystemException) e;

			if (systemException.getMessageObj() != null) {
				context.setResolved();
				return systemException.getMessageObj();
			}
		}

		return null;
	}
}
