package com.testinium.stepDefinitions;

import com.testinium.pageObjects.ChallangePage;
import com.testinium.pageObjects.HomePage;
import com.testinium.pageObjects.LoginPage;
import com.testinium.testComponents.BaseTest;
import com.testinium.testComponents.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class AddMoneyStepDefinition extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(AddMoneyStepDefinition.class);

    WebDriver driver = Hooks.driver;
    public LoginPage loginPage;
    public ChallangePage challangePage;
    public HomePage homePage;

    @Given("Catchylabs hesabina giris yap.")
    public void loginCatchylabs() throws IOException {

        loginPage = new LoginPage(driver);

        loginPage.goTo();
        loginPage.sendTextUsernameField("abdullah.aydogan");
        loginPage.sendTextPasswordField("@bdullahOtok@r05");

        challangePage = loginPage.clickLoginButton();
        logger.info("Catchylabs hesabina giris yapildi.");
    }

    @Given("Basarili giris sonrasi Open Money Transfer butonuna tiklanir")
    public void clickOpenMoneyTransfer() {
        homePage = challangePage.clickOpenMoneyTransferBtn();
        logger.info("Open Money Transfer butonuna tiklandi.");
    }

    @When("Add Money butonuna tiklanir.")
    public void clickAddMoney() {
        homePage.clickAddMoneyButton();
        logger.info("Add Money butonuna tiklandi.");
    }

    @When("^Card number alanina (.+) degeri girilir.$")
    public void sendCardNumber(String cardNumber) {
        homePage.sendCardNumberField(cardNumber);
        logger.info("Card number alanina " + cardNumber + " degeri girildi.");
    }

    @When("^Card holder alanina (.+) degeri girilir.$")
    public void sendCardHolder(String cardHolder) {
        homePage.sendCardHolderField(cardHolder);
        logger.info("Card holder alanina " + cardHolder + " degeri girildi.");
    }

    @When("^Expiry date alanina (.+) degeri girilir.$")
    public void sendExpiryDate(String expiryDate) {
        homePage.sendExpiryDateField(expiryDate);
        logger.info("Expiry date alanina " + expiryDate + " degeri girildi.");
    }

    @When("^CVV alanina (.+) degeri girilir.$")
    public void sendCvv(String cvv) {
        homePage.sendCvvField(cvv);
        logger.info("CVV alanina " + cvv + " degeri girildi.");
    }

    @When("^Amount alanina (.+) degeri girilir.$")
    public void sendAmount(String amount) {
        homePage.sendAmountField(amount);
        logger.info("Amount alanina " + amount + " degeri girildi.");
    }

    @When("Add butonuna tiklanir.")
    public void clickAdd() {
        homePage.clickAddButton();
        logger.info("Add butonuna tiklandi.");
    }

    @Then("Para yatirma isleminin tamamlandigini kontrol et.")
    public void checkAddMoneyTransaction() {
        homePage.checkTransaction();
        logger.info("Para yatirma isleminin tamamlandigi kontrol ediliyor...");
    }

    @Then("Eksi tutar girildigine dair uyari mesajinin alindigini kontrol et.")
    public void checkMinusAddMoney() {
        homePage.checkAmountWarning();
        logger.info("Eksi tutar girildigine dair mesaj var mı kontrol ediliyor...");
    }

    @Then("Tutar girilmedigine dair uyari mesajinin alindigini kontrol et.")
    public void checkSendEmptyValue() {
        homePage.checkEmptyInput();
        logger.info("Tutar girilmedigine dair mesaj var mı kontrol ediliyor...");
    }

    @When("CVV alanina tiklanir.")
    public void clickCvv() {
        homePage.clickCvvField();
        logger.info("CVV alanina tiklandi.");
    }

    @Then("Wrong date uyarisi alinir.")
    public void checkWrongDateWarning() {
        homePage.expiryDateControl();
        logger.info("Wrong date uyarisi alindigi kontrol ediliyor...");
    }
}