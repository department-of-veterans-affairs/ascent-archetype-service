#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.impl;
import  ${package}.api.${artifactName}Service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;

import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Implementation of the ServiceName business service
 *
 * @author Raju Thota
 */
@Service(value = ${artifactName}ServiceImpl.BEAN_NAME)
@Qualifier("IMPL")
@Scope("prototype")
@RefreshScope
public class ${artifactName}ServiceImpl implements ${artifactName}Service {

	public static final Logger LOGGER = LoggerFactory.getLogger(${artifactName}ServiceImpl.class);

	/** Spring bean name constant */
	public static final String BEAN_NAME = "${artifactName}ServiceImpl";
	
	@Autowired
	private CacheManager cacheManager;	
}
