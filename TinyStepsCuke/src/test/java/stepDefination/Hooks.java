
package stepDefination;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;

import Base.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentReportManager;

public class Hooks {
    private ExtentReports extent = ExtentReportManager.createInstance();
    private ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Before
    public void beforeScenario(Scenario scenario) {
    	ExtentTest test = extent.createTest(scenario.getName());
        extentTest.set(test);
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            // Get the driver instance from your DriverFactory
            WebDriver driver = DriverFactory.getDriver();

            // Take a screenshot using Selenium's TakesScreenshot interface
            TakesScreenshot ts = (TakesScreenshot) driver;
            File sourcePath = ts.getScreenshotAs(OutputType.FILE);

            // Define the path and filename for the screenshot
            String screenshotName = "Failure_" + "_" + System.currentTimeMillis() + ".png";
            Path destinationPath = Paths.get("./Screenshots", screenshotName);

            try {
                // Ensure the directory exists
                Files.createDirectories(destinationPath.getParent());

                // Copy the screenshot to the destination path
                FileUtils.copyFile(sourcePath, destinationPath.toFile());
                
                // Log the screenshot to your Extent Reports
                extentTest.get().fail("Screenshot on failure:",
                    MediaEntityBuilder.createScreenCaptureFromPath(destinationPath.toString()).build());

                // Attach the screenshot to the Cucumber report
                byte[] screenshotBytes = Files.readAllBytes(destinationPath);
                scenario.attach(screenshotBytes, "image/png", "screenshot");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Other actions on test completion
        extent.flush(); // Ensure ExtentReports are written
        DriverFactory.quitDriver(); // Quit the WebDriver instance
    }
}
