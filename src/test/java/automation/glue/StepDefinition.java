package automation.glue;

import automation.config.AutomationFrameworkConfiguration;
import automation.drivers.DriverSingleton;
import automation.pages.CheckoutPage;
import automation.pages.HomePage;
import automation.pages.SignInPage;
import automation.utils.ConfigurationProperties;
import automation.utils.Constants;
import automation.utils.TestCases;
import automation.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.Assert.assertTrue;

@ContextConfiguration(classes = AutomationFrameworkConfiguration.class)
public class StepDefinition {

    private WebDriver driver;
    private HomePage homePage;
    private SignInPage signInPage;
    private CheckoutPage checkoutPage;
    ExtentTest test;
    static ExtentReports report = new ExtentReports("report/TestReport.html");

    @Autowired
    ConfigurationProperties configurationProperties;

    @Before
    public void initializeObjects() {
//        DriverSingleton.getInstance(configurationProperties.getBrowser());
        DriverSingleton.getInstance(Constants.CHROME);

        homePage = new HomePage();
        signInPage = new SignInPage();
        checkoutPage = new CheckoutPage();

        TestCases[] testCases = TestCases.values();
        test = report.startTest(testCases[Utils.testCount].getTestName());
        Utils.testCount++;
    }

    @After
    public void closeObjects() {
        report.endTest(test);
        report.flush();
    }

    @AfterAll
    public static void closeDriver(){
        DriverSingleton.closeObjectInstance();
    }

    @Given("^I go to the Website")
    public void i_go_to_the_Website() {
        driver = DriverSingleton.getDriver();
        driver.get(Constants.URL);
        test.log(LogStatus.PASS, "Navigating to " + Constants.URL);
    }

    @When("^I click on Sign In button")
    public void i_click_on_Sign_In_button() {
        homePage.clickSignIn();
        test.log(LogStatus.PASS, "Sign In button has been clicked.");
    }

    @When("^I add two elements to the cart")
    public void i_add_two_elements_to_the_cart() {
        homePage.addFirstElementToCart();
        homePage.addSecondElementToCartAndProceedToCheckout();
        test.log(LogStatus.PASS, "Two elements were added to the cart.");
    }

    @And("^I specify my credentials and click Login")
    public void i_specify_my_credentials_and_click_Login() {
//        signInPage.logIn(configurationProperties.getEmail(), configurationProperties.getPassword());
        signInPage.logIn("c3Zhc2NvdEBnbWFpbC5jb20=", "MTIzNDU2Nzg=");
        test.log(LogStatus.PASS, "Login has been clicked.");
    }

    @And("^I proceed to checkout")
    public void i_proceed_to_checkout() {
        checkoutPage.goToCheckout();
        test.log(LogStatus.PASS, "Proceed to checkout.");
    }

    @And("^I confirm address, shipping, payments and final order")
    public void i_confirm_address_shipping_payments_and_final_order() {
        checkoutPage.confirmAddress();
        checkoutPage.confirmShipping();
        checkoutPage.payByBankWire();
        checkoutPage.confirmFinalOrder();
        test.log(LogStatus.PASS, "Confirm the final order.");
    }

    @Then("^I can log into the website")
    public void i_can_log_into_the_website() {
//        assertEquals(configurationProperties.getUsername(), homePage.getUsername());
        var result = "Santiago Vasco".equals(homePage.getUsername());
        if (result) {
            test.log(LogStatus.PASS, "The authentication is successful.");
        } else {
            test.log(LogStatus.FAIL, "The authentication is not successful.");
        }
        assertTrue(result);
    }

    @Then("^the elements are bought")
    public void the_elements_are_bought() {
        var result = Constants.COMPLETE_ORDER_MESSAGE.equals(checkoutPage.getOrderConfirmationMessage());
        if (result) {
            test.log(LogStatus.PASS, "The two items are bought.");
        } else {
            test.log(LogStatus.FAIL, "The items weren't bought.");
        }
        assertTrue(result);
    }

}
