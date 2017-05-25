package tc.selenium.container;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Finds web elements by id from the summary view
 *
 * @author sian.webster
 */
public class SummaryContainer {

    @FindBy(id="name")
    public WebElement name;

    @FindBy(id="age")
    public WebElement age;

    @FindBy(id="gender")
    public WebElement gender;

    @FindBy(id="height")
    public WebElement height;

    @FindBy(id="confirmed")
    public WebElement confirmed;

}
