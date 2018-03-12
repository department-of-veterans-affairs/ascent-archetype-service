#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import ${package}.util.HystrixCommandConstants;

@RunWith(SpringRunner.class)
public class HystrixCommandConstantsTest {

	@Test
	public void testPrivateConstructor() {

		try {
			final Constructor<HystrixCommandConstants> c = HystrixCommandConstants.class.getDeclaredConstructor();
			c.setAccessible(true);
			c.newInstance();

			fail("HystrixCommandConstants private constructor did not throw UnsupportedOperationException");

		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | UnsupportedOperationException e) {
			assertTrue(Exception.class.isAssignableFrom(e.getClass()));
		}
	}

	@Test
	public void constantTest() {

		assertEquals(HystrixCommandConstants.VETSERVICES_${artifactNameUpperCase}_SERVICE_GROUP_KEY,
				HystrixCommandConstants.VETSERVICES_${artifactNameUpperCase}_SERVICE_GROUP_KEY);
	}

}
