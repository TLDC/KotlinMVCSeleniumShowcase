package tc.selenium.container;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Finds web elements by id from the uploaded view
 *
 * Created by thomas.croft on 26/05/2017.
 */
public class UploadedContainer {

    @FindBy(id="response")
    public WebElement response;

    @FindBy(id="error")
    public WebElement error;

}
