#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.steps;

import gov.va.ascent.framework.log.AscentLogger;
import gov.va.ascent.framework.log.AscentLoggerFactory;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gov.va.ascent.test.framework.restassured.BaseStepDefHandler;
import gov.va.ascent.test.framework.service.BearerTokenService;

/**
 * Execute a step from the Feature file. Contains generic step definition that most feature files will implement.
 * 
 */
public class GenericSteps {
	
	private BaseStepDefHandler handler = null;

	private static final AscentLogger LOGGER = AscentLoggerFactory.getLogger(GenericSteps.class);

	public GenericSteps(BaseStepDefHandler handler) {
		this.handler = handler;
	}
	
	@Given("^the claimant is a \"([^\"]*)\"$")
	public void ValidVafiHeader(String users) throws Throwable {
		handler.setHeader(users);
	}

	@And("^invoke token API by passing header from \"([^\"]*)\" and sets the authorization in the header$")
	public void setAuthorizationToken(String headerfilename) throws Throwable {
		String tokenvalue = BearerTokenService.getTokenByHeaderFile(headerfilename);
		handler.getHeaderMap().put("Authorization", "Bearer " + tokenvalue);
	}

	@Then("^the service returns status code = (\\d+)$")
	public void theServiceReturnsStatusCode(final int httpCode) throws Throwable {
		handler.validateStatusCode(httpCode);
	}

	@And("^the response should be same as \"(.*?)\"$")
	public void responseShouldBe(final String responseFile) throws Throwable {
		LOGGER.info("responseFile {}", responseFile);
		handler.compareExpectedResponseWithActual(responseFile);
	}
	
}

