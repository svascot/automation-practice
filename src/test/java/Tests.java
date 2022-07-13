import drivers.DriverSingleton;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SignInPage;
import utils.FrameworkProperties;

import static org.junit.Assert.assertEquals;
import static utils.Constants.*;


public class Tests {
    static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static HomePage homePage;
    static SignInPage signInPage;
    static CheckoutPage checkoutPage;

    @BeforeClass
    public static void initialize() {
        frameworkProperties = new FrameworkProperties();
        DriverSingleton.getInstance(frameworkProperties.getProperty(BROWSER));
        driver = DriverSingleton.getDriver();
        homePage = new HomePage();
        signInPage = new SignInPage();
        checkoutPage = new CheckoutPage();
    }

    @AfterClass
    public static void closeObjects() {
        driver.close();
    }

    @Test
    public void testAuthentication() {
        driver.get(URL);
        homePage.clickSignIn();
        signInPage.logIn(frameworkProperties.getProperty(EMAIL), frameworkProperties.getProperty(PASSWORD));
        assertEquals(frameworkProperties.getProperty(USERNAME), homePage.getUsername());
    }


}
