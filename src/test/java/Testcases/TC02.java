package Testcases;

import Common.Constant;
import Common.Log;
import PageObjects.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02 extends TestBase {

    HomePage homePage = new HomePage();
    BookTicketPage bookTicketPage = new BookTicketPage();
    RegisterPage registerPage = new RegisterPage();
    LoginPage loginPage = new LoginPage();
    MyTicketPage myTicketPage = new MyTicketPage();

    @Test(dataProvider = "dataLogin")
    public void TC01(Object[] dataCsv) throws InterruptedException {

        homePage.moveToRegisterPage();

        Log.info("Go to Register page");

        String email = GenerateData.generateRandomEmail(dataCsv[0].toString());
        String password = dataCsv[1].toString();
        String confirmPassword = dataCsv[2].toString();
        String pid = dataCsv[3].toString();

        registerPage.register(email, password, confirmPassword, pid);
        Log.info("Register account");

        homePage.moveToLoginPage();

        Log.info("Go to Login page");

        JavascriptExecutor js = (JavascriptExecutor) Constant.DRIVER;
        js.executeScript("arguments[0].scrollIntoView()", loginPage.getBtnLogin());

        loginPage.login(email, password);

        Log.info("Login with created account");

        homePage.moveToBookTicketTab();

        Log.info("Go to Book ticket page");

        String departDate = dataCsv[4].toString();
        String departDate1 = dataCsv[9].toString();
        String departDate2 = dataCsv[10].toString();
        String departDate3 = dataCsv[11].toString();
        String departDate4 = dataCsv[12].toString();
        String departDate5 = dataCsv[13].toString();
        String departDate6 = dataCsv[14].toString();
        String departFrom = dataCsv[5].toString();
        String arriveAt = dataCsv[6].toString();
        String seatType = dataCsv[7].toString();
        String ticketAmount = dataCsv[8].toString();
//        String date = dataCsv[15].toString();

        Thread.sleep(2);
        JavascriptExecutor js1 = (JavascriptExecutor) Constant.DRIVER;
        js1.executeScript("arguments[0].scrollIntoView()", bookTicketPage.getBtnBookTicket());

        bookTicketPage.bookTicket(departDate, departFrom, arriveAt, seatType, ticketAmount);

        String actualMsg = bookTicketPage.setLblBookSuccessfully();
        String expectedMsg = "Ticket booked successfully!";

        Assert.assertEquals(actualMsg, expectedMsg);

        Log.info("Book a ticket with information of csv data");

        bookTicketPage.moveToBookTicketTab();

        Constant.DRIVER.navigate().refresh();

        bookTicketPage.bookTicket(departDate1, departFrom, arriveAt, seatType, ticketAmount);

        Log.info("Book a ticket with information of csv data");

        Assert.assertEquals(actualMsg, expectedMsg);

        bookTicketPage.moveToBookTicketTab();

        Constant.DRIVER.navigate().refresh();

        bookTicketPage.bookTicket(departDate2, departFrom, arriveAt, seatType, ticketAmount);

        Log.info("Book a ticket with information of csv data");

        Assert.assertEquals(actualMsg, expectedMsg);

        bookTicketPage.moveToBookTicketTab();

        Constant.DRIVER.navigate().refresh();

        bookTicketPage.bookTicket(departDate3, departFrom, arriveAt, seatType, ticketAmount);

        Log.info("Book a ticket with information of csv data");

        Assert.assertEquals(actualMsg, expectedMsg);

        bookTicketPage.moveToBookTicketTab();

        Constant.DRIVER.navigate().refresh();

        bookTicketPage.bookTicket(departDate4, departFrom, arriveAt, seatType, ticketAmount);

        Log.info("Book a ticket with information of csv data");

        Assert.assertEquals(actualMsg, expectedMsg);

        bookTicketPage.moveToBookTicketTab();

        Constant.DRIVER.navigate().refresh();

        bookTicketPage.bookTicket(departDate5, departFrom, arriveAt, seatType, ticketAmount);

        Log.info("Book a ticket with information of csv data");

        Assert.assertEquals(actualMsg, expectedMsg);

        bookTicketPage.moveToBookTicketTab();

        Constant.DRIVER.navigate().refresh();

        bookTicketPage.bookTicket(departDate6, departFrom, arriveAt, seatType, ticketAmount);

        Log.info("Book a ticket with information of csv data");

        Assert.assertEquals(actualMsg, expectedMsg);

        bookTicketPage.moveToMyTicketTab();

        myTicketPage.checkFilterTicket(arriveAt, departDate);

        String actualArriveStation = myTicketPage.setLblArriveStationFilter();
        String expectedArriveStation = arriveAt;

        Assert.assertEquals(actualArriveStation, expectedArriveStation);
    }
}
