package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class MyTicketPage extends BasePage {

    private final By _lblArriveStation = By.xpath("//select[@name = 'FilterArStation']");
    private final By _lblDepartDate = By.xpath("//input[@name = 'FilterDpDate']");
    private final By _btnSubmitFilter = By.xpath("//input[@type= 'submit']");
    private final By _lblArriveStationFilter = By.xpath("//*[@id=\"content\"]/form/div[2]/div/table/tbody/tr[2]/td[3]");

    public WebElement getLblArriveStation() { return Constant.DRIVER.findElement(_lblArriveStation);}
    public WebElement getLblDepartDate() { return Constant.DRIVER.findElement(_lblDepartDate); }
    public WebElement getBtnSubmitFilter() { return Constant.DRIVER.findElement(_btnSubmitFilter); }
    public WebElement getLblArriveStationFilter() { return Constant.DRIVER.findElement(_lblArriveStationFilter);}

    public MyTicketPage checkFilterTicket(String arriveStation, String date) {
        this.getLblArriveStation().sendKeys(arriveStation);
        this.getLblDepartDate().sendKeys(date);
        this.getBtnSubmitFilter().click();

        return new MyTicketPage();
    }

    public String setLblArriveStationFilter() { return this.getLblArriveStationFilter().getText(); }
}
