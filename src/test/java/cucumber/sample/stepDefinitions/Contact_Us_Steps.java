package cucumber.sample.stepDefinitions;

import cucumber.sample.Utilities.Driver;
import cucumber.sample.pages.BasePage;
import cucumber.sample.pages.ContactUsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Contact_Us_Steps extends BasePage {

    private ContactUsPage contact = new ContactUsPage();


    @Given("I access the webdriveruniversity contact us page")
    public void ı_access_the_webdriveruniversity_contact_us_page() {
       contact.navigateToContactUsPage();
    }


    @When("I enter a unique first name")
    public void ı_enter_a_unique_first_name() {
        //driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("Auto_FN" + generateRandomNumber(5));
        contact.setUniqueFirstName();
    }

    @And("I enter a unique last name")
    public void ı_enter_a_unique_last_name() {
        //driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("Auto_LN" + generateRandomNumber(5));
        contact.setUniqueLastName();
    }

    @And("I enter a unique email address")
    public void ı_enter_a_unique_email_address() {

        //driver.findElement(By.xpath("//input[@name='email']")).sendKeys(fakeEmail());
        contact.setUniqueEmail();
    }

    @And("I enter a unique comment")
    public void ı_enter_a_unique_comment() {
        //driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Hello world " + generateRandomString(20));
        contact.setUniqueComment();
    }

    @And("I click on the submit button")
    public void ı_click_on_the_submit_button() {
        //driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
        //click(By.xpath("//input[@value='SUBMIT']"));
        contact.clickButton();
    }

    @When("I enter a specific first name {word}")
    public void ı_enter_a_specific_name(String firstName) {
        //driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
        //sendKeys(By.xpath("//input[@name='first_name']"), firstName);
        contact.setSpecificFirstName(firstName);

    }

    @And("I enter a specific last name {word}")
    public void ı_enter_a_specific_last_name(String lastName) {
        //driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
        contact.setSpecificLastName(lastName);

    }

    @And("I enter a specific email address {word}")
    public void ı_enter_a_specific_email_address(String email) {
        //driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
        contact.setSpecificEmail(email);
    }

    @And("I enter a specific comment {string}")
    public void ı_enter_a_specific_comment(String comment) {
        //driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
        contact.setSpecificComment(comment);

    }

    @Then("I should be presented with a successful contact us submission message")
    public void ı_should_be_presented_with_a_successful_contact_us_submission_message() {
        //WebElement message = driver.findElement(By.xpath("//h1[.='Thank You for your Message!']"));
        //Assert.assertEquals(message.getText(), "Thank You for your Message!");
        contact.validateMessage();

    }


}
