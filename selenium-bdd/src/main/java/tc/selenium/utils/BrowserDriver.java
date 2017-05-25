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

    private static WebDriver webDriver;

    public enum Browser {IE, CHROME, FIREFOX};

    private static final String TEST_URL =
            (System.getProperty("test.url.and.context") == null ? "http://localhost:8080/kotlin-mvc/manosMaker"
                    : System.getProperty("test.url.and.context"));

    private static final Browser BROWSER = System.getProperty("test.browser") == null ? Browser.IE : Browser.valueOf(System.getProperty("test.browser"));

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
            webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            webDriver.get(TEST_URL);
        } catch (URISyntaxException e) {
            throw new IllegalStateException("Cannot find IE driver");
        }
    }

    public WebDriver getCurrentDriver() {
        return webDriver;
    }

    public void loadStartingPage() {
        webDriver.get(TEST_URL);
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

