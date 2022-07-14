import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SignInPage;
import utils.Constants;
import utils.FrameworkProperties;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        FrameworkProperties frameworkProperties = new FrameworkProperties();
        DriverSingleton driverSingleton = DriverSingleton.getInstance(frameworkProperties.getProperty("browser"));
        WebDriver driver = DriverSingleton.getDriver();

        driver.get(Constants.URL);

        HomePage homePage = new HomePage();
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCartAndProceedToCheckout();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.goToCheckout();

        SignInPage signInPage = new SignInPage();
        signInPage.logIn(frameworkProperties.getProperty(Constants.EMAIL), frameworkProperties.getProperty(Constants.PASSWORD));

        checkoutPage.confirmAddress();
        checkoutPage.confirmShipping();
        checkoutPage.payByBankWire();
        checkoutPage.confirmFinalOrder();
        if (checkoutPage.getOrderConfirmationMessage().equals(Constants.COMPLETE_ORDER_MESSAGE)) {
            System.out.println("Test case completed");
        }

        DriverSingleton.closeObjectInstance();
    }
}
