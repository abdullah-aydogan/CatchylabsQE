package com.testinium.stepDefinitions;

import com.testinium.pageObjects.ChallangePage;
import com.testinium.pageObjects.LoginPage;
import com.testinium.testComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;

public class LoginStepDefinition extends BaseTest {

    public LoginPage loginPage;
    public ChallangePage challangePage;

    @Given("Catchylabs giris ekranina gidilir.")
    public void goToLoginPage() throws IOException {
        loginPage = launchApplication();
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