package tc.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * Singleton class for managing the driver session
 * @author luke.starkie
 */
@Component
public class BrowserDriver {

    private WebDriver webDriver;

    public enum Browser {IE, CHROME, FIREFOX};

    private static final Browser BROWSER = System.getProperty("test.browser") == null ? Browser.CHROME : Browser.valueOf(System.getProperty("test.browser"));

    public void createBrowserDriver() {
        try {
            webDriver = null;
            URL url = null;
            switch (BROWSER) {
                case CHROME:
                    url = BrowserDriver.class.getClassLoader().getResource("chromedriver.exe");
                    System.setProperty("webdriver.chrome.driver", new File(url.toURI()).getAbsolutePath());
                    ChromeOptions options = new ChromeOptions();
                    options.setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
                    webDriver = new ChromeDriver(options);
                    break;
                case IE:
                    url = BrowserDriver.class.getClassLoader().getResource("IEDriverServer.exe");
                    System.setProperty("webdriver.ie.driver", new File(url.toURI()).getAbsolutePath());
                    webDriver = new InternetExplorerDriver();
                    break;
                case FIREFOX:
                    url = BrowserDriver.class.getClassLoader().getResource("geckodriver.exe");
                    System.setProperty("webdriver.gecko.driver", new File(url.toURI()).getAbsolutePath());
                    webDriver = new FirefoxDriver();
                    break;
            }
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Cannot find IE driver");
        }
    }

    public WebDriver getCurrentDriver() {
        return webDriver;
    }

    public void close() {
        try {
            webDriver.quit();
            webDriver = null;
        } catch (UnreachableBrowserException e) {
            e.printStackTrace();
        }
    }
}

