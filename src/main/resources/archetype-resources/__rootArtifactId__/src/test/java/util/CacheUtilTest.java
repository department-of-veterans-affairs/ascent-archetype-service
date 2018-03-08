#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ${package}.util.ApplicationInfo;

public class CacheUtilTest {

	/**
	 * cache name separator
	 */
	private static final String CACHE_NAME_SEPARATOR = "_";

	/**
	 * cache name suffix
	 */
	private static final String CACHE_NAME_SUFFIX =
			CACHE_NAME_SEPARATOR + ApplicationInfo.PROJECT_NAME + CACHE_NAME_SEPARATOR + ApplicationInfo.VERSION;

	@Test
	public void testCacheUtil() {
		assertTrue(CacheUtil.CACHE_NAME_COUNTRIES.equals("countries" + CACHE_NAME_SUFFIX));
		assertTrue(CacheUtil.CACHE_NAME_STATES.equals("states" + CACHE_NAME_SUFFIX));
		assertTrue(CacheUtil.CACHE_NAME_TREATMENT_CENTERS.equals("treatmentcenters" + CACHE_NAME_SUFFIX));
		assertTrue(CacheUtil.CACHE_NAME_DISABILITIES.equals("disabilities" + CACHE_NAME_SUFFIX));
		assertTrue(CacheUtil.CACHE_NAME_INTAKESITES.equals("intakesites" + CACHE_NAME_SUFFIX));
	}

}
