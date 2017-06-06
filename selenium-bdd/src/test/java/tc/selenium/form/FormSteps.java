package tc.selenium.form;

import cucumber.api.DataTable;
import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import tc.selenium.utils.AppConfig;
import tc.selenium.utils.BrowserDriver;
import tc.selenium.utils.Navigation;

import java.util.List;

/**
 * Steps for completing a form and asserting that the response is as expected.
 *
 * @author sian.webster
 */
@ContextConfiguration(classes = AppConfig.class)
public class FormSteps implements En {

    /**
     * Controls the selenium webdriver
     */
    @Autowired
    protected BrowserDriver driver;

    /**
     * Used to perform actions on available views
     */
    protected Navigation navigation;

    private String name;
    private int age;
    private String gender;
    private String height;
    private boolean confirmed;

    /**
     * Java 8 implementation of Given/When/Then steps for complete form feature.
     * Opens a new browser at the beginning of each scenario, completes the
     * steps and closes the browser at the end.
     */
    public FormSteps() {
        Before(body -> {
            driver.createBrowserDriver();
            navigation = new Navigation(driver);
        });
        Given("^the form page is visited", () -> {
            navigation.loadPage("http://localhost:8080/kotlin-mvc/manosMaker");
        });
        Given("^the user completed the form with the following data$", (DataTable formData) -> {
            List<String> dataRow = formData.getGherkinRows().get(1).getCells();
            name = dataRow.get(0);
            age = Integer.valueOf(dataRow.get(1)).intValue();
            gender = dataRow.get(2);
            height = dataRow.get(3);
            confirmed = Boolean.parseBoolean(dataRow.get(4));
            navigation.enterFormDetails(name, age, gender, height, confirmed);
        });
        When("^the submit button is clicked$", () -> {
            navigation.submitForm();
        });
        Then("^the summary is shown$", () -> {
            navigation.summaryScreenIsShown(name, age, gender, height, confirmed);
        });
        After(body -> {
            driver.close();
        });
    }
}