package automation.drivers.strategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class PhantomJs implements DriverStrategy {
    @Override
    public WebDriver setStrategy() {
        System.setProperty("phantomjs.binary.path", "src/main/resources/drivers/phantomjs");
        return new PhantomJSDriver();
    }
}
