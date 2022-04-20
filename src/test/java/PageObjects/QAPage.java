package PageObjects;

import Common.Constant;

public class QAPage extends BasePage {

    public QAPage open() {
        Constant.DRIVER.navigate().to(Constant.QA_PAGE_URL);
        return this;
    }
}
