package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearchTest {
    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void SearchOnGoogle(){
        driver = new ChromeDriver();
        driver.get("https://google.com");

        WebElement acceptCookiesButton = driver.findElement(By.id("L2AGLb"));
        acceptCookiesButton.click();

        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys("Google Atelierul Digital", Keys.ENTER);

        WebElement googleAtelierulDigitalLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div[1]/div/div/span/a/h3"));
        googleAtelierulDigitalLink.click();

        WebElement aflaMaiMulteLink = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div[2]/a/span"));
        new Actions(driver).scrollToElement(aflaMaiMulteLink).perform();
    }
}
