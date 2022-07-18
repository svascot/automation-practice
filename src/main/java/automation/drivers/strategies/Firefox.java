package automation.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox implements DriverStrategy {

    @Override
    public WebDriver setStrategy() {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
        return new FirefoxDriver();
    }
}
