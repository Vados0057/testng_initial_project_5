package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingHomePage;
import pages.TechGlobalLoginFormPage;
import utilities.ConfigReader;
import utilities.Waiter;

public class TechGlobalLoginFormTest extends TechGlobalBase {

            /*
            Test Case 1: Validate TechGlobal Login Form card
        Given user is on https://techglobal-training.netlify.app/
        When user clicks on "Practices" dropdown in the header
        And user select the "Frontend Testing" option
        And user clicks on the "Login Form" card
        Then user should heading1 as “Login Form”
        And user should see “Please enter your username” label and username input box
        And user should see “Please enter your password” label and password input box
        And user should see “LOGIN” button
        And user should see “Forgot Password?” link
            */

    @BeforeMethod
    public void setPage() {
        techGlobalFrontendTestingHomePage = new TechGlobalFrontendTestingHomePage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
    }

    @Test
    public void validateTechGlobalLoginFormCard() {

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        Assert.assertEquals(techGlobalLoginFormPage.mainHeading.getText(), "Login Form");

        Assert.assertTrue(techGlobalLoginFormPage.userNameLabel.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.userNameLabel.getText(), "Please enter your username");
        Assert.assertTrue(techGlobalLoginFormPage.userNameInput.isDisplayed());

        Assert.assertTrue(techGlobalLoginFormPage.userPasswordLabel.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.userPasswordLabel.getText(), "Please enter your password");
        Assert.assertTrue(techGlobalLoginFormPage.userPasswordInput.isDisplayed());

        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.forgotPasswordOption.isDisplayed());
    }

    @Test
    public void validateTechGlobalLoginFormCardValidLogin(){

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.userNameInput.sendKeys("TechGlobal");
        techGlobalLoginFormPage.userPasswordInput.sendKeys("Test1234");
        techGlobalLoginFormPage.loginButton.click();

        Assert.assertTrue(techGlobalLoginFormPage.loggedInMessage.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.loggedInMessage.getText(),"You are logged in");

        Assert.assertTrue(techGlobalLoginFormPage.logoutButton.isDisplayed());
    }

    @Test
    public void  validateTechGlobalLoginFormCardValidLoginAndThenLogout(){
        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(15);

        techGlobalLoginFormPage.userNameInput.sendKeys("TechGlobal");
        techGlobalLoginFormPage.userPasswordInput.sendKeys("Test1234");
        techGlobalLoginFormPage.loginButton.click();

        techGlobalLoginFormPage.logoutButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isDisplayed());
    }

}
