package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.time.Duration;

public class HomePage {

    WebDriver driver;

    public HomePage() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")
    private WebElement addToCartFirst;

    @FindBy(css = "#homefeatured > li:nth-child(2) > div > div.right-block > div.button-container > a.button.ajax_add_to_cart_button.btn.btn-default")
    private WebElement addToCartSecond;

    @FindBy(css = "#header > div:nth-child(3) > div > div > div:nth-child(3) > div > a")
    private WebElement cart;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > span > span")
    private WebElement continueShoppingBtn;

    @FindBy(css = "#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a")
    private WebElement proceedToTheCheckoutBtn;

    @FindBy(css = "#homefeatured > li.ajax_block_product.col-xs-12.col-sm-4.col-md-3.first-in-line.first-item-of-tablet-line.first-item-of-mobile-line")
    private WebElement firstElement;

    @FindBy(css = "#homefeatured > li:nth-child(2)")
    private WebElement secondElement;

    @FindBy(css = "#header > div.nav > div > div > nav > div.header_user_info > a")
    private WebElement signInBtn;

    @FindBy(css = "#header > div.nav > div > div > nav > div:nth-child(1) > a > span")
    private WebElement username;

    public String getUsername() {
        return username.getText();
    }

    public void clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
        signInBtn.click();
    }

    public void addFirstElementToCart() {
        Actions hover = new Actions(driver);
        hover.moveToElement(firstElement).build().perform();

        addToCartFirst.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingBtn));

        continueShoppingBtn.click();

        if (cart.getText().contains(Constants.CART_QUANTITY)) {
            System.out.println("Cart has been updated");
        } else {
            System.out.println("Cart has not been updated");
        }
    }

    public void addSecondCElementToCart() {
        Actions hover = new Actions(driver);
        hover.moveToElement(secondElement).build().perform();

        addToCartSecond.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToTheCheckoutBtn));

        proceedToTheCheckoutBtn.click();
    }

}
