package hooks;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class Hooks {

    public static WebDriver driver; 

    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "FailedScreenshot");
            
         // Attach to Extent Report using Base64 string
            String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
            String html = "<img src='data:image/png;base64," + base64Screenshot + "' height='400' width='500'/>";
            ExtentCucumberAdapter.addTestStepLog("Screenshot on failure:<br>" + html);
        }
    }
}