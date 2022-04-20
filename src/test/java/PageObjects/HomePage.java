package PageObjects;

import Common.Constant;

public class HomePage extends BasePage {

    public HomePage open() {
        Constant.DRIVER.navigate().to(Constant.HOME_PAGE_URL);
        return this;
    }
}
