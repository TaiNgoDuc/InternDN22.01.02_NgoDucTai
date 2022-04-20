package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BasePage {
    private final By _txtEmail = By.xpath("//input[@id='email']");
    private final By _txtPassword = By.xpath("//input[@id='password']");
    private final By _txtConfirmPassword = By.xpath("//input[@id='confirmPassword']");
    private final By _txtPID = By.xpath("//input[@id='pid']");
    private final By _btnRegister = By.xpath("//input[@type='submit']");

    private By _lblErrorRegister = By.xpath("//p[@class='message error']");
    private By _lblInvalidPassword = By.xpath("//label[contains(text(), 'Invalid password length')]");
    private By _lblInvalidID = By.xpath("//label[contains(text(), 'Invalid ID length')]");

    public WebElement getTxtEmail() {
        return Constant.DRIVER.findElement(_txtEmail);
    }
    public WebElement getTxtPassword() {
        return Constant.DRIVER.findElement(_txtPassword);
    }
    public WebElement getTxtConfirmPassword() {
        return Constant.DRIVER.findElement(_txtConfirmPassword);
    }
    public WebElement getTxtPID() { return Constant.DRIVER.findElement(_txtPID); }
    public WebElement getBtnRegister() {
        return Constant.DRIVER.findElement(_btnRegister);
    }

    public WebElement getLblErrorRegister() {
        return Constant.DRIVER.findElement(_lblErrorRegister);
    }
    public WebElement getLblInvalidPassword() {
        return Constant.DRIVER.findElement(_lblInvalidPassword);
    }
    public WebElement getLblInvalidID() {
        return Constant.DRIVER.findElement(_lblInvalidID);
    }


    public String setErrorRegister() {
        return this.getLblErrorRegister().getText();
    }
    public String setInvalidPassword() {
        return this.getLblInvalidPassword().getText();
    }
    public String setInvalidID() {
        return this.getLblInvalidID().getText();
    }

    public void register(String email, String password, String confirmPassword, String pid) {
        this.getTxtEmail().sendKeys(email);
        this.getTxtPassword().sendKeys(password);
        this.getTxtConfirmPassword().sendKeys(password);
        this.getTxtPID().sendKeys(pid);
        this.getBtnRegister().click();
    }
}
