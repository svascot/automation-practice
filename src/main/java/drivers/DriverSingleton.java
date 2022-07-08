package drivers;

import drivers.strategies.DriverStrategy;
import drivers.strategies.DriverStrategyImpl;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverSingleton {

    private static DriverSingleton instance = null;
    private static WebDriver driver;

    private DriverSingleton() {
        instantiate("Chrome");
    }

    public WebDriver instantiate(String strategy) {
        DriverStrategy driverStrategy = DriverStrategyImpl.choose(strategy);
        driver = driverStrategy.setStrategy();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        return driver;
    }

    public static DriverSingleton getInstance() {
        if (instance == null) {
            instance = new DriverSingleton();
        }
        return instance;
    }

    public static void closeObjectInstance() {
        instance = null;
        driver.close();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
