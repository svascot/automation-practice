import drivers.DriverSingleton;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SignInPage;
import utils.FrameworkProperties;

import static org.junit.Assert.assertEquals;
import static utils.Constants.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    public void test01_Authentication() {
        driver.get(URL);
        homePage.clickSignIn();
        signInPage.logIn(frameworkProperties.getProperty(EMAIL), frameworkProperties.getProperty(PASSWORD));
        assertEquals(frameworkProperties.getProperty(USERNAME), homePage.getUsername());
    }

    @Test
    public void test02_AddElementsToCart() {
        driver.get(URL);
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCartAndProceedToCheckout();
        assertEquals(SUMMARY_PRODUCTS_QUANTITY, checkoutPage.getSummaryProductsQuantity());
    }

    @Test
    public void test03_CompleteProcess() {
        driver.get(URL);

        homePage.addFirstElementToCart();
        homePage.addSecondElementToCartAndProceedToCheckout();

        checkoutPage.goToCheckout();
        checkoutPage.confirmAddress();
        checkoutPage.confirmShipping();
        checkoutPage.payByBankWire();
        checkoutPage.confirmFinalOrder();

        assertEquals(COMPLETE_ORDER_MESSAGE, checkoutPage.getOrderConfirmationMessage());
    }
}
