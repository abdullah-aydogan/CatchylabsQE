package com.testinium.testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/testinium/features",
        glue = "com.testinium.stepDefinitions",
        monochrome = true,
        tags = "@moneyTransfer",
        plugin = {"html:reports/cucumberReports/moneyTransferTestReport.html"}
)
public class MoneyTransferTestRunner extends AbstractTestNGCucumberTests {


}