import drivers.DriverSingleton;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SignInPage;
import utils.FrameworkProperties;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static utils.Constants.BROWSER;
import static utils.Constants.URL;

@RunWith(Parameterized.class)
public class SearchTest {

    static FrameworkProperties frameworkProperties;
    static WebDriver driver;
    static HomePage homePage;
    static SignInPage signInPage;
    static CheckoutPage checkoutPage;
    static String inputString;
    static Boolean expectedResult;

    public SearchTest(String inputString, Boolean expectedResult) {
        this.inputString = inputString;
        this.expectedResult = expectedResult;
    }

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

    @Parameterized.Parameters
    public static Collection searchOptions() {
        return Arrays.asList(new Object[][]{
                {"Shirt", true},
                {"Blouse", true},
                {"Dress", true},
                {"Test", false},
                {"", false}
        });
    }

    @Test
    public void test_search() {
        driver.get(URL);
        assertEquals(expectedResult, homePage.searchElement(inputString));
    }
}
