
package runner;

import org.testng.annotations.Listeners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import com.cucumber.listner.ExtentCucumberFormatter;
import utils.ItestListenerclass;

//@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/com/features", // Path to your feature file
    glue = "stepDefination", // Path to your step definitions
   plugin = {"pretty",
		   "html:target/cucumber-reports",
		   
		   "json:target/jsonReport.json",
		   "junit:target/xmlReport.xml",
		   
		   "rerun:failedFeatures.txt"
		   },
    monochrome = true
)

@Listeners(ItestListenerclass.class)
public class TestRunner extends AbstractTestNGCucumberTests {
    // This class will be empty, but you can add hooks or additional configurations if needed.
}
