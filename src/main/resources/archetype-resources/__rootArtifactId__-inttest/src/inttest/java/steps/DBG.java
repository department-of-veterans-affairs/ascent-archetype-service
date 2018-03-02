#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBG {
	static final Logger LOGGER = LoggerFactory.getLogger(DBG.class);

	private static final String LINE = "----------------------------------------"
			+ "----------------------------------------";

	public static void println(final String text) {
		// LOGGER.debug(text);
		System.out.println("DBG: " + text);
	}

	public static void println() {
		println("");
	}

	public static void line() {
		println(LINE);
	}
}
