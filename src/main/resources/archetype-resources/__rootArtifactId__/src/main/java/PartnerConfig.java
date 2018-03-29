#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * Adds spring configuration for partner web service clients that are used by this application.
 * </p>
 * <p>
 * Example class level component scan annotation:<br/>
 * <tt>@ComponentScan(basePackages = { "gov.va.vetservices.partner.shareddata.ws.client" })</tt>
 * </p>
 */
@Configuration
@ComponentScan(basePackages = { "gov.va.vetservices.partner" })
public class PartnerConfig {
	// nothing needed here
}
