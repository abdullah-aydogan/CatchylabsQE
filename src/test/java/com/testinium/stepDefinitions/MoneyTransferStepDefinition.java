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

public class MoneyTransferStepDefinition extends BaseTest {

    WebDriver driver = Hooks.driver;
    public LoginPage loginPage;
    public ChallangePage challangePage;
    public HomePage homePage;

    String amount;

    @Given("Catchylabs hesabina girilir")
    public void loginCatchylabs() {

        loginPage = new LoginPage(driver);

        loginPage.goTo();
        loginPage.sendTextUsernameField("abdullah.aydogan");
        loginPage.sendTextPasswordField("@bdullahOtok@r05");

        challangePage = loginPage.clickLoginButton();
    }

    @Given("Open Money Transfer butonuna tiklanir")
    public void clickOpenMoneyTransfer() {
        homePage = challangePage.clickOpenMoneyTransferBtn();
    }

    @When("Transfer Money butonuna tiklanir")
    public void clickTransferMoney() {
        homePage.clickTransferMoneyButton();
    }

    @When("^Amount alanina (.+) degeri girilir$")
    public void sendAmount(String amount) {
        homePage.sendAmountTransferInput(amount);
    }

    @When("Send butonuna tiklanir")
    public void clickSendBtn() {
        homePage.clickSendButton();
    }

    @Then("Para transferi isleminin tamamlandigini kontrol et")
    public void checkMoneyTransfer() {
        homePage.checkTransferTransaction();
    }

    @When("Amount alani bos birakilir")
    public void sendEmptyAmount() {
        homePage.sendEmptyAmount();
    }

    @Then("Send butonunun tiklanamadigi kontrol edilir")
    public void checkInactiveBtn() {
        homePage.checkDisableSendButton();
    }

    @Then("Para transferi isleminin yapilamadigini kontrol et")
    public void checkFailMoneyTransfer() {
        homePage.checkInternalErrorMessage();
    }

    @When("Bakiye bilgisi alinir")
    public void getAmount() {
        amount = homePage.getAmountText();
    }

    @When("Amount alanina bakiyeden fazla deger girilir")
    public void tooMuchAmount() {
        homePage.sendTooMuchAmount(amount);
    }

    @When("^Receiver account alaninda (.+) secilir$")
    public void selectReceiverAccount(String accountName) {
        homePage.selectReceiverAccount(accountName);
    }
}