package com.testinium.testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/testinium/features",
        glue = "com.testinium.stepDefinitions",
        monochrome = true,
        tags = "@addMoney",
        plugin = {"html:reports/cucumberReports/addMoneyTestReport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class AddMoneyTestRunner extends AbstractTestNGCucumberTests {


}