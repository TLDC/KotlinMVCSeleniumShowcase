package tc.selenium.container;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Finds web elements by id from the form view
 *
 * @author sian.webster
 */
public class FormContainer {

    @FindBy(id="name")
    public WebElement name;

    @FindBy(id="age")
    public WebElement age;

    @FindBy(id="maleGender")
    public WebElement maleGender;

    @FindBy(id="femaleGender")
    public WebElement femaleGender;

    @FindBy(id="height")
    public WebElement height;

    @FindBy(id="confirmed")
    public WebElement confirmed;

    @FindBy(id="submit")
    public WebElement submit;

}
