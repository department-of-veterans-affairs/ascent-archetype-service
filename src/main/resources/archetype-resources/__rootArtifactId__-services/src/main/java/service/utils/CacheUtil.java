#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.utils;

import  ${package}.util.ApplicationInfo;

/**
 * utils for cache
 *
 * @author akulkarni
 */
// akulkarni- Using interface to get application info
// CHECKSTYLE:OFF
public interface CacheUtil {
    /// CHECKSTYLE:ON
    /**
     * cache name separator
     */
    String CACHE_NAME_SEPARATOR = "_";
   
    /**
     * cache name suffix
     */
    String CACHE_NAME_SUFFIX =
            CACHE_NAME_SEPARATOR + ApplicationInfo.PROJECT_NAME + CACHE_NAME_SEPARATOR + ApplicationInfo.VERSION;
    
    String CACHE_NAME_COUNTRIES = "countries" + CACHE_NAME_SUFFIX;
    String CACHE_NAME_STATES = "states" + CACHE_NAME_SUFFIX;
    String CACHE_NAME_TREATMENT_CENTERS = "treatmentcenters" + CACHE_NAME_SUFFIX;
    String CACHE_NAME_DISABILITIES = "disabilities" + CACHE_NAME_SUFFIX;
    String CACHE_NAME_INTAKESITES = "intakesites" + CACHE_NAME_SUFFIX;
    
}

