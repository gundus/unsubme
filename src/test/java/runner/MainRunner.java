package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions (
	features = {"src/test/java/com/bigmantra/unsubme/features/"},
	glue = {""}
	,plugin = {"pretty"
			,"html:target/cucumber" 
			,"json:target/cucumber/cucumber.json"
	//		,"com.cucumber.listener.ExtentCucumberFormatter:target/report.html"
			}		
)

public class MainRunner {

}
