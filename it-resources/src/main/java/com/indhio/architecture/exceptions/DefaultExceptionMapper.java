package com.indhio.architecture.exceptions;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.indhio.architecture.exceptions.adapter.ExceptionAdapterChain;
import com.indhio.architecture.exceptions.adapter.ExceptionFinder;

/**
 * ExceptionMapper para tratamento de excecoes.
 *
 * @author Vinicius Nascimento
 *
 */
@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Throwable> {

	@Inject
	private Logger logger;

	@Inject
	private ExceptionFinder exceptionFinder;

	@Inject
	private ExceptionAdapterChain exceptionAdapterChain;

	public Response toResponse(Throwable e) {
		logger.severe(e.getMessage());
		try {
			Throwable cause = exceptionFinder.with(e).cause();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exceptionAdapterChain.adapt(cause)).build();
		} catch (Exception ex) {
			logger.severe(ex.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(exceptionAdapterChain.adapt(ex)).build();
		}
	}

}
