package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

// CucumberOptions to define features, glue (step definitions) and plugins
@CucumberOptions(features = "src/test/java/features", // path to your .feature files
		glue = { "stepDefinition", "hooks", "driver" }, // package containing step definitions
		plugin = { "pretty", "junit:target/cucumber-reports/Cucumber.xml",
				"html:target/cucumber-reports/html-report.html",
				"json:target/cucumber-reports/report.json" ,
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}, monochrome = true,
		tags = "(@BookSearch or @LibraryCard or @ServiceQuery ) and (not @ignore)" 
																																			// filtering
)
public class RunnerTest extends AbstractTestNGCucumberTests {
	// No code needed here, TestNG will run with the above configurations
}
