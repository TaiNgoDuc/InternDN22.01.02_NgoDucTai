package Common;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverUtils {
    public static void init() {
        switch (Constant.BROWSER.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "Executables/Driver/chromedriver.exe");
                Constant.DRIVER = new ChromeDriver();
                Constant.DRIVER.manage().window().maximize();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver","Executables/Driver/msedgedriver.exe");
                Constant.DRIVER = new EdgeDriver();
                Constant.DRIVER.manage().window().maximize();
                break;

            case "firefox":
                System.setProperty("webdriver.gecko.driver","Executables/driver/geckodriver.exe");
                Constant.DRIVER = new FirefoxDriver();
                Constant.DRIVER.manage().window().maximize();
                break;
        }
    }

    public static void navigate(String URL) {
        Constant.DRIVER.get(URL);
    }

    public static void quitBrowser() {
        Constant.DRIVER.quit();
    }


}
