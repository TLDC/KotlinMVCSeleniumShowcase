package tc.selenium.file.upload;

import cucumber.api.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import tc.selenium.utils.AppConfig;
import tc.selenium.utils.BrowserDriver;
import tc.selenium.utils.Navigation;
import tc.selenium.views.UploadedView.UploadResponse;

/**
 * Steps for uploading a file and asserting the response is as expected
 *
 * Created by thomas.croft on 26/05/2017.
 */
@ContextConfiguration(classes = AppConfig.class)
public class FileUploadSteps implements En {

    /**
     * Controls the selenium webdriver
     */
    @Autowired
    protected BrowserDriver driver;

    /**
     * Used to perform actions on available views
     */
    protected Navigation navigation;

    public FileUploadSteps() {
        Before(body -> {
            driver.createBrowserDriver();
            navigation = new Navigation(driver);
        });
        Given("^the file upload page is visited", () -> {
            navigation.loadPage("http://localhost:8080/kotlin-mvc/fileUploader");
        });
        When("^the user submits an? ((?:in)?valid) file$", (String validity) -> {
            String filePath = System.getProperty("user.dir");
            if (validity.equals("valid")) {
                filePath += "\\src\\test\\resources\\owl.PNG";
            } else {
                filePath += "\\src\\test\\resources\\not-an-image.txt";
            }
            navigation.uploadFile(filePath);
        });
        Then("^the file upload is a (SUCCESS|FAILURE)$", (String status) -> {
            UploadResponse resp = UploadResponse.valueOf(status);
            navigation.uploadedScreenIsShown(resp);
        });
        After(body -> {
            driver.close();
        });
    }
}



