package testrunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="src/test/java/Features/SwagLabsLogin.feature",glue = {"stepDefinitions"},
plugin = {"pretty", "html:target/cucumber-html-report/report.html","json:target/jsonreports/cucumber.json"})
public class TestRunner {
	
}
