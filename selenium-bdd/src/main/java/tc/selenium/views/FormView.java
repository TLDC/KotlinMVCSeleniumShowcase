package tc.selenium.views;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import tc.selenium.container.FormContainer;
import tc.selenium.utils.BrowserDriver;

/**
 * Actions which can be performed on elements in the form view.
 *
 * @author sian.webster
 */
public class FormView {

    /**
     * Container for the web elements from the form view
     */
    private final FormContainer formContainer;

    /**
     * Initialise web elements using current web driver
     *
     * @param browserDriver
     */
    public FormView(BrowserDriver browserDriver) {
        formContainer = PageFactory.initElements(browserDriver.getCurrentDriver(), FormContainer.class);
    }

    /**
     * Completes the name field using the given input
     *
     * @param name
     */
    public void setName(String name) {
        formContainer.name.clear();
        formContainer.name.sendKeys(name);
    }

    /**
     * Selects age from a dropdown using given input
     *
     * @param age
     */
    public void setAge(int age) {
        Select ageDropDown = new Select(formContainer.age);
        if (age > 30) {
            ageDropDown.selectByIndex(1);
        } else if (age < 18) {
            ageDropDown.selectByIndex(3);
        } else {
            ageDropDown.selectByIndex(2);
        }
    }

    /**
     * Completes height field using given input
     *
     * @param height
     */
    public void setHeight(String height) {
        formContainer.height.clear();
        formContainer.height.sendKeys(height);
    }

    /**
     * Selects a gender radio button using given input
     *
     * @param gender
     */
    public void setGender(String gender) {
        if (StringUtils.equalsIgnoreCase(gender, "M")) {
            formContainer.maleGender.click();
        } else if (StringUtils.equalsIgnoreCase(gender, "F")) {
            formContainer.femaleGender.click();
        }
    }

    /**
     * Uses given input to determine whether to select the confirmed checkbox
     *
     * @param confirmed
     */
    public void setConfirmed(boolean confirmed) {
        if (confirmed) {
            formContainer.confirmed.click();
        }
    }

    /**
     * Selects the submit button and submits the form
     */
    public void submitForm() {
        formContainer.submit.submit();
    }
}
