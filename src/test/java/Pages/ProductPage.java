package Pages;

import Base.BaseTest;
import Base.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BaseTest {
    WebDriver driver;

    public ProductPage()
    {
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//*[@id=\"i0\"]/div")
    private WebElement pencilProduct;
    @FindBy(id = "addToCart")
    private WebElement addToCartMainSeller;
    //@FindBy(xpath = "/html/body/div[7]/div/div/div/div/div/div/h1/a")
    @FindBy(css = "a[class=\"checkoutui-Modal-2iZXl\"]")
    private WebElement cancelButton;

    @FindBy(xpath = "/html/body/div[2]/main/div[3]/section[1]/div[3]/div/div[4]/div[2]/div[3]/div/div[2]/table/tbody/tr[1]/td[3]/div/form/button")
    private WebElement addToCardDifferentSeller;
    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookie;
    public void addToCart() throws InterruptedException {
        Thread.sleep(5000);

        try {
            click(cookie);

            click(pencilProduct);
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1)); // Go to pencil detail tab


            click(addToCartMainSeller);
            Thread.sleep(8000);
            click(cancelButton);
            JavascriptExecutor j = (JavascriptExecutor) driver;
            j.executeScript("window.scrollBy(0,250)");

            click(addToCardDifferentSeller);
            Thread.sleep(8000);
            click(cancelButton);

            JavascriptExecutor f = (JavascriptExecutor) driver;
            f.executeScript("window.scrollBy(0,-250)");

        }catch (Exception e){

            click(pencilProduct);
            List<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(2)); // Go to pencil detail tab


            click(addToCartMainSeller);
            Thread.sleep(8000);
            click(cancelButton);
            JavascriptExecutor j = (JavascriptExecutor) driver;
            j.executeScript("window.scrollBy(0,250)");

            click(addToCardDifferentSeller);
            Thread.sleep(8000);
            click(cancelButton);

            JavascriptExecutor f = (JavascriptExecutor) driver;
            f.executeScript("window.scrollBy(0,-250)");

        }

        //click(cookie);


    }

    @FindBy(id = "shoppingCart")
    private WebElement basketButton;
    public void goToBasket(){
        click(basketButton);
    }
}
