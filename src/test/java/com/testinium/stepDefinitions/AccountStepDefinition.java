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
import org.testng.Assert;

public class AccountStepDefinition extends BaseTest {

    WebDriver driver = Hooks.driver;
    public LoginPage loginPage;
    public ChallangePage challangePage;
    public HomePage homePage;

    @Given("Catchylabs hesabina giris yapilir.")
    public void loginCatchylabs() {

        loginPage = new LoginPage(driver);

        loginPage.goTo();
        loginPage.sendTextUsernameField("abdullah.aydogan");
        loginPage.sendTextPasswordField("@bdullahOtok@r05");

        challangePage = loginPage.clickLoginButton();
    }

    @When("Basarili giris sonrasi Open Money Transfer butonuna tiklanir.")
    public void clickOpenMoneyTransfer() {
        homePage = challangePage.clickOpenMoneyTransferBtn();
    }

    @Then("My Account yazisi gorulur.")
    public void checkMyAccountText() {
        Assert.assertEquals(homePage.checkMyAccountTxt(), "My account");
    }

    @When("Edit Account butonuna tiklanir.")
    public void clickEditAccount() {
        homePage.editAccountBtnClick();
    }

    @When("^Account name alanina (.+) yazilir.$")
    public void sendAccountName(String name) {
        homePage.sendAccountName(name);
    }

    @When("Update butonuna tiklanir.")
    public void clickUpdate() {
        homePage.clickUpdateButton();
    }

    @Then("^Account adinin (.+) oldugu kontrol edilir.$")
    public void checkAccountName(String accountName) {
        Assert.assertEquals(homePage.getAccountName(), accountName);
    }

    @When("Account name alani bos birakilir.")
    public void sendEmptyText() {
        homePage.sendEmptyAccountName();
    }

    @Then("Update butonunun pasif oldugu kontrol edilir.")
    public void checkInactiveUpdate() {
        Assert.assertTrue(homePage.disabledUpdateButton.isDisplayed());
    }
}