package com.indhio.architecture.exceptions.adapter;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Instance;
import javax.inject.Inject;

import com.indhio.architecture.exceptions.BusinessException;
import com.indhio.architecture.exceptions.SystemException;
import com.indhio.architecture.exceptions.message.Message;

/**
 * @author Vinicius Nascimento
 */
public class ExceptionAdapterChain implements ExceptionMessageAdapter {

	private static final long serialVersionUID = 1691262319609999894L;

	@Inject
	private Instance<DefaultExceptionMessageAdapter> sourceDefaultExceptionAdapter;

	@Inject
	private Instance<BusinessExceptionMessageAdapter> sourceBusinessExceptionAdapter;

	@Inject
	private Instance<SystemExceptionMessageAdapter> sourceSystemExceptionAdapter;

	@Override
	public void setContext(ExceptionAdapterContext context) {
	}

	@Override
	public Message adapt(Throwable e) {
		Message message = null;
		ExceptionAdapterContext ctx = new ExceptionAdapterContext();
		if (e instanceof BusinessException) {
			BusinessExceptionMessageAdapter adapter = sourceBusinessExceptionAdapter.get();
			adapter.setContext(ctx);
			message = adapter.adapt(e);
		} else if (e instanceof SystemException) {
			SystemExceptionMessageAdapter adapter = sourceSystemExceptionAdapter.get();
			adapter.setContext(ctx);
			message = adapter.adapt(e);
		} else {
			DefaultExceptionMessageAdapter adapter = sourceDefaultExceptionAdapter.get();
			adapter.setContext(ctx);
			message = adapter.adapt(e);
		}
		return message;
	}

	public List<ExceptionMessageAdapter> getAdapters() {
		List<ExceptionMessageAdapter> adapters = new ArrayList<ExceptionMessageAdapter>();
		adapters.add(sourceBusinessExceptionAdapter.get());
		adapters.add(sourceSystemExceptionAdapter.get());
		adapters.add(sourceDefaultExceptionAdapter.get());
		return adapters;
	}
}
