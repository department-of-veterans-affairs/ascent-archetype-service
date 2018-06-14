#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.runner;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(strict = false, plugin = { "pretty", "html:target/site/cucumber-pretty",
		"json:target/cucumber.json" }, features = {
				// add paths to all feature files here
				"src/inttest/resources/gov/va/vetservices/${artifactNameLowerCase}/feature/sample.feature" }, glue = {
						"gov.va.vetservices.${artifactNameLowerCase}.steps" })
public class VetServices${artifactName}Runner extends AbstractTestNGCucumberTests{

	final Logger LOGGER = LoggerFactory.getLogger(VetServices${artifactName}Runner.class);

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
	}
}
