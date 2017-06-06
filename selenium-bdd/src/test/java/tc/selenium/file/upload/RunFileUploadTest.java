package tc.selenium.file.upload;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by thomas.croft on 05/06/2017.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features/UploadFile.feature"},
        glue = {"tc.selenium.file.upload"},
        strict = true,
        plugin = {"pretty", "html:target/cucumber-html-report", "json:target/cucumber.json"})
public class RunFileUploadTest {
}
