
package Base;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import stepDefination.Searchsteps;

public class DriverFactory {
    // The WebDriver instance is stored in a ThreadLocal variable to support parallel execution
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    
    // This method sets up the WebDriver instance
    public static void initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\eclipse-workspace\\SeleniumWorkspace\\TinyStepsCuke\\TinyStepsCuke\\src\\test\\resources\\chromedriver.exe"); // Set path to your chromedriver
        driver.set(new ChromeDriver());
        driver.get().manage().window().maximize();
        
      
        
//        log = Logger.getLogger("LogDemo");
//		PropertyConfigurator.configure("log4j2.properties");
//		log.setLevel(Level.DEBUG);
    }

    // This method returns the WebDriver instance
    public static WebDriver getDriver() {
        return driver.get();
    }

    // This method closes the WebDriver instances and quits the browser
    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
