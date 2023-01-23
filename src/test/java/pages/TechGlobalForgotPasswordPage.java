package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalForgotPasswordPage extends TechGlobalBasePage{
    public TechGlobalForgotPasswordPage(){
        super();
    }

    @FindBy(id = "main_heading")
    public WebElement mainHeader;

    @FindBy(id = "sub_heading")
    public WebElement resetPasswordHeader;

    @FindBy(xpath = "//input[@id='email']/../label")
    public WebElement resetPasswordTest;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "submit")
    public WebElement submitButton;
}
