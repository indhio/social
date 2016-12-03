package com.indhio.architecture.exceptions.adapter;

import java.io.Serializable;

import com.indhio.architecture.exceptions.message.Message;

/**
 * @author Vinicius Nascimento
 */
public interface ExceptionMessageAdapter extends Serializable {

	void setContext(ExceptionAdapterContext context);

	Message adapt(Throwable e);
}
