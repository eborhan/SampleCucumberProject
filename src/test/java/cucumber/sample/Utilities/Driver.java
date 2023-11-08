package cucumber.sample.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Driver {
    private Driver() {
    }

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();


    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() {
        WebDriver driver = null;

        String browserType = null;

        switch (getBrowserType()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                break;
        }
        driver.manage().window().maximize();
        return driver;
    }

    private static String getBrowserType(){

        String browserType = null;
        String browserTypeRemoteValue = System.getProperty("browserType");

        try {
            if(browserTypeRemoteValue == null || browserTypeRemoteValue.isEmpty()){
                Properties properties = new Properties();
                FileInputStream file = new FileInputStream("configuration.properties");
                properties.load(file);
                browserType = properties.getProperty("browser").toLowerCase().trim();
            }
            else {
                browserType = browserTypeRemoteValue;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return browserType;
    }

    public static void cleanUp() {
        webDriver.get().quit();
        webDriver.remove();
    }
}


