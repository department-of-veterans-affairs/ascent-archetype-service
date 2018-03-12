#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
 * Implementation of the ${artifactName} business service
 *
 * @author Raju Thota
 */
@Service(value = ${artifactName}ServiceImpl.BEAN_NAME)
@Qualifier("IMPL")
@Scope("prototype")
@RefreshScope
@DefaultProperties(groupKey = HystrixCommandConstants.VETSERVICES_${artifactNameUpperCase}_SERVICE_GROUP_KEY)
public class ${artifactName}ServiceImpl implements ${artifactName}Service {

	public static final Logger LOGGER = LoggerFactory.getLogger(${artifactName}ServiceImpl.class);

	/** Spring bean name constant */
	public static final String BEAN_NAME = "${artifactName}ServiceImpl";
	
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

}
