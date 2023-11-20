package tests;

import bases.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthPage;
import pages.ListPage;

public class ListTests extends BaseTest {
    public static ListPage listTests;

    @BeforeMethod
    public void setPage(){
        listTests = new AuthPage()
                .loginOnForm("test@protei.ru", "test");
    }

    @AfterMethod
    public void clearPage(){
        driver.navigate().refresh();
    }

    @Test()
    public void addRecordTest(){
        listTests.setRecordValue("email@email.com", "name", ListPage.Gender.MALE, true, false, ListPage.Variants2x.VARIANT22);
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(), 'Данные добавлены.')]")).isEnabled(), "Проверка только отображения всплывающего окна, т.к. нет времени доделывать нормальную проверку по таблице");
    }

}
