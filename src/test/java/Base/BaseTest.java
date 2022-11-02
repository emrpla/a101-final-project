package Base;

import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
@ExtendWith(TestResultLogger.class)
public class BaseTest {

    private WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public void click(WebElement clickELement){
        wait.until(ExpectedConditions.elementToBeClickable(clickELement)).click();

    }

    public void sendKeys(WebElement element,String text){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);

    }

    public void selectElementFromDropdown (WebElement dropdown,String element){
        Select slc = new Select(dropdown);
        slc.selectByVisibleText(element);

    }


    public void Assertion(WebElement actual,String expected){

        wait.until(ExpectedConditions.visibilityOf(actual));
        Assert.assertEquals(actual.getText(),expected);

        System.out.println("My message : "+actual.getText());
    }
}
