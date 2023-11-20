package bases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

abstract public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver", "./tests/resources/chromedriver.exe"); //todo: вынести в конфиг
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriverManager.chromedriver().clearResolutionCache().setup();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        BasePage.setDriver(driver);
    }

    @BeforeMethod
    public void setup(){
    }

    public String encodeToUtf8(String string){ //todo: вынести в хелпер
        return new String(string.getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
    }
    @AfterMethod
    public void teardown() {
    }

    @AfterClass
    public void closeBrowser(){
        driver.close();
        driver.quit();
    }
}
