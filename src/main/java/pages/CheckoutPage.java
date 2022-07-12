package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private WebDriver driver;

    private CheckoutPage() {
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

}
