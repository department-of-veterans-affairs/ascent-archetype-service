#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import gov.va.vetservices.${artifactNameLowerCase}.api.${artifactName}Service;
import gov.va.vetservices.${artifactNameLowerCase}.impl.${artifactName}ServiceImpl;
import gov.va.vetservices.${artifactNameLowerCase}.util.MessageUtils;

@Configuration
public class ${artifactName}AutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public MessageSource messageSource() {
		final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames( "classpath:messages"  );
		messageSource.setDefaultEncoding( "UTF-8" );
		messageSource.setCacheSeconds( 60 );
		messageSource.setFallbackToSystemLocale( false );
		return messageSource;
	}

	@Bean
	@ConditionalOnMissingBean
	public ${artifactName}Service ${artifactNameLowerCase}Service() {
		return new ${artifactName}ServiceImpl();
	}

	@Bean
	@ConditionalOnMissingBean
	public MessageUtils messageUtils() {
		return new MessageUtils();
	}
}
