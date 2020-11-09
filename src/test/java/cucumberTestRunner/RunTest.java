package cucumberTestRunner;


import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)					// to run as junit using cucumber
@CucumberOptions (
			features="Features",
			glue="stepDefinitions",
			dryRun=false,					// validation check that all steps are present
			monochrome=true,				// displays console output in more readable way
			plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/cucumber-reports/report.html"}
			)


public class RunTest {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(tests.BaseTest.getReportConfigPath()));
	}
}
