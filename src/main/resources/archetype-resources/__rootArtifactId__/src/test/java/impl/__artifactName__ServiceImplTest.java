#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.context.MessageSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import gov.va.ascent.framework.exception.AscentRuntimeException;
import gov.va.ascent.starter.cache.autoconfigure.AscentCacheProperties;
import gov.va.ascent.starter.cache.autoconfigure.AscentCacheProperties.RedisConfig;
import gov.va.ascent.starter.cache.server.AscentEmbeddedRedisServer;

@RunWith(SpringRunner.class)
public class ${artifactName}ServiceImplTest {

	private static final String INVOKE_FALLBACK_MESSAGE = "Could not get data from cache or partner - invoking fallback.";

	@InjectMocks
	static AscentEmbeddedRedisServer ascentEmbeddedRedisServer = new AscentEmbeddedRedisServer();

	@Spy
	AscentCacheProperties ascentCacheProperties = new AscentCacheProperties();

	@InjectMocks
	${artifactName}Service ${artifactNameLowerCase}Service = new ${artifactName}ServiceImpl();

	@Spy
	MessageUtils messageUtils = new MessageUtils();

	@Mock
	MessageSource messageSource;

	@Mock
	CacheManager cacheManager;

	@Mock
	Cache mockCache;

	@Mock
	ValueWrapper mockValueWrapper;

	ResourceLoader resourceLoader = new DefaultResourceLoader();

	@Before
	public void setUp() throws Exception {
		when(messageSource.getMessage(anyString(), anyObject(), anyObject())).thenReturn("");
		ReflectionTestUtils.setField(jsonUtils, "resourceLoader", resourceLoader);
		ascentCacheProperties.setRedisConfig(new RedisConfig());
		ascentEmbeddedRedisServer.startRedis();
	}

	@After
	public void close() {
		ascentEmbeddedRedisServer.stopRedis();
	}

/* Repeat this suite of tests for each public operation in the service ...
	@Test
	public void get__OperationName__Test() {
		...
	}

	@Test
	public void get__OperationName__FromCacheTest() {
		...
	}

	@Test
	public void get__OperationName__NoCacheNoPartnerTest() {
		...
	}

	@Test
	public void get__OperationName__FallBackTest() {
		...
	}

	@Test
	public void getDisabilitiesFallBackFailTest() {
		...
	}
*/
	
}