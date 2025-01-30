package com.testinium.testComponents;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.testinium.pageObjects.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {

    public static WebDriver driver;
    public LoginPage loginPage;
    BaseTest baseTest = new BaseTest();

    @Before
    public void setup() throws IOException {

        driver = baseTest.initializeDriver();
        loginPage = new LoginPage(driver);
        loginPage.goTo();
    }

    @AfterStep
    public void takeScreenshotOnFailure(Scenario scenario) throws IOException {

        if(scenario.isFailed()) {

            baseTest.takeScreenshot(scenario.getName().substring(0, 5), driver);

            String screenshotPath = System.getProperty("user.dir") +
                    "/target/screenshots/" + scenario.getName().substring(0, 5);

            ExtentCucumberAdapter.addTestStepScreenCaptureFromPath(screenshotPath);

            scenario.attach(BaseTest.takeScreenshotCucumberReport(driver), "image/png",
                    "screenshot");
        }
    }

    @After
    public void tearDown() {
        if(driver != null) {
            driver.quit();
        }
    }
}