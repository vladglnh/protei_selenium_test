package bases;

import org.openqa.selenium.WebDriver;

abstract public class BasePage {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver){
        driver = webDriver;
        driver.get( (System.getProperty("user.dir")) + "\\src\\test\\resources\\qa-test.html" );
    }
}
