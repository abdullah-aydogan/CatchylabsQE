package com.testinium.testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/testinium/features",
        glue = {"com.testinium.stepDefinitions",
                "com.testinium.testComponents"
        },
        monochrome = true,
        tags = "@login",
        plugin = {"html:reports/cucumberReports/loginTestReport.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class LoginTestRunner extends AbstractTestNGCucumberTests {


}