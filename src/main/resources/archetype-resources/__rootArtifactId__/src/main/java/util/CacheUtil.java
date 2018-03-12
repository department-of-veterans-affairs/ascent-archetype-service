#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import org.springframework.cache.annotation.CachePut;

/**
 * <p>
 * Cache constants and utilities.
 * </p>
 * <p>
 * Note that service impl methods that are cached should use constants declared in this class
 * for their "value" definitions. For example:<br/>
 * {@code @CachePut(value = CacheUtil.CACHE_NAME_STATES, key = "${symbol_pound}root.methodName", unless = ...}
 * </p>
 *
 * @author akulkarni
 */
public class CacheUtil {
	
	/**
	 * No instantiation
	 */
	private CacheUtil() {
		// no-op
	}

	/**
     * cache name separator
     */
    private static final String CACHE_NAME_SEPARATOR = "_";
   
    /**
     * cache name suffix
     */
    private static final String CACHE_NAME_SUFFIX =
            CACHE_NAME_SEPARATOR + ApplicationInfo.PROJECT_NAME + CACHE_NAME_SEPARATOR + ApplicationInfo.VERSION;
    
    /*
     * Example cache name constant for use in the service impl CachePut annotations:
     * public static final String CACHE_NAME_COUNTRIES = "countries" + CACHE_NAME_SUFFIX;
     */
    
}

