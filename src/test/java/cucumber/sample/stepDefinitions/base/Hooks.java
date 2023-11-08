package cucumber.sample.stepDefinitions.base;

import cucumber.sample.Utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.sql.Timestamp;


public class Hooks {


    @Before
    public void setUp(){

        Driver.getDriver();
    }

    @AfterStep

    //extent reports may be tried here.
    public void catchExceptionImage(Scenario scenario){
        if(scenario.isFailed()){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", timeMilliseconds);
        }
    }

    @After
    public void tearDown(){
        Driver.cleanUp();

    }
}
