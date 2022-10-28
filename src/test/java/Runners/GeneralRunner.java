package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/Features"},
        glue = {"Steps"},
        dryRun = false
)
public class GeneralRunner extends AbstractTestNGCucumberTests{
}