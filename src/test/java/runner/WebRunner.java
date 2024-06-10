package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:reports/cucumber-api-report.html"},
        glue = {"stepDefinition"},
        features = {"src/test/java/features"},
        tags = "@web",
        monochrome = true
)

public class WebRunner {
}
