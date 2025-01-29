package com.testinium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String amountTxt;

    @FindBy(xpath = "//div[contains(text(), 'My account')]")
    WebElement myAccountText;

    @FindBy(xpath = "//div[contains(text(), 'Edit account')]")
    WebElement editAccountButton;

    @FindBy(xpath = "//*[contains(@class, 'r-yv33h5')][1]")
    WebElement accountNameTxt;

    @FindBy(tagName = "input")
    WebElement accountNameInput;

    @FindBy(xpath = "//div[contains(text(), 'UPDATE')]")
    WebElement updateButton;

    @FindBy(xpath = "//div[@tabindex='-1']")
    public WebElement disabledUpdateButton;

    @FindBy(xpath = "//div[contains(text(), 'Add money')]")
    WebElement addMoneyButton;

    @FindBy(xpath = "(//input)[1]")
    WebElement cardNumberField;

    @FindBy(xpath = "(//input)[2]")
    WebElement cardHolderField;

    @FindBy(xpath = "(//input)[3]")
    WebElement expiryDateField;

    @FindBy(xpath = "(//input)[4]")
    WebElement cvvField;

    @FindBy(xpath = "(//input)[5]")
    WebElement amountField;

    @FindBy(xpath = "//div[text()='Add']")
    WebElement addButton;

    @FindBy(xpath = "(//*[contains(@class, 'r-yv33h5')])[8]")
    WebElement transactionAmountTxt;

    @FindBy(xpath = "//*[contains(text(), 'amount must be')]")
    WebElement amountWarningText;

    @FindBy(xpath = "//*[contains(text(), 'Required')]")
    WebElement requiredTxt;

    @FindBy(xpath = "//*[contains(text(), 'Wrong date')]")
    WebElement wrongDateTxt;

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

    public void clickAddMoneyButton() {
        addMoneyButton.click();
    }

    public void sendCardNumberField(String cardNumber) {
        cardNumberField.sendKeys(cardNumber);
    }

    public void sendCardHolderField(String cardHolder) {
        cardHolderField.sendKeys(cardHolder);
    }

    public void sendExpiryDateField(String expiryDate) {
        expiryDateField.sendKeys(expiryDate);
    }

    public void sendCvvField(String cvv) {
        cvvField.sendKeys(cvv);
    }

    public void sendAmountField(String amount) {

        amountField.sendKeys(amount);
        amountTxt = amount;
    }

    public void clickAddButton() {
        addButton.click();
    }

    public void checkTransaction() {
        Assert.assertEquals(transactionAmountTxt.getText(), amountTxt);
    }

    public void checkAmountWarning() {
        Assert.assertTrue(amountWarningText.isDisplayed());
    }

    public void checkEmptyInput() {
        Assert.assertTrue(requiredTxt.isDisplayed());
    }

    public void clickCvvField() {
        cvvField.click();
    }

    public void expiryDateControl() {
        Assert.assertTrue(wrongDateTxt.isDisplayed());
    }
}