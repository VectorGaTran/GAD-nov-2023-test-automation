package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import tests.utils.SeleniumUtils;

import java.io.IOException;
import java.util.Properties;

public class BaseUITest {
    WebDriver driver;
    String url;
    String path;
    String pageUnderTestUrl;
    String browser;

    @BeforeClass
    public void setup() throws IOException {
        Properties properties = SeleniumUtils.readProperties("src\\test\\resources\\applications.Properties");
        url = properties.getProperty(("url"));
        path = properties.getProperty("path");
        pageUnderTestUrl = url + path;

        browser = properties.getProperty(("browser"));
        System.out.println("Page under test:"+ pageUnderTestUrl);
        System.out.println(("Browser: "+ browser));

    }

    @AfterClass
    public void close()
    {
        // if(driver != null)
        // {
        //     driver.quit();
        // }
    }
}
