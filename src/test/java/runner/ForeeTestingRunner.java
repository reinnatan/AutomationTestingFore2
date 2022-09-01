package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/features/ForeeAddItemToCart.feature", glue = "definitions")
public class ForeeTestingRunner extends AbstractTestNGCucumberTests {
}
