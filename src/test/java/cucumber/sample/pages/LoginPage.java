package cucumber.sample.pages;

import cucumber.sample.Utilities.Driver;
import cucumber.sample.Utilities.GlobalVariables;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends BasePage {


    @FindBy(xpath = "//input[@id='text']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@id='login-button']")
    public WebElement loginButton;

    public LoginPage() {
    }

    public void navigateToWebDriverUniversityLoginPage() {
        navigateTo(GlobalVariables.HOMEPAGE_URL + "/Login-Portal/index.html?");
    }

    public void sendUsername(String username) {
        sendKeys(usernameBox, username);
    }

    public void sendpassword(String password){
        sendKeys(passwordBox, password);

    }
    public void clickButton(){
        click(loginButton);
    }

    public void validateSuccessfulMessage(){
        waitForAlertAndValidate("validation succeeded");
    }
    public void validateUnsuccessfulMessage(){
        waitForAlertAndValidate("validation failed");
    }
}
