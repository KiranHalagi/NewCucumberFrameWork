package cucumberOptions;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src\\test\\java\\features\\Tagging.feature",  //It will give path of feature file
		glue="taggingConcept", //It will give the path of step defination file
		dryRun=false,//It will give mapping before the test run
		strict=true,//It will fail if the steps or pending
	    monochrome=true, //Display the console output in much readable format
		plugin= {"pretty","html:test-output","json:json-output/Cucumber.json", "junit:junit_xml/cucumber.xml"},
		//plugin will give what all report formatters to use
		tags= {"@Smoke","@Regression"}
		)

//ORing tag Tags that are comma-separated are ORed.Ex {"@Smoke, @regression"}
//ANDing tag Tags which are passed in separate quotes are ANDed {"@Smoke","@regression"}
//How to Ignore Cucumber Tests
//Using "~" symbol we can ignore tests
public class TestRunner {
	

}
