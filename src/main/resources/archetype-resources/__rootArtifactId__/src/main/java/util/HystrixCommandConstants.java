#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

/**
 * Constants used by Hystrix for the service implementation
 */
public final class HystrixCommandConstants {

	/** VetServices app Thread Pool Group. */
	public static final String VETSERVICES_${artifactNameUpperCase}_SERVICE_GROUP_KEY = "VetServices${artifactName}ServiceGroup";

	/**
	 * Instantiation not allowed
	 */
	private HystrixCommandConstants() {
		throw new UnsupportedOperationException();
	}

}
