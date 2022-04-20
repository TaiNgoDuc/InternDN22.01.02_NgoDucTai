package Testcases;

import Common.Constant;
import Common.Log;
import PageObjects.*;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01 extends TestBase {


    @Test(dataProvider = "dataLogin")
    public void TC01(Object[] dataCsv) {

        HomePage homePage = new HomePage();
        QAPage qaPage = new QAPage();
        LoginPage loginPage = new LoginPage();
        RegisterPage registerPage = new RegisterPage();
        TicketPricePage ticketPricePage = new TicketPricePage();
        BookTicketPage bookTicketPage = new BookTicketPage();

        qaPage.moveToQAPage();

        Log.info("Go to QA page");

        qaPage.moveToLoginPage();

        loginPage.moveToRegisterPage();

        String email = GenerateData.generateRandomEmail(dataCsv[0].toString());
        String password = dataCsv[1].toString();
        String confirmPassword = dataCsv[2].toString();
        String pid = dataCsv[3].toString();

        registerPage.register(email, password, confirmPassword, pid);
        Log.info("Register account");

        homePage.moveToLoginPage();

        Log.info("Go to Login Page");

        JavascriptExecutor js = (JavascriptExecutor) Constant.DRIVER;
        js.executeScript("arguments[0].scrollIntoView()", loginPage.getBtnLogin());

        loginPage.login(email, password);

        Log.info("Login with created account");

        homePage.moveToTicketPricePage();

        JavascriptExecutor js1 = (JavascriptExecutor) Constant.DRIVER;
        js1.executeScript("arguments[0].scrollIntoView()", ticketPricePage.getLnkCheckPrice());

        ticketPricePage.checkPrice();

        JavascriptExecutor js2 = (JavascriptExecutor) Constant.DRIVER;
        js2.executeScript("arguments[0].scrollIntoView()", ticketPricePage.getLnkSoftBed());

        ticketPricePage.bookSoftBed();

        JavascriptExecutor js3 = (JavascriptExecutor) Constant.DRIVER;
        js3.executeScript("arguments[0].scrollIntoView()", bookTicketPage.getBtnBookTicket());

        bookTicketPage.clickBtnBookTicket();

        String actualMsg = bookTicketPage.setLblTicketPrice();
        String expectedMsg = "400000";

        Assert.assertEquals(actualMsg, expectedMsg);



    }
}
