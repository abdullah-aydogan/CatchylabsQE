package com.testinium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(), 'My account')]")
    WebElement myAccountText;

    @FindBy(xpath = "//div[contains(text(), 'Edit account')]")
    WebElement editAccountButton;

    @FindBy(xpath = "//*[contains(@class, 'r-yv33h5')][1]")
    WebElement accountNameTxt;

    @FindBy(tagName = "input")
    WebElement accountNameInput;

    @FindBy(xpath = "//div[contains(text(), 'UPDATE')]")
    public WebElement updateButton;

    public String checkMyAccountTxt() {
        return myAccountText.getText();
    }

    public void clickUpdateButton() {
        updateButton.click();
    }

    public void editAccountBtnClick() {
        editAccountButton.click();
    }

    public String getAccountName() {
        return accountNameTxt.getText();
    }

    public void sendAccountName(String accountName) {

        accountNameInput.clear();
        accountNameInput.sendKeys(accountName);
    }

    public void sendEmptyAccountName() {
        accountNameInput.clear();
    }
}