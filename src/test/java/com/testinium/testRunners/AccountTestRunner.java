package com.testinium.testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/testinium/features",
        glue = "com.testinium.stepDefinitions",
        monochrome = true,
        tags = "@account",
        plugin = {"html:target/cucumber.html"}
)
public class AccountTestRunner extends AbstractTestNGCucumberTests {


}