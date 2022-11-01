package Pages;

import Base.BaseTest;
import Base.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public class BasketPage extends BaseTest {

    WebDriver driver;

    public BasketPage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);

    }


    @FindBy(id = "basket-item-count")
    private WebElement productCount;

    @FindBy(css = "a[class=\"product_delete_1zR-0\"]")
    private WebElement deleteProduct;

    public void verifyProducts(){
        String expectedProductCount = "2";
        Assert.assertEquals(productCount.getText(),expectedProductCount,"You don't have two products on your basket");

        try {
            Thread.sleep(1000);
            click(deleteProduct);
            Thread.sleep(1000);
            click(deleteProduct);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
