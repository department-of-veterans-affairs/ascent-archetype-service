#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.steps;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gov.va.ascent.test.framework.restassured.BaseStepDef;

/**
 * Execute a step from the Feature file. The extended {@link BaseStepDef} provides most of the functionality to set up, process, and
 * validate requests.
 */
public class SampleCucumberStepDefinition extends BaseStepDef {

	final static Logger LOGGER = LoggerFactory.getLogger(SampleCucumberStepDefinition.class);

	/**
	 * Initialize the REST environment
	 */
	@Before({})
	public void setUpREST() {
		initREST();
	}

	/* An example of Give / When / Then:

	@Given("^The Given statement that references the request header${symbol_dollar}")
	public void theGivenStatementThatReferencesTheRequestHeader(final String whichList,
			final Map<String, String> tblHeader) throws Throwable {
		passHeaderInformation(tblHeader);
	}
	
	@When("^Some action occurs${symbol_dollar}")
	public void someActionOccurs(final String serviceUrl, final String someInputValue) throws Throwable {
		super.resUtil.setUpRequest(headerMap);
		String baseUrl = super.restConfig.getPropertyName("baseURL", true);
		String url = baseUrl + serviceUrl + "/" + someInputValue;
		invokeAPIUsingGet(url, true);
	}

	@Then("^Verify the result of the test${symbol_dollar}")
	public void httpStatusCodeIs(final int statusCode) throws Throwable {
		super.validateStatusCode(statusCode);
	}

	*/

	/**
	 * Post processing for each scenario.
	 * 
	 * @param scenario
	 */
	@After({})
	public void cleanUp(final Scenario scenario) {
		postProcess(scenario);
	}

}
