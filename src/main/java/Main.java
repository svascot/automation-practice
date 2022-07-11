import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import utils.FrameworkProperties;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();

        driver.get("http://automationpractice.com");
        TimeUnit.SECONDS.sleep(2);

        DriverSingleton.closeObjectInstance();
    }
}
