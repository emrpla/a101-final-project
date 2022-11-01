package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/Features/AddProductToBasketWithUser.feature","src/test/java/Features/AddProductToBasketWithAnonymousUser.feature"},
        glue = {"Steps"},
        dryRun = false
)
public class GeneralRunner extends AbstractTestNGCucumberTests{
}
