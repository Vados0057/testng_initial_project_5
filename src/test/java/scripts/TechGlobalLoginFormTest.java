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

        techGlobalFrontendTestingHomePage.getFrontendTestingPage();
        techGlobalFrontendTestingHomePage.clickOnCard(15);
    }
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

    @Test(priority = 1, description = "Validate TechGlobal Login Form card")
    public void validateTechGlobalLoginFormCard() {
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

    /*
    Test Case 2: Validate TechGlobal Login Form card valid login
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “Test1234”
    And user clicks on “LOGIN” button
    Then user should see “You are logged in” message
    And user should see “LOGOUT” button
     */

    @Test(priority = 2, description = "Validate TechGlobal Login Form card valid login")
    public void validateValidLogin() {
        techGlobalLoginFormPage.enterCredentials(ConfigReader.getProperty("loginUsername"), ConfigReader.getProperty("loginPassword"));
        techGlobalLoginFormPage.loginButton.click();

        Assert.assertTrue(techGlobalLoginFormPage.loggedInMessage.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.loggedInMessage.getText(), "You are logged in");

        Assert.assertTrue(techGlobalLoginFormPage.logoutButton.isDisplayed());
    }
        /*
        Test Case 3: Validate TechGlobal Login Form card valid login and then
        logout
        Given user is on https://techglobal-training.netlify.app/
        When user clicks on "Practices" dropdown in the header
        And user select the "Frontend Testing" option
        And user clicks on the "Login Form" card
        And user enters username as “TechGlobal” and password as “Test1234”
        And user clicks on “LOGIN” button
        And user clicks on “LOGOUT” button
        Then user should be navigated back to Login Form
        */

    @Test(priority = 3, description = "Validate TechGlobal Login Form card valid login and then logout")
    public void validateValidLoginAndThenLogout() {

        techGlobalLoginFormPage.enterCredentials(ConfigReader.getProperty("loginUsername"), ConfigReader.getProperty("loginPassword"));
        techGlobalLoginFormPage.loginButton.click();

        techGlobalLoginFormPage.logoutButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isDisplayed());
    }
        /*
        Test Case 4: Validate TechGlobal Login Form card Forgot Password?
        Link and Reset Password page
        Given user is on https://techglobal-training.netlify.app/
        When user clicks on "Practices" dropdown in the header
        And user select the "Frontend Testing" option
        And user clicks on the "Login Form" card
        And user clicks on “Forgot Password?” link
        Then user should see “Reset Password” heading1
        And user should see “Enter your email address and we'll send you a link to reset
        your password.” message
        And user should see email input box
        And user should see “SUBMIT” button
         */

    @Test(priority = 4, description = "Validate TechGlobal Login Form card Forgot Password? " +
            "Link and Reset Password page")
    public void validateForgotPasswordLinkAndResetPasswordPage() {
        techGlobalLoginFormPage.forgotPasswordOption.click();
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordHeading.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordText.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.resetPasswordText.getText(),
                "Enter your email address and we'll send you a link to reset your password.");
        Assert.assertTrue(techGlobalLoginFormPage.emailInput.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.submitButton.isDisplayed());
    }

     /*
        Test Case 5: Validate TechGlobal Login Form card Reset Password link
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user clicks on “Forgot Password?” link
    When user enters a valid email to email input box
    And user clicks on “SUBMIT” button
    Then user should see “A link to reset your password has been sent to your email
    address.” message
     */

    @Test(priority = 5, description = "Validate TechGlobal Login Form card Reset Password link")
    public void validateResetPasswordLink() {
        techGlobalLoginFormPage.forgotPasswordOption.click();
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordHeading.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.resetPasswordText.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.resetPasswordText.getText(),
                "Enter your email address and we'll send you a link to reset your password.");
        Assert.assertTrue(techGlobalLoginFormPage.emailInput.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.submitButton.isDisplayed());
    }

    /*
    Test Case 6: Validate TechGlobal Login Form card invalid login with
    wrong username
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “john” and password as “Test1234”
    And user clicks on “LOGIN” button
    Then user should see “Invalid Username entered!” message
     */

    @Test(priority = 6, description = "Validate TechGlobal Login Form card invalid login with\n" +
            "wrong username")
    public void validateInvalidLoginWithWrongUsername() {
        techGlobalLoginFormPage.enterCredentials(ConfigReader.getProperty("userName1"),
                ConfigReader.getProperty("loginPassword"));
        Waiter.pause(3);
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.errorMessage.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.errorMessage.getText(), ConfigReader.getProperty("wrongUsernameMessage"));
    }
    /*
        Test Case 7: Validate TechGlobal Login Form card invalid login with
    wrong password
    Given user is on https://techglobal-training.netlify.app/
    When user clicks on "Practices" dropdown in the header
    And user select the "Frontend Testing" option
    And user clicks on the "Login Form" card
    And user enters username as “TechGlobal” and password as “1234”
    And user clicks on “LOGIN” button
    Then user should see “Invalid Password entered!” message
     */

    @Test(priority = 7, description = "Validate TechGlobal Login Form card invalid login with\n" +
            "wrong password")
    public void validateInvalidLoginWithWrongPassword() {
        techGlobalLoginFormPage.enterCredentials(ConfigReader.getProperty("loginUsername"),
                ConfigReader.getProperty("wrongPassword"));
        Waiter.pause(3);
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.errorMessage.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.errorMessage.getText(), ConfigReader.getProperty("wrongPasswordMessage"));
    }
            /*
            Test Case 8: Validate TechGlobal Login Form card invalid login with
        both wrong credentials
        Given user is on https://techglobal-training.netlify.app/
        When user clicks on "Practices" dropdown in the header
        And user select the "Frontend Testing" option
        And user clicks on the "Login Form" card
        And user enters username as “john” and password as “1234”
        And user clicks on “LOGIN” button
        Then user should see “Invalid Username entered!” message
             */

    @Test(priority = 8, description = "Validate TechGlobal Login Form card invalid login with\n" +
            "both wrong credentials")
    public void validateInvalidLoginWithBothWrongCredentials() {
        techGlobalLoginFormPage.enterCredentials(ConfigReader.getProperty("userName1"),
                ConfigReader.getProperty("wrongPassword"));
        Waiter.pause(3);
        techGlobalLoginFormPage.loginButton.click();
        Assert.assertTrue(techGlobalLoginFormPage.errorMessage.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.errorMessage.getText(), ConfigReader.getProperty("wrongUsernameMessage"));
    }
}