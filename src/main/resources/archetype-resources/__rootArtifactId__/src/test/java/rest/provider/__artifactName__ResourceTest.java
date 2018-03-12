#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest.provider;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import ${package}.impl.${artifactName}ServiceImpl;
import ${package}.rest.provider.${artifactName}Resource;

@RunWith(MockitoJUnitRunner.class)
public class ${artifactName}ResourceTest {

	@Mock
	private ${artifactName}ServiceImpl mock${artifactName}Service;

	@InjectMocks
	private ${artifactName}Resource ${artifactNameLowerCase}ResourceTest;

	@Before
	public void setUp() {
		/* Example mock of service returns:
		when(mock${artifactName}Service.getStates()).thenReturn(new StateResponse());
		*/
	}

	/* Test each operation
	@Test
	public void testGet__OperationName__() {
		...
	}
	*/
}
