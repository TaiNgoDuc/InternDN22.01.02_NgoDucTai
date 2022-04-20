package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {

    private By lnkTimetableTab = By.xpath("//a[@href='TrainTimeListPage.cshtml']");
    private By lnkTicketPriceTab = By.xpath("//a[@href='/Page/TrainPriceListPage.cshtml']");
    private By lnkBookingTicketTab = By.xpath("//a[@href='/Page/BookTicketPage.cshtml']");
    private By lnkRegisterTab = By.xpath("//a[@href='/Account/Register.cshtml']");
    private By lnkQATab = By.xpath("//a[@href='/Page/FAQ.cshtml']");
    private By lnkMyTicketTab = By.xpath("//a[@href='/Page/ManageTicket.cshtml']");

    private final By tabLogin = By.xpath("//a[@href='/Account/Login.cshtml']");

    public WebElement getLnkTicketPriceTab() {
        return Constant.DRIVER.findElement(lnkTicketPriceTab);
    }
    public WebElement getLnkBookingTicketTab() { return Constant.DRIVER.findElement(lnkBookingTicketTab); }
    public WebElement getLnkRegisterTab() { return Constant.DRIVER.findElement(lnkRegisterTab); }
    public WebElement getLnkQATab() { return Constant.DRIVER.findElement(lnkQATab); }
    public WebElement getLnkMyTicketTab() { return Constant.DRIVER.findElement(lnkMyTicketTab); }

    public WebElement getTabLogin() { return Constant.DRIVER.findElement(tabLogin); }


    public void moveToLoginPage() { getTabLogin().click();}
    public void moveToQAPage() { getLnkQATab().click();}
    public void moveToRegisterPage() { getLnkRegisterTab().click();}
    public void moveToTicketPricePage() { getLnkTicketPriceTab().click();}
    public void moveToBookTicketTab() { getLnkBookingTicketTab().click();}
    public void moveToMyTicketTab() { getLnkMyTicketTab().click();}
}
