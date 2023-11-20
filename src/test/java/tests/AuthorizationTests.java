package tests;

import bases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AuthPage;
public class AuthorizationTests extends BaseTest {

    public static AuthPage authPage;
    @AfterMethod
    public void clearLoginPage(){
        driver.navigate().refresh();
    }

    @BeforeMethod
    public void setPage(){
        authPage = new AuthPage();
    }

    @Test()
    public void positiveLogin(){
        authPage.loginOnForm("test@protei.ru", "test");
        Assert.assertEquals(authPage.checkAuthPageIsDisplayed(),false, "Страница аутентифкации скрылась после логона");
    }

    @DataProvider
    public Object[][] emailFormatDataProvider(){
        return new String[][]{new String[]{"asdasd", "test", "Неверный формат E-Mail"},
                new String[]{"", "", "Неверный формат E-Mail"}};
    }
    @Test(dataProvider = "emailFormatDataProvider")
    public void emailFormatNegativeLogin(String login, String password, String error){
        authPage.loginOnForm(login, password);
        Assert.assertEquals(authPage.getEmailFormatErrorText(), encodeToUtf8(error), "Предоставление аутентификационных данных и проверка текста ошибки неверного формата почты");
    }

    @DataProvider
    public Object[][] invlidDataDataProvider(){
        return new String[][]{new String[]{"test@protei.ru", "asdasd", "Неверный E-Mail или пароль"},
                new String[]{"asdasd@s", "test", "Неверный E-Mail или пароль"}};
    }
    @Test(dataProvider = "invlidDataDataProvider")
    public void ivalidDataNegativeLogin(String login, String password, String error){
        authPage.loginOnForm(login, password);
        Assert.assertEquals(authPage.getInvalidEmailPasswordErrorText(), encodeToUtf8(error), "Предоставление аутентификационных данных и проверка текста ошибки инвалидных данных для входа");
    }
}
