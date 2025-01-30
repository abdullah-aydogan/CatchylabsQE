package com.testinium.stepDefinitions;

import com.testinium.pageObjects.ChallangePage;
import com.testinium.pageObjects.LoginPage;
import com.testinium.testComponents.BaseTest;
import com.testinium.testComponents.Hooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class LoginStepDefinition extends BaseTest {

    WebDriver driver = Hooks.driver;
    public LoginPage loginPage;
    public ChallangePage challangePage;

    @Given("Catchylabs giris ekranina gidilir.")
    public void goToLoginPage() throws IOException {

        loginPage = new LoginPage(driver);
        loginPage.goTo();
    }

    @Given("^Username alanina (.+) yazilir.$")
    public void sendUsername(String username) {
        loginPage.sendTextUsernameField(username);
    }

    @Given("^Password alanina (.+) yazilir.$")
    public void sendPassword(String password) {
        loginPage.sendTextPasswordField(password);
    }

    @When("Login butonuna tıklanir.")
    public void clickLoginBtn() {
        challangePage = loginPage.clickLoginButton();
    }

    @Then("Giris isleminin basarili oldugu kontrol edilir.")
    public void checkSuccessLogin() {
        challangePage.waitForWebElementToAppear(challangePage.openMoneyTransferBtn);
    }

    @Then("Giris isleminin basarisiz oldugu kontrol edilir.")
    public void checkFailLogin() {
        Assert.assertEquals(loginPage.getErrorMessage(), "Username or Password Invalid!");
    }
}