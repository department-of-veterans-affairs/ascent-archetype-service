#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

/**
 * Constants to be used for response Messages
 *
 * @author aburkholder
 */
public class MessageConstants {

	/** Constant for default throwable key */
	public static final String KEY_DEFAULT = "${artifactNameLowerCase}.throwable";

	/**
	 * No instantiation
	 */
	private MessageConstants() {
		throw new UnsupportedOperationException();
	}

}
