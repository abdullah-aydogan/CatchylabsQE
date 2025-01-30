package com.testinium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginPage extends BasePage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {

        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@placeholder='Username']")
    WebElement usernameField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;

    @FindBy(xpath = "//div[@tabindex='0']")
    WebElement loginButton;

    @FindBy(className = "r-howw7u")
    WebElement errorMessage;

    public void sendTextUsernameField(String username) {
        usernameField.sendKeys(username);
    }

    public void sendTextPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public ChallangePage clickLoginButton() {

        loginButton.click();

        ChallangePage challangePage = new ChallangePage(driver);
        return challangePage;
    }

    public String getErrorMessage() {

        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }

    public void goTo() throws IOException {

        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "/src/test/resources/globalData.properties");

        prop.load(fis);

        String url = prop.getProperty("url");
        driver.get(url);
    }
}