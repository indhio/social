package com.indhio.architecture.exceptions.adapter;

import com.indhio.architecture.exceptions.SecurityException;
import com.indhio.architecture.exceptions.SystemException;
import com.indhio.architecture.exceptions.message.Message;

/**
 * @author Vinicius Nascimento
 */
public class SystemExceptionMessageAdapter extends AbstractExceptionMessageAdapter implements ExceptionMessageAdapter {

	private static final long serialVersionUID = -3948321853898519555L;

	@Override
	public Message adapt(Throwable e) {
		if (e instanceof SystemException) {
			SecurityException securityException = (SecurityException) e;
			if (securityException.getMessageObj() != null) {
				context.setResolved();
				return securityException.getMessageObj();
			}
		}
		return null;
	}
}
