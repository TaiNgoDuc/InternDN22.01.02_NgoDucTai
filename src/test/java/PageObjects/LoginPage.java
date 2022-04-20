package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By _txtUsername = By.xpath("//input[@id='username']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _btnLogin = By.xpath("//input[@value='login']");
    private final By _lblLoginErrorMsg = By.xpath("//p[@class'message error LoginForm']");

    public WebElement getTxtUsername() {
        return Constant.DRIVER.findElement(_txtUsername);
    }

    public WebElement getTxtPassword() {
        return Constant.DRIVER.findElement(_txtPassword);
    }

    public WebElement getBtnLogin() {
        return Constant.DRIVER.findElement(_btnLogin);
    }

    public WebElement getLblLoginErrorMsg() {
        return Constant.DRIVER.findElement(_lblLoginErrorMsg);
    }

    public void login(String username, String password) {
        this.getTxtUsername().sendKeys(username);
        this.getTxtPassword().sendKeys(password);
        this.getBtnLogin().click();
    }
}
