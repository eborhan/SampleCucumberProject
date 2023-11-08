package cucumber.sample.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Driver2 {

    //It cannot be used for parallel execution. For parallel execution driver should be defined as a ThreadLocal variable

    private Driver2(){

    }

    private static WebDriver driver;

    public static WebDriver get() {
        if (driver == null) {
            String browser = null;
            switch (getBrowserType()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS does not support Internet Explorer");
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows"))
                        throw new WebDriverException("Your OS does not support Edge");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    if (!System.getProperty("os.name").toLowerCase().contains("mac"))
                        throw new WebDriverException("Your OS does not support Safari");
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
            }
        }
        return driver;
    }

    private static String getBrowserType(){

        String browserType = null;

        try {
            Properties properties = new Properties();
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);
            browserType = properties.getProperty("browser").toLowerCase().trim();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return browserType;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
