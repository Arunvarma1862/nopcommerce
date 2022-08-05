package cucumberTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (
		features="src/test/java/cucumberFeatures",
		glue="cucumberStepDef",
		dryRun=false,
		monochrome=true,
		plugin= {"pretty",
				"html:target/cucumber-reports/report.html"
		} ,publish=true)

//	plugin= {"pretty","html:target/cucumber-reports/report.html"}
//plugin= {"pretty","json:target/cucumber-reports/report.json"}
//plugin= {"pretty"}
//plugin= {"usage"}
//plugin= {"pretty","junit:target/cucumber-reports/report.xml"}
public class TestRunn {
	

}
