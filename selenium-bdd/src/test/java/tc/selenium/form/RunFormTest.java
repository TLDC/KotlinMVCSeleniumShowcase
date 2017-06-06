package tc.selenium.form;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features/CompleteForm.feature"},
        glue = {"tc.selenium.form"},
        strict = true,
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"})
public class RunFormTest {
}
