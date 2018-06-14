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
import gov.va.vetservices.${artifactNameLowerCase}.api.${artifactName}Service;
import gov.va.vetservices.${artifactNameLowerCase}.util.MessageUtils;


/**
 * REST Resource class, offering operations for the service Resource.
 *
 * @author
 *
 */
@RestController
public class ${artifactName}Resource implements SwaggerResponseMessages {

	  /** Constant for the logger for this class */
	  private static final Logger LOGGER = LoggerFactory.getLogger(${artifactName}Resource.class);

	  /** The API/Model version associated with this resource */
	  public static final String URL_PREFIX = "/v1";
	  
		/** Auto wire the service implementation */
		@Autowired
		@Qualifier("IMPL")
		${artifactName}Service ${artifactNameLowerCase}Service;

		/** Auto wire message utilities */
		@Autowired
		@Qualifier("messageUtils")
		private MessageUtils messageUtils;
		
		/* Add REST Resources */
		/**
		 * Get the list of all records.
		 * 
		 * @Return ${artifactName}ListResponse
		 */
/*		// CHECKSTYLE:OFF
		@RequestMapping(value = URL_PREFIX , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
		@ApiOperation(value = "Get List of All ${artifactName}", notes = "A veteran can have multiple ${artifactName}. "
				+ "This operation allows a full listing of ${artifactName} for the veteran. Information on each record is returned.")
		@ApiResponses(value = { @ApiResponse(code = 200, response = ${artifactName}ListResponse.class, message = MESSAGE_200),
				@ApiResponse(code = 400, response = ServiceResponse.class, message = MESSAGE_400),
		@ApiResponse(code = 500, response = ServiceResponse.class, message = MESSAGE_500),
		@ApiResponse(code = 403, message = MESSAGE_403) })
		public ${artifactName}ListResponse getAll${artifactName}() {
			// CHECKSTYLE:ON
			return ${artifactNameLowerCase}Service.getAll${artifactName}();
		}
*/
}