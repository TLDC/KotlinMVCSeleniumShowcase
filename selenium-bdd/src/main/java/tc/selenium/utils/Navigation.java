package tc.selenium.utils;

import tc.selenium.views.FormView;
import tc.selenium.views.SummaryView;

/**
 * Actions that can be performed on available views.
 *
 * @author sian.webster
 */
public class Navigation {

    /**
     * Selenium web driver
     */
    protected BrowserDriver browserDriver;

    /**
     * Contains actions which can be performed on the form view
     */
    protected FormView formView;

    /**
     * Contains actions which can be performed on the summary view
     */
    protected SummaryView summaryView;

    /**
     * Uses given web driver to initialise form view and summary view and create Navigation object.
     * @param browserDriver
     */
    public Navigation(BrowserDriver browserDriver) {
        this.browserDriver = browserDriver;
        formView = new FormView(browserDriver);
        summaryView = new SummaryView(browserDriver);
    }

    /**
     * Complete all fields in form with given input
     * @param name
     * @param age
     * @param gender
     * @param height
     * @param confirmed
     */
    public void enterFormDetails(String name, int age, String gender, String height, boolean confirmed) {
        formView.setName(name);
        formView.setAge(age);
        formView.setGender(gender);
        formView.setHeight(height);
        formView.setConfirmed(confirmed);
    }

    /**
     * Submit the form
     */
    public void submitForm() {
        formView.submitForm();
    }

    /**
     * Assert that the summary screen is displayed and the values on the screen are as expected
     *
     * @param name
     * @param age
     * @param gender
     * @param height
     * @param confirmed
     */
    public void summaryScreenIsShown(String name, int age, String gender, String height, boolean confirmed) {
        summaryView.isDisplayedCheck();
        summaryView.assertAllValues(name, convertAge(age), gender, Double.parseDouble(height), confirmed);
    }

    /**
     * Convert given age to expected age
     * @param age
     * @return expectedAge
     */
    private int convertAge(int age) {
        if (age>30) {
            return 70;
        } else if (age<18) {
            return 10;
        } else {
            return 25;
        }
    }
}
