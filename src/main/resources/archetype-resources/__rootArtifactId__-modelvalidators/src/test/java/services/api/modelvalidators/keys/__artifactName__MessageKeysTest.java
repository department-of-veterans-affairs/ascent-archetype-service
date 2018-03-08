#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.modelvalidators.keys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import gov.va.vetservices.refdata.api.modelvalidators.keys.ReferenceDataMessageKeys;

public class ${artifactName}MessageKeysTest {

	/* copy all MessageKeys constants to this location */

	@Test
	public void testIsValid_happypath() {
		String data;

		/* Example of testing one message key:
		data = ${artifactName}MessageKeys.${artifactNameUpperCase}_SPECIFIER_INFO__ERROR;
		assertNotNull(data);
		assertEquals(data, TEST_SPECIFIER_INFO__ERROR);
		*/

		/* delete this line */
		assertTrue(true);
	}

}
