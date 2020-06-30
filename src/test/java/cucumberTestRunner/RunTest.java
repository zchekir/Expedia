package cucumberTestRunner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)					// to run as junit using cucumber
@CucumberOptions (
			features="Features",
			glue="stepDefinitions",
			dryRun=false,					// validation check that all steps are present
			monochrome=true,				// displays console output in more readable way
			plugin= {"pretty","html:test-ouput2"}
			)


public class RunTest {
}
