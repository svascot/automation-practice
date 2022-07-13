package pages;

import drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Utils;

public class SignInPage {

    private WebDriver driver;

    public SignInPage () {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement signInEmail;

    @FindBy(id = "passwd")
    private WebElement signInPassword;

    @FindBy(id = "SubmitLogin")
    private WebElement signInBtn;

    @FindBy(id = "email_create")
    private WebElement signUpEmail;

    @FindBy(id = "SubmitCreate")
    private WebElement signUpBtn;

    public void logIn (String email, String password) {
       signInEmail.sendKeys(Utils.decoded64(email));
       signInPassword.sendKeys(Utils.decoded64(password));
       signInBtn.click();
    }

    public void signUp (String email) {
        signUpEmail.sendKeys(email);
        signUpBtn.click();
    }

}
