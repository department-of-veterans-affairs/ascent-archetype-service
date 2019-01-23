#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.steps;

import java.util.Map;

import gov.va.ascent.framework.log.AscentLogger;
import gov.va.ascent.framework.log.AscentLoggerFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.va.ascent.test.framework.restassured.BaseStepDef;
import gov.va.ascent.test.framework.restassured.BaseStepDefHandler;


/**
 * This is a sample step definition file. BaseStepDefHandler object that extends
 * BaseStepDef to handle rest based api call. Step definition class inject this
 * object thru constructor.
 */
public class SampleCucumberStepDefinition {

	private static final AscentLogger LOGGER = AscentLoggerFactory.getLogger(SampleCucumberStepDefinition.class);

	private BaseStepDefHandler handler = null;

	public SampleCucumberStepDefinition(BaseStepDefHandler handler) {
		this.handler = handler;
	}

	@Before({})
	public void setUpREST() {
		handler.initREST();
	}

	/* An example of Step Definition:
	 
	@When("^I make a GET request using \"([^\"]*)\"$")
	public void makingGetRequest(final String strURL) throws Throwable {
		String baseUrl = handler.getRestConfig().getPropertyName("baseURL", true);
		handler.invokeAPIUsingGet(baseUrl + strURL);
	}

	@When("^Using bad token I make a GET request using \"([^\"]*)\"$")
	public void makingGetRequestWithBadToken(final String strURL) throws Throwable {
		String baseUrl = handler.getRestConfig().getPropertyName("baseURL", true);
		handler.invokeAPIUsingGet(baseUrl + strURL);
	}  
	
	*/

	
	/**
	 * Post processing for each scenario.
	 * 
	 * @param scenario
	 */

	@After({})
	public void cleanUp(final Scenario scenario) {
		handler.postProcess(scenario);
	}

}
