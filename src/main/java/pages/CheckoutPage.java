package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage() {
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "head > title")
    private WebElement pageTitle;

    @FindBy(css = "#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium > span")
    private WebElement checkoutSummaryBtn;

    @FindBy(css = "#center_column > form > p > button > span")
    private WebElement checkoutConfirmAddressBtn;

    @FindBy(id = "cgv")
    private WebElement confirmShippingCheckBox;

    @FindBy(css = "#form > p > button > span")
    private WebElement checkoutConfirmShippingBtn;

    @FindBy(css = "#HOOK_PAYMENT > div:nth-child(1) > div > p > a")
    private WebElement payByBankWireOption;

    @FindBy(css = "#cart_navigation > button > span")
    private WebElement confirmOrderBtn;

    @FindBy(css = "#center_column > div > p > strong")
    private WebElement orderConfirmationMessage;

    @FindBy(id="summary_products_quantity")
    private WebElement summaryProductsQuantity;

    public Boolean checkTitle(String title) {
        return pageTitle.getText().equals(title);
    }

    public void goToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutSummaryBtn));
        checkoutSummaryBtn.click();
    }

    public void confirmAddress() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutConfirmAddressBtn));
        checkoutConfirmAddressBtn.click();
    }

    public void confirmShipping() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(checkoutConfirmShippingBtn));
        confirmShippingCheckBox.click();
        checkoutConfirmShippingBtn.click();
    }

    public void payByBankWire() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(payByBankWireOption));
        payByBankWireOption.click();
    }

    public void confirmFinalOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrderBtn));
        confirmOrderBtn.click();
    }

    public String getOrderConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(orderConfirmationMessage));
        return orderConfirmationMessage.getText();
    }

    public String getSummaryProductsQuantity() {
        return summaryProductsQuantity.getText();
    }
}
