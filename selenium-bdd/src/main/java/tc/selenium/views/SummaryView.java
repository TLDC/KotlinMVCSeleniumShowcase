package tc.selenium.views;

import org.apache.commons.codec.binary.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import tc.selenium.container.SummaryContainer;
import tc.selenium.utils.BrowserDriver;

/**
 * Actions which can be performed on elements in the summary view
 *
 * @author sian.webster
 */
public class SummaryView {

    /**
     * Selenium web driver
     */
    private BrowserDriver browserDriver;

    /**
     * Container for the web elements from the summary view
     */
    private final SummaryContainer summaryContainer;

    /**
     * Initialise web elements using current web driver
     *
     * @param browserDriver
     */
    public SummaryView(BrowserDriver browserDriver) {
        this.browserDriver = browserDriver;
        summaryContainer = PageFactory.initElements(browserDriver.getCurrentDriver(), SummaryContainer.class);
    }

    /**
     * Checks that the page displayed contains the expected page title to assert
     * that the right page has been returned.
     */
    public void isDisplayedCheck() {
        Assert.assertTrue(browserDriver.getCurrentDriver().getPageSource().contains("Your Manos"));
    }

    /**
     * Asserts that all of the form values are as expected.
     *
     * @param name
     * @param age
     * @param gender
     * @param height
     * @param confirmed
     */
    public void assertAllValues(String name, int age, String gender, double height, boolean confirmed) {
        assertName(name);
        assertAge(age);
        assertGender(gender);
        assertHeight(height);
        assertConfirmed(confirmed);
    }

    /**
     * Asserts that the name field is as expected.
     *
     * @param expectedName
     */
    public void assertName(String expectedName) {
        String expectedText = expectedName + " Manos";
        Assert.assertTrue("Expected " + expectedText + " but was " + summaryContainer.name.getText(),
                StringUtils.equals(expectedText, summaryContainer.name.getText()));
    }

    /**
     * Asserts that the age field is as expected.
     *
     * @param expectedAge
     */
    public void assertAge(int expectedAge) {
        String expectedText = expectedAge + " years old";
        Assert.assertTrue("Expected " + expectedText + " but was " + summaryContainer.age.getText(),
                StringUtils.equals(expectedText, summaryContainer.age.getText()));
    }

    /**
     * Asserts that the gender field is as expected.
     *
     * @param expectedGender
     */
    public void assertGender(String expectedGender) {
        Assert.assertTrue("Expected " + expectedGender + " but was " + summaryContainer.gender.getText(),
                StringUtils.equals(expectedGender, summaryContainer.gender.getText()));
    }

    /**
     * Asserts that the height field is as expected.
     *
     * @param expectedHeight
     */
    public void assertHeight(double expectedHeight) {
        String expectedText = expectedHeight + "cm";
        Assert.assertTrue("Expected " + expectedText + " but was " + summaryContainer.height.getText(),
                StringUtils.equals(expectedText, summaryContainer.height.getText()));
    }

    /**
     * Asserts that the confirmed field is as expected.
     *
     * @param confirmed
     */
    public void assertConfirmed(boolean confirmed) {
        String expectedText;
        if (confirmed) {
            expectedText = "I am a Manos";
        } else {
            expectedText = "I am a FAKE Manos";
        }
        Assert.assertTrue("Expected " + expectedText + " but was " + summaryContainer.confirmed.getText(),
                StringUtils.equals(expectedText, summaryContainer.confirmed.getText()));
    }
}
