package PageObjects;


import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TicketPricePage extends BasePage {


    private By lnkCheckPrice = By.xpath("//li[text()='Huế to Nha Trang']/following::a[text() = 'Check Price']");
    private By lnkSoftBed = By.xpath("//td[contains(text(), 'SB')]/following-sibling::td[text() = 'Soft bed']/..//a[contains(text(), 'Book')]");


    public WebElement getLnkCheckPrice() {
        return Constant.DRIVER.findElement(lnkCheckPrice);
    }
    public WebElement getLnkSoftBed() { return Constant.DRIVER.findElement(lnkSoftBed); }

    public void checkPrice() { getLnkCheckPrice().click();}
    public void bookSoftBed() { getLnkSoftBed().click();}

}
