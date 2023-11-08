package cucumber.sample.stepDefinitions;

import cucumber.sample.Utilities.Driver;
import cucumber.sample.pages.BasePage;
import cucumber.sample.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login_Steps extends BasePage {

    private LoginPage loginPage = new LoginPage();

    @Given("I access the webdriveruniversity login page")
    public void ı_access_the_webdriveruniversity_login_page() {
        loginPage.navigateToWebDriverUniversityLoginPage();
    }

    @When("I enter a username {}")
    public void ı_enter_a_username(String username) {
        //driver.findElement(By.xpath("//input[@id='text']")).sendKeys(username);
        //sendKeys(By.xpath("//input[@id='text']"), username);
        loginPage.sendUsername(username);
    }

    @And("I enter a password {word}")
    public void ı_enter_a_password(String password) {
        //driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        loginPage.sendpassword(password);
    }

    @And("I click login button")
    public void ı_click_login_button() {
        //driver.findElement(By.xpath("//button[@id='login-button']")).click();
        loginPage.clickButton();
    }

    @Then("I should be presented with validation success message")
    public void ı_should_be_presented_with_validation_success_message() {
        //String actualMessage = driver.switchTo().alert().getText();
        //String expectedMessage = "validation succeeded";

        //Assert.assertEquals(actualMessage, expectedMessage, "verify the success message");

        loginPage.validateSuccessfulMessage();

    }

    @Then("I should be presented with validation failed message")
    public void ı_should_be_presented_with_validation_failed_message() {

        //String actualMessage = driver.switchTo().alert().getText();
        //String expectedMessage = "validation failed";

        //Assert.assertEquals(actualMessage, expectedMessage, "verify the failiure message");

        loginPage.validateUnsuccessfulMessage();

    }
    @Then("I should be presented with the following message {}")
    public void ı_should_be_presented_with_the_following_message(String expectedMessage) {

        waitForAlertAndValidate(expectedMessage);

    }
}