import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        DriverSingleton driverSingleton = DriverSingleton.getInstance();
        WebDriver driver = DriverSingleton.getDriver();

        driver.get("http://automationpractice.com");
        TimeUnit.SECONDS.sleep(2);

        DriverSingleton.closeObjectInstance();
    }
}
