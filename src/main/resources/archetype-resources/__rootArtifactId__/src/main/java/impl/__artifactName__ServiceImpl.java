#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.impl;

import gov.va.ascent.framework.log.AscentLogger;
import gov.va.ascent.framework.log.AscentLoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;

import gov.va.vetservices.${artifactNameLowerCase}.api.${artifactName}Service;
import gov.va.vetservices.${artifactNameLowerCase}.util.HystrixCommandConstants;
import gov.va.vetservices.${artifactNameLowerCase}.util.MessageUtils;


/**
 * Implementation of the api.${artifactName}Service client API 
 */
@Service(value = ${artifactName}ServiceImpl.BEAN_NAME)
@Qualifier("IMPL")
@Scope("prototype")
@RefreshScope
@DefaultProperties(groupKey = HystrixCommandConstants.VETSERVICES_${artifactNameUpperCase}_SERVICE_GROUP_KEY)
public class ${artifactName}ServiceImpl implements ${artifactName}Service {

	/** Constant for the logger for this class */
	public static final AscentLogger LOGGER = AScentLoggerFactory.getLogger(${artifactName}ServiceImpl.class);

	/** Spring bean name constant */
	public static final String BEAN_NAME = "${artifactNameLowerCase}ServiceImpl";
	
	/** Constant for the message when hystrix fallback method is manually invoked */
	private static final String INVOKE_FALLBACK_MESSAGE = "Could not get data from cache or partner - invoking fallback.";

	/** Auto wire the spring cache manager */
	@Autowired
	private CacheManager cacheManager;	

	/** Auto wire message utilities */
	@Autowired
	@Qualifier("messageUtils")
	private MessageUtils messageUtils;

	/** Auto wire the spring message source for error messages. */
	@Autowired
	private MessageSource messageSource;
	
	/*
	 * Override api.${artifactName}Service methods here.
	 * - Hystrix and Cache annotations.
	 * - Business logic.
	 * - Hystrix Fallback method and error handling.
	 * 
	 *  EXAMPLE follows ...
	 */

	/**
	 * List of all ${artifactName}.
	 *
	 * @return ${artifactName}ListResponse The marshaled response from the WS request
	 * @throws ${artifactName}Exception
	 */
/*
	@Override
	@CachePut(value = CacheUtil.CACHE_NAME_GETALL${artifactNameUpperCase}, 
			key = "${symbol_pound}root.methodName + T(gov.va.ascent.framework.util.AscentCacheUtil).getUserBasedKey()",
			unless = "T(gov.va.ascent.framework.util.AscentCacheUtil).checkResultConditions(${symbol_pound}result)")
	@HystrixCommand(fallbackMethod = "getAll${artifactName}FallBack", commandKey = "GetAll${artifactName}Command", ignoreExceptions = {})
	public ${artifactName}ListResponse getAll${artifactName}() {
		// TODO code it
		return null;
	}
*/

	  /**
	   * Hystrix Fallback Method Which is Triggered When there Is An Unexpected Exception
	   *
	   * @return ${artifactName}ListResponse The response retrieved from the static resource
	   * @throws ${artifactName}FileException
	   */
/*
	  @HystrixCommand(commandKey = "GetAll${artifactName}Command")
	  public ${artifactName}ListResponse getAll${artifactName}FallBack() {

			LOGGER.info("Entered getAll${artifactName}FallBack");
			final ${artifactName}ListResponse ${artifactNameLowerCase}ListResponse = new ${artifactName}ListResponse();

			handleFallBackThrowable();
			${artifactNameLowerCase}ListResponse.getMessages().addAll(messageUtils.getMessages());
			${artifactNameLowerCase}ListResponse.setDoNotCacheResponse(true);

			return ${artifactNameLowerCase}ListResponse;
	  }
*/

}
