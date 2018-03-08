#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.rest.provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import gov.va.ascent.framework.swagger.SwaggerResponseMessages;
import gov.va.vetservices.refdata.api.RefdataService;
import gov.va.vetservices.refdata.rest.provider.RefdataResource;

@RestController
/**
 * REST Resource class, offering operations for the service Resource.
 *
 * @author
 *
 */
public class ${artifactName}Resource implements SwaggerResponseMessages {

	  /** Constant for the logger for this class */
	  private static final Logger LOGGER = LoggerFactory.getLogger(${artifactName}Resource.class);

	  /** The API/Model version associated with this resource */
	  public static final String URL_PREFIX = "/v1";
	  
		/** Auto wiire the service implementation */
		@Autowired
		@Qualifier("IMPL")
		${artifactName}Service ${artifactNameLowerCase}Service;

}