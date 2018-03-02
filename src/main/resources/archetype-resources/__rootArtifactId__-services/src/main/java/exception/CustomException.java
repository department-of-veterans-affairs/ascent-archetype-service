#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

import gov.va.ascent.framework.exception.AscentRuntimeException;

/**
 * Generic base exception for ServiceName exceptions. Extend this class for specific
 * exceptions.
 */
public class CustomException extends AscentRuntimeException {

	private static final long serialVersionUID = -1823081544248832886L;

	/**
	 * Instantiates a new exception.
	 */
	public CustomException() {
		super();
	}

	/**
	 * Instantiates a new ServiceName exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public CustomException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new ServiceName exception.
	 *
	 * @param message
	 *            the message
	 */
	public CustomException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new ServiceName exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public CustomException(final Throwable cause) {
		super(cause);
	}

}
