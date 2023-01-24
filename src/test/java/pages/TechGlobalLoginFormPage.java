package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TechGlobalLoginFormPage extends TechGlobalBasePage {

    public TechGlobalLoginFormPage() {
        super();
    }

    @FindBy(xpath = "//input[@id='username']/../label")
    public WebElement userNameLabel;

    @FindBy(xpath = "//input[@id='password']/../label")
    public WebElement userPasswordLabel;

    @FindBy(id = "username")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement userPasswordInput;

    @FindBy(css = "#login_btn")
    public WebElement loginButton;

    @FindBy(css = "#success_lgn")
    public WebElement loggedInMessage;

    @FindBy(css = "#logout")
    public WebElement logoutButton;

    @FindBy(id = "forgot-password")
    public WebElement forgotPasswordOption;

    @FindBy(id = "main_heading")
    public WebElement mainHeading;

    @FindBy(id = "sub_heading")
    public WebElement resetPasswordHeading;

    @FindBy(xpath = "//input[@id='email']/../label")
    public WebElement resetPasswordText;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "error_message")
    public WebElement errorMessage;

    public void enterCredentials(String userName, String password) {
        userNameInput.sendKeys(userName);
        userPasswordInput.sendKeys(password);
    }


}
