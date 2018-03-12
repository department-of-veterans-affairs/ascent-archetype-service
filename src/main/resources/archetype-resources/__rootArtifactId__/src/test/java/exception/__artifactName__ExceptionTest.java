#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.exception;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import ${package}.exception.${artifactName}Exception;

@RunWith(SpringRunner.class)
public class ${artifactName}ExceptionTest {

	@Test
	public void test${artifactName}Exception() {
		${artifactName}Exception exception = new ${artifactName}Exception();
		exception = new ${artifactName}Exception("test");
		assertNotNull(exception);

		exception = new ${artifactName}Exception(new Throwable());
		assertNotNull(exception);

		exception = new ${artifactName}Exception("test", new Throwable());
		assertNotNull(exception);
	}
}
