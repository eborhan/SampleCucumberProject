package cucumber.sample.pages;

import com.github.javafaker.Faker;
import cucumber.sample.Utilities.Driver;
import cucumber.sample.Utilities.GlobalVariables;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public abstract class BasePage {

    protected WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(GlobalVariables.DEFAULT_EXPLICIT_TIMEOUT));

    public BasePage() {

        PageFactory.initElements(Driver.getDriver(), this);

    }

    public WebDriver getDriver() {
        return Driver.getDriver();
    }

    public void navigateTo(String url) {
        Driver.getDriver().get(url);
    }

    public String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public String generateRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public String fakeEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public void sendKeys(By by, String textToType) {
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }

    public void sendKeys(WebElement element, String textToType) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }

    public void waitFor(By by) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public void waitFor(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void waitForAlertAndValidate(String text) {
        wait.until(ExpectedConditions.alertIsPresent());
        String alertMessage = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(alertMessage, text);
    }
}
