package uol.rfc.common;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(BlockJUnit4ClassRunner.class)
public class ChromeTestCase extends TestCase {

    private static ChromeDriverService service;
    private static WebDriver driver;

    public static WebDriver getCurrentDriver() {
        return driver;
    }

    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

    @Before
    public void createDriver() {
        driver = new FirefoxDriver(); //RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
    }

    @After
    public void quitDriver() {
        driver.quit();
    }

}