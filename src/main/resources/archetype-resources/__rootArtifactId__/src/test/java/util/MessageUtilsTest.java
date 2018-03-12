#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import gov.va.ascent.framework.messages.MessageSeverity;
import ${package}.util.MessageUtils;

@RunWith(SpringRunner.class)
public class MessageUtilsTest {

	private MessageUtils messageUtils;

	@Before
	public void setup(){
		messageUtils = new MessageUtils();
	}

	@Test
	public void testMessage() {
		messageUtils.add(MessageSeverity.ERROR,
				"test.key",
				"test message");
		assertEquals(1, messageUtils.getMessages().size());
		assertEquals(1, messageUtils.size());
	}

}


