package cucumber.sample.pages;

import cucumber.sample.Utilities.GlobalVariables;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage{

    @FindBy(xpath = "//input[@name='first_name']")
    public WebElement inputBoxname;

    @FindBy(xpath = "//input[@name='last_name']")
    public WebElement inputBoxLastname;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement inputBoxEmail;

    @FindBy(xpath = "//textarea[@name='message']")
    public WebElement inputBoxComment;

    @FindBy(xpath = "//input[@value='SUBMIT']")
    public WebElement submitButton;

    @FindBy(xpath = "//h1[.='Thank You for your Message!']")
    public WebElement actualMessage;

    public ContactUsPage(){}

    public void navigateToContactUsPage(){
        navigateTo(GlobalVariables.HOMEPAGE_URL +"/Contact-Us/contactus.html");
    }
    public void setUniqueFirstName(){
        sendKeys(inputBoxname, "Auto_FN" + generateRandomNumber(5));
    }
    public void setUniqueLastName(){
        sendKeys(inputBoxLastname, "Auto_LN" + generateRandomNumber(5));
    }
    public void setUniqueEmail(){
        sendKeys(inputBoxEmail, fakeEmail());
    }
    public void setUniqueComment(){
        sendKeys(inputBoxComment, "Hello world " + generateRandomString(20));
    }
    public void clickButton(){
        click(submitButton);
    }
    public void validateMessage(){
        String expectedMessage = "Thank You for your Message!";
        waitFor(actualMessage);
        Assert.assertEquals(actualMessage.getText(), expectedMessage);
    }
    public void setSpecificFirstName(String firstName){
        sendKeys(inputBoxname, firstName);
    }
    public void setSpecificLastName(String lastName) {
        sendKeys(inputBoxLastname, lastName);
    }
    public void setSpecificEmail(String email){
        sendKeys(inputBoxEmail, email);
    }
    public void setSpecificComment(String comment){
        sendKeys(inputBoxComment, comment);
    }
}
