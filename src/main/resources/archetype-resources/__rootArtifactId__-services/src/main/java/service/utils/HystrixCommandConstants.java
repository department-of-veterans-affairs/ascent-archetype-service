#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.utils;

public final class HystrixCommandConstants {

	/** VetsApi RefData Service Thread Pool Group. */
	public static final String VETSAPI_REFDATA_SERVICE_GROUP_KEY = "VetsApiRefDataServiceGroup";

	/**
	 * Instantiation not allowed
	 */
	private HystrixCommandConstants() {
		throw new UnsupportedOperationException();
	}

}
