package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginModal {

    @FindBy(xpath = "//input[@data-placeholder='pokupatel@gmail.com']")
    public WebElement inputLogin;

    @FindBy(xpath = "//input[1][@name='pass']")
    public WebElement inputPass;

    @FindBy(xpath = "//button[1][.='войти']")
    public WebElement buttonLogin;

    public LoginModal fillLogin(String login) {
        inputLogin.sendKeys(login);
        return this;
    }
    public LoginModal fillPassword(String password) {
        inputPass.sendKeys(password);
        return this;
    }
    public LoginModal submitLogin() {
        buttonLogin.click();
        return this;
    }

    public void login (String login, String password) {
        inputLogin.sendKeys(login);
        inputPass.sendKeys(password);
        buttonLogin.click();
    }

    public LoginModal(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
