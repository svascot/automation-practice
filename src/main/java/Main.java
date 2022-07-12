import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.FrameworkProperties;

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();

        driver.get("http://automationpractice.com");

        HomePage homePage = new HomePage();
        homePage.addFirstElementToCart();
        homePage.addSecondCElementToCart();


    }
}
