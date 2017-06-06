package tc.selenium.container;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Finds web elements by id from the file upload view
 *
 * Created by thomas.croft on 25/05/2017.
 */
public class FileUploadContainer {

    @FindBy(id="file")
    public WebElement file;

    @FindBy(id="upload")
    public WebElement upload;

}
