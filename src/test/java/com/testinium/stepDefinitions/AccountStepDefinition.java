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
import org.testng.Assert;

import java.io.IOException;

public class AccountStepDefinition extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(AccountStepDefinition.class);

    WebDriver driver = Hooks.driver;
    public LoginPage loginPage;
    public ChallangePage challangePage;
    public HomePage homePage;

    @Given("Catchylabs hesabina giris yapilir.")
    public void loginCatchylabs() throws IOException {

        loginPage = new LoginPage(driver);

        loginPage.goTo();
        loginPage.sendTextUsernameField("abdullah.aydogan");
        loginPage.sendTextPasswordField("@bdullahOtok@r05");

        challangePage = loginPage.clickLoginButton();
        logger.info("Catchylabs hesabina giris yapildi.");
    }

    @When("Basarili giris sonrasi Open Money Transfer butonuna tiklanir.")
    public void clickOpenMoneyTransfer() {
        homePage = challangePage.clickOpenMoneyTransferBtn();
        logger.info("Open Money Transfer butonuna tiklandi.");
    }

    @Then("My Account yazisi gorulur.")
    public void checkMyAccountText() {
        Assert.assertEquals(homePage.checkMyAccountTxt(), "My account");
        logger.info("My Account yazisi kontrol ediliyor...");
    }

    @When("Edit Account butonuna tiklanir.")
    public void clickEditAccount() {
        homePage.editAccountBtnClick();
        logger.info("Edit Account butonuna tiklandi.");
    }

    @When("^Account name alanina (.+) yazilir.$")
    public void sendAccountName(String name) {
        homePage.sendAccountName(name);
        logger.info("Account name alanina " + name + " yazildi.");
    }

    @When("Update butonuna tiklanir.")
    public void clickUpdate() {
        homePage.clickUpdateButton();
        logger.info("Update butonuna tiklandi.");
    }

    @Then("^Account adinin (.+) oldugu kontrol edilir.$")
    public void checkAccountName(String accountName) {
        Assert.assertEquals(homePage.getAccountName(), accountName);
        logger.info("Account adinin " + accountName + " oldugu kontrol ediliyor...");
    }

    @When("Account name alani bos birakilir.")
    public void sendEmptyText() {
        homePage.sendEmptyAccountName();
        logger.info("Account name alani bos birakildi.");
    }

    @Then("Update butonunun pasif oldugu kontrol edilir.")
    public void checkInactiveUpdate() {
        Assert.assertTrue(homePage.disabledUpdateButton.isDisplayed());
        logger.info("Update butonunun pasif oldugu kontrol ediliyor...");
    }
}