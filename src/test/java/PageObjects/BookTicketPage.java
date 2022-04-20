package PageObjects;

import Common.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BookTicketPage extends BasePage {

    private final By _departDate = By.xpath("//select[@name='Date']");
    private final By _departFrom = By.xpath("//select[@name='DepartStation']");
    private final By _arriveAt = By.xpath("//select[@name='ArriveStation']");
    private final By _seatType = By.xpath("//select[@name='SeatType']");
    private final By _ticketAmount = By.xpath("//select[@name='TicketAmount']");
    private final By _btnBookTicket = By.xpath("//input[@value='Book ticket']");
    private final By _lblticketPrice = By.xpath("//td[contains(text(), '400000')]");
    private final By _lblBookSuccessfully = By.xpath("//*[@id='content']/h1[contains(text(), 'Ticket booked successfully!')]");

    public WebElement getDepartDate() { return Constant.DRIVER.findElement(_departDate); }
    public WebElement getDepartFrom() { return Constant.DRIVER.findElement(_departFrom); }
    public WebElement getArriveAt() { return Constant.DRIVER.findElement(_arriveAt); }
    public WebElement getSeatType() { return Constant.DRIVER.findElement(_seatType); }
    public WebElement getTicketAmount() { return Constant.DRIVER.findElement(_ticketAmount); }
    public WebElement getBtnBookTicket() { return Constant.DRIVER.findElement(_btnBookTicket); }
    public WebElement getTicketPrice() { return Constant.DRIVER.findElement(_lblticketPrice); }
    public WebElement getLblBookSuccessfully() { return Constant.DRIVER.findElement(_lblBookSuccessfully); }

    public void clickBtnBookTicket() { this.getBtnBookTicket().click(); }
    public String setLblTicketPrice() { return this.getTicketPrice().getText(); }
    public String setLblBookSuccessfully() { return this.getLblBookSuccessfully().getText(); }

    public BookTicketPage bookTicket(String date, String departFrom, String arriveAt, String seatType, String ticketAmount) {
        this.getDepartDate().sendKeys(date);
        this.getDepartFrom().sendKeys(departFrom);
        this.getArriveAt().sendKeys(arriveAt);
        this.getSeatType().sendKeys(seatType);
        this.getTicketAmount().sendKeys(ticketAmount);

        this.getBtnBookTicket().click();

        return new BookTicketPage();
    }
}
