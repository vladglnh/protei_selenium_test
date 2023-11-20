package pages;

import bases.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ListPage extends BasePage {

    @FindBy(id = "dataEmail")
    private WebElement emailInput;

    @FindBy(id = "dataName")
    private WebElement nameInput;

    @FindBy(id = "dataGender")
    private WebElement genderSelect;
    public enum Gender {
        MALE,
        FEMALE
    }

    @FindBy(id = "dataCheck11")
    private WebElement variant11Check;

    @FindBy(id = "dataCheck12")
    private WebElement variant12Check;

    @FindBy(id = "dataSelect21")
    private WebElement variant21Radio;

    @FindBy(id = "dataSelect22")
    private WebElement variant22Radio;

    @FindBy(id = "dataSelect23")
    private WebElement variant23Radio;

    @FindBy(id = "dataSend")
    private WebElement submitButton;
    public enum Variants2x {
        VARIANT21,
        VARIANT22,
        VARIANT23
    }

    public ListPage setRecordValue(String email, String name, Gender gender, boolean variant11, boolean variant12, Variants2x variant2x){
        emailInput.sendKeys(email);
        nameInput.sendKeys(name);
        switch (gender) {
            case MALE -> new Select(genderSelect).selectByIndex(0);
            case FEMALE -> new Select(genderSelect).selectByIndex(1);
        }
        if (variant11) variant11Check.click();
        if (variant12) variant12Check.click();
        switch (variant2x) {
            case VARIANT21 -> variant21Radio.click();
            case VARIANT22 -> variant22Radio.click();
            case VARIANT23 -> variant23Radio.click();
        }
        submitButton.click();
        return this;
    }

    public ListPage(){
        PageFactory.initElements(driver,this);
    }
}
