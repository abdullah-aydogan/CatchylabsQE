package com.testinium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChallangePage extends BasePage {

    WebDriver driver;

    public ChallangePage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),'Open Money Transfer')]")
    public WebElement openMoneyTransferBtn;

    public HomePage clickOpenMoneyTransferBtn() {

        openMoneyTransferBtn.click();

        HomePage homePage = new HomePage(driver);
        return homePage;
    }
}