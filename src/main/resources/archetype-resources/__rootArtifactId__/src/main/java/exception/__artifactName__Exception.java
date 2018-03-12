#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

import gov.va.ascent.framework.exception.AscentRuntimeException;

/**
 * Generic base exception for ${artifactName} exceptions.
 */
public class ${artifactName}Exception extends AscentRuntimeException {

	private static final long serialVersionUID = -1L;

	/**
	 * Instantiates a new exception.
	 */
	public ${artifactName}Exception() {
		super();
	}

	/**
	 * Instantiates a new ${artifactName} exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public ${artifactName}Exception(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new ${artifactName} exception.
	 *
	 * @param message
	 *            the message
	 */
	public ${artifactName}Exception(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new ${artifactName} exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public ${artifactName}Exception(final Throwable cause) {
		super(cause);
	}

}
