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

import java.io.IOException;

public class AddMoneyStepDefinition extends BaseTest {

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
    }

    @Given("Basarili giris sonrasi Open Money Transfer butonuna tiklanir")
    public void clickOpenMoneyTransfer() {
        homePage = challangePage.clickOpenMoneyTransferBtn();
    }

    @When("Add Money butonuna tiklanir.")
    public void clickAddMoney() {
        homePage.clickAddMoneyButton();
    }

    @When("^Card number alanina (.+) degeri girilir.$")
    public void sendCardNumber(String cardNumber) {
        homePage.sendCardNumberField(cardNumber);
    }

    @When("^Card holder alanina (.+) degeri girilir.$")
    public void sendCardHolder(String cardHolder) {
        homePage.sendCardHolderField(cardHolder);
    }

    @When("^Expiry date alanina (.+) degeri girilir.$")
    public void sendExpiryDate(String expiryDate) {
        homePage.sendExpiryDateField(expiryDate);
    }

    @When("^CVV alanina (.+) degeri girilir.$")
    public void sendCvv(String cvv) {
        homePage.sendCvvField(cvv);
    }

    @When("^Amount alanina (.+) degeri girilir.$")
    public void sendAmount(String amount) {
        homePage.sendAmountField(amount);
    }

    @When("Add butonuna tiklanir.")
    public void clickAdd() {
        homePage.clickAddButton();
    }

    @Then("Para yatirma isleminin tamamlandigini kontrol et.")
    public void checkAddMoneyTransaction() {
        homePage.checkTransaction();
    }

    @Then("Eksi tutar girildigine dair uyari mesajinin alindigini kontrol et.")
    public void checkMinusAddMoney() {
        homePage.checkAmountWarning();
    }

    @Then("Tutar girilmedigine dair uyari mesajinin alindigini kontrol et.")
    public void checkSendEmptyValue() {
        homePage.checkEmptyInput();
    }

    @When("CVV alanina tiklanir.")
    public void clickCvv() {
        homePage.clickCvvField();
    }

    @Then("Wrong date uyarisi alinir.")
    public void checkWrongDateWarning() {
        homePage.expiryDateControl();
    }
}