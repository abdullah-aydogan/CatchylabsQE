package com.testinium.testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/testinium/features",
        glue = "com.testinium.stepDefinitions",
        monochrome = true,
        tags = "@login",
        plugin = {"html:target/cucumber.html"}
)
public class LoginTestRunner extends AbstractTestNGCucumberTests {


}