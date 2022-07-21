package automation.glue;

import automation.config.AutomationFrameworkConfiguration;
import automation.drivers.DriverSingleton;
import automation.pages.CheckoutPage;
import automation.pages.HomePage;
import automation.pages.SignInPage;
import automation.utils.ConfigurationProperties;
import automation.utils.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {

    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private CheckoutPage checkoutPage;

    @Autowired
    ConfigurationProperties configurationProperties;

    @Before
    public void initializeObjects() {
//        DriverSingleton.getInstance(configurationProperties.getBrowser());
        DriverSingleton.getInstance(Constants.CHROME);
        homePage = new HomePage();
        signInPage = new SignInPage();
        checkoutPage = new CheckoutPage();
    }

    /*@After
    public static void closeObjects() {
        DriverSingleton.closeObjectInstance();
    }*/

    @Given("^I go to the Website")
    public void i_go_to_the_Website() {
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
    }

    @When("^I click on Sign In button")
    public void i_click_on_Sign_In_button() {
        homePage.clickSignIn();
    }

    @When("^I add two elements to the cart")
    public void i_add_two_elements_to_the_cart () {
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCartAndProceedToCheckout();
    }

    @And("^I specify my credentials and click Login")
    public void i_specify_my_credentials_and_click_Login() {
//        signInPage.logIn(configurationProperties.getEmail(), configurationProperties.getPassword());
        signInPage.logIn("c3Zhc2NvdEBnbWFpbC5jb20=", "MTIzNDU2Nzg=");
    }

    @And("^I proceed to checkout")
    public void i_proceed_to_checkout() {
        checkoutPage.goToCheckout();
    }

    @And("^I confirm address, shipping, payments and final order")
    public void i_confirm_address_shipping_payments_and_final_order() {
        checkoutPage.confirmAddress();
        checkoutPage.confirmShipping();
        checkoutPage.payByBankWire();
        checkoutPage.confirmFinalOrder();
    }
    @Then("^I can log into the website")
    public void i_can_log_into_the_website() {
//        assertEquals(configurationProperties.getUsername(), homePage.getUsername());
        assertEquals("Santiago Vasco", homePage.getUsername());
    }

    @Then("^the elements are bought")
    public void the_elements_are_bought() {
        assertEquals(Constants.COMPLETE_ORDER_MESSAGE, checkoutPage.getOrderConfirmationMessage());
    }

}
