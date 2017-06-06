package tc.selenium.views;

import org.openqa.selenium.support.PageFactory;
import tc.selenium.container.FileUploadContainer;
import tc.selenium.utils.BrowserDriver;

/**
 * Actions which can be performed on elements in the form view
 *
 * Created by thomas.croft on 25/05/2017.
 */
public class FileUploadView {

    /**
     * Container for the web elements from the file upload view
     */
    private final FileUploadContainer fileUploadContainer;

    /**
     * Initialise web elements using the current web driver
     * @param browserDriver
     */
    public FileUploadView(BrowserDriver browserDriver) {
        fileUploadContainer = PageFactory.initElements(browserDriver.getCurrentDriver(), FileUploadContainer.class);
    }

    /**
     * Uploads a file with a specified file path. Selenium does a lot of the work for you here.
     * @param filePath
     */
    public void uploadFile(String filePath) {
        fileUploadContainer.file.sendKeys(filePath);
    }

    /**
     * Submits the uploaded file
     */
    public void submit() {
        fileUploadContainer.upload.submit();
    }

}
