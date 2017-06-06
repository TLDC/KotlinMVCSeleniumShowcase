package tc.selenium.views;

import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import tc.selenium.container.UploadedContainer;
import tc.selenium.utils.BrowserDriver;

/**
 * Actions which can be performed on elements in the uploaded view
 *
 * Created by thomas.croft on 26/05/2017.
 */
public class UploadedView {

    public enum UploadResponse {
        SUCCESS("File uploaded successfully"),
        FAILURE("File NOT uploaded successfully");

        private String message;

        UploadResponse(String message) {
           this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    /**
     * Container for the web elements in the uploaded view
     */
    private final UploadedContainer uploadedContainer;

    /**
     * Initialise web elements using current web driver
     */
    public UploadedView(BrowserDriver browserDriver) {
        uploadedContainer = PageFactory.initElements(browserDriver.getCurrentDriver(), UploadedContainer.class);
    }

    /**
     * Checks the page displayed contains the correct response message
     * @param response
     */
    public void assertResponse(UploadResponse response) {
        Assert.assertEquals(response.getMessage(), uploadedContainer.response.getText());
    }

    /**
     * Checks the page displayed contains the correct error message
     * @param message
     */
    public void assertError(String message) {
        Assert.assertEquals(message, uploadedContainer.error.getText().trim());
    }

    public void assertNoError() {
        assertError(StringUtils.EMPTY);
    }

}
