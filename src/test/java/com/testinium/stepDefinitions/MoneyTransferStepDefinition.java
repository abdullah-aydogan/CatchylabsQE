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

public class MoneyTransferStepDefinition extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(MoneyTransferStepDefinition.class);

    WebDriver driver = Hooks.driver;
    public LoginPage loginPage;
    public ChallangePage challangePage;
    public HomePage homePage;

    String amount;

    @Given("Catchylabs hesabina girilir")
    public void loginCatchylabs() throws IOException {

        loginPage = new LoginPage(driver);

        loginPage.goTo();
        loginPage.sendTextUsernameField("abdullah.aydogan");
        loginPage.sendTextPasswordField("@bdullahOtok@r05");

        challangePage = loginPage.clickLoginButton();
        logger.info("Catchylabs hesabina giris yapildi.");
    }

    @Given("Open Money Transfer butonuna tiklanir")
    public void clickOpenMoneyTransfer() {
        homePage = challangePage.clickOpenMoneyTransferBtn();
        logger.info("Open Money Transfer butonuna tiklandi.");
    }

    @When("Transfer Money butonuna tiklanir")
    public void clickTransferMoney() {
        homePage.clickTransferMoneyButton();
        logger.info("Transfer Money butonuna tiklandi.");
    }

    @When("^Amount alanina (.+) degeri girilir$")
    public void sendAmount(String amount) {
        homePage.sendAmountTransferInput(amount);
        logger.info("Amount alanina " + amount + " degeri girildi.");
    }

    @When("Send butonuna tiklanir")
    public void clickSendBtn() {
        homePage.clickSendButton();
        logger.info("Send butonuna tiklandi.");
    }

    @Then("Para transferi isleminin tamamlandigini kontrol et")
    public void checkMoneyTransfer() {
        homePage.checkTransferTransaction();
        logger.info("Para transferi isleminin tamamlandigi kontrol ediliyor...");
    }

    @When("Amount alani bos birakilir")
    public void sendEmptyAmount() {
        homePage.sendEmptyAmount();
        logger.info("Amount alani bos birakildi.");
    }

    @Then("Send butonunun tiklanamadigi kontrol edilir")
    public void checkInactiveBtn() {
        homePage.checkDisableSendButton();
        logger.info("Send butonunun tiklanamadigi kontrol ediliyor...");
    }

    @Then("Para transferi isleminin yapilamadigini kontrol et")
    public void checkFailMoneyTransfer() {
        homePage.checkInternalErrorMessage();
        logger.info("Para transferi isleminin yapilamadigi kontrol ediliyor...");
    }

    @When("Bakiye bilgisi alinir")
    public void getAmount() {
        amount = homePage.getAmountText();
        logger.info("Bakiye bilgisi alindi.");
    }

    @When("Amount alanina bakiyeden fazla deger girilir")
    public void tooMuchAmount() {
        homePage.sendTooMuchAmount(amount);
        logger.info("Amount alanina bakiyeden fazla deger girildi.");
    }

    @When("^Receiver account alaninda (.+) secilir$")
    public void selectReceiverAccount(String accountName) {
        homePage.selectReceiverAccount(accountName);
        logger.info("Receiver account alaninda " + accountName + " secildi.");
    }
}