#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;
import gov.va.ascent.framework.log.AscentLogger;
import gov.va.ascent.framework.log.AscentLoggerFactory;
import org.testng.Assert;

import ${package}.exception.MessageConstants;

public class MessageConstantsTest {

	private static final AscentLogger LOGGER = AscentLoggerFactory.getLogger(MessageConstantsTest.class);

	public static final String KEY_DEFAULT = "${artifactNameLowerCase}.throwable";

	@Test
	public void testPrivateConstructor() {

		try {
			final Constructor<MessageConstants> c = MessageConstants.class.getDeclaredConstructor();
			c.setAccessible(true);
			c.newInstance();

			fail("MessageConstants private constructor did not throw UnsupportedOperationException");

		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException | UnsupportedOperationException e) {
			assertTrue(Exception.class.isAssignableFrom(e.getClass()));
		}
	}

	@Test
	public void testKeyDefaultText() {

		Assert.assertEquals(KEY_DEFAULT, MessageConstants.KEY_DEFAULT);
	}
}
