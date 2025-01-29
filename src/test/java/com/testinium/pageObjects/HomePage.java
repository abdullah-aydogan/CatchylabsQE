package com.testinium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class HomePage extends BasePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String amountTxt;
    String amountTransferTxt;

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

    @FindBy(xpath = "//div[contains(text(), 'Transfer money')]")
    WebElement transferMoneyButton;

    @FindBy(xpath = "//input[@autocapitalize='sentences']")
    WebElement amountTransferInput;

    @FindBy(xpath = "//div[@tabindex='-1' and @aria-disabled='true']")
    WebElement disableSendButton;

    @FindBy(xpath = "(//div[@tabindex='0' and @style='transition-duration: 0s;'])[5]")
    WebElement sendButton;

    @FindBy(xpath = "(//select)[2]")
    WebElement receiverAccountSelect;

    @FindBy(xpath = "(//*[contains(@class, 'r-yv33h5')])[4]")
    WebElement amountText;

    @FindBy(xpath = "//div[contains(text(), 'Internal Error')]")
    WebElement internalErrorMessage;

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

    public void clickTransferMoneyButton() {
        transferMoneyButton.click();
    }

    public void sendAmountTransferInput(String amount) {

        amountTransferInput.sendKeys(amount);
        amountTransferTxt = amount;
    }

    public void checkDisableSendButton() {
        Assert.assertTrue(disableSendButton.isDisplayed());
    }

    public void selectReceiverAccount(String accountName) {

        Select select = new Select(receiverAccountSelect);
        select.selectByVisibleText(accountName);
    }

    public String getAmountText() {
        return amountText.getText();
    }

    public void clickSendButton() {
        sendButton.click();
    }

    public void checkTransferTransaction() {
        Assert.assertEquals(transactionAmountTxt.getText(), amountTransferTxt);
    }

    public void sendEmptyAmount() {
        amountTransferInput.sendKeys("");
    }

    public void checkInternalErrorMessage() {
        Assert.assertTrue(internalErrorMessage.isDisplayed());
    }

    public void sendTooMuchAmount(String amount) {
        amountTransferInput.sendKeys(amount + "0");
    }
}