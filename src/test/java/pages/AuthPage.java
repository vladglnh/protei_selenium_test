package pages;

import bases.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage extends BasePage {

    @FindBy(id = "authPage")
    private WebElement page;

    @FindBy(id = "loginEmail")
    private WebElement emailInput;

    @FindBy(id = "loginPassword")
    private WebElement passwordInput;

    @FindBy(id = "authButton")
    private WebElement loginButton;

    @FindBy(id = "emailFormatError")
    private WebElement invalidEmailFormatError;

    @FindBy(id = "invalidEmailPassword")
    private WebElement invalidEmailPassword;



    public AuthPage(){
        //driver.get( (System.getProperty("user.dir")) + "\\src\\test\\resources\\qa-test.html" );
        PageFactory.initElements(driver, this);
    }

    public ListPage loginOnForm(String login, String password){
        emailInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ListPage();
    }

    public String getEmailFormatErrorText(){
        return invalidEmailFormatError.getText();
    }
    public String getInvalidEmailPasswordErrorText(){
        return invalidEmailPassword.getText();
    }

    public Boolean checkAuthPageIsDisplayed(){
        return page.isDisplayed();
    }
}
