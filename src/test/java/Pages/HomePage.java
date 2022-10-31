package Pages;

import Base.BaseTest;
import Base.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BaseTest {

    WebDriver driver;

    public HomePage()
    {
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//*[@id=\"myAccount\"]/span/span[2]")
    private WebElement loginFrame;
    @FindBy(id="login")
    private WebElement loginText;
    @FindBy(id="btnFacebook")
    private WebElement facebookLoginButton;
    @FindBy(id="email")
    private WebElement emailInput;
    @FindBy(id="pass")
    private WebElement passwordInput;
    @FindBy(id = "loginbutton")
    private WebElement finalLoginButton;
    public void login(){
        Actions actions = new Actions(driver);
        actions.moveToElement(loginFrame).build().perform();
        click(loginText);

        click(facebookLoginButton);
        sendKeys(emailInput,"emrpla12@gmail.com");
        sendKeys(passwordInput,"supernatural4");
        click(finalLoginButton);

    }

    @FindBy(xpath = "//*[@id=\"myAccount\"]/span/a/span[2]")
    private WebElement usernameverify;
    public void verifyUserLogin(){
        String expectedResult = "Emre Pala";
        Assert.assertEquals(usernameverify.getText(),expectedResult,"This is a different user");
    }

    @FindBy(xpath = "/html/body/div/div/div/div[3]/div[5]/div/div/div/div/div[2]/div[2]/div/div/div/div/div/div/div[1]/div[2]/input")
    private WebElement searchBar;
    @FindBy(xpath = "/html/body/div/div/div/div[3]/div[5]/div/div/div/div/div[2]/div[2]/div/div/div/div/div/div/div[2]]")
    private WebElement searchButton;
    public void searchAProduct(){
        Actions actions = new Actions(driver);
        actions.click(searchBar).sendKeys("Kalem").sendKeys(Keys.ENTER).perform();
    }

    @FindBy(xpath = "//*[@id=\"i0\"]/div")
    private WebElement pencilProduct;
    @FindBy(id = "addToCart")
    private WebElement addToCartMainSeller;
    @FindBy(xpath = "/html/body/div[7]/div/div/div/div/div/div/h1/a")
    private WebElement cancelButton;
    @FindBy(xpath = "/html/body/div[2]/main/div[3]/section[1]/div[4]/div/div[4]/div[2]/div[3]/div/div[2]/table/tbody/tr[1]/td[3]/div")
    private WebElement assToCardDifferentSeller;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement cookie;
    public void addToCart() throws InterruptedException {
        click(pencilProduct);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1)); // Go to pencil detail tab

        click(addToCartMainSeller);
        Thread.sleep(8000);
        click(cancelButton);
        click(cookie);
        click(assToCardDifferentSeller);
        Thread.sleep(8000);
        click(cancelButton);

    }

    @FindBy(xpath = "//*[@id=\"oldHeader_fc033431-df58-48a5-96a3-ccdf85795f79\"]/div/div/div[2]/div[3]/a")
    private WebElement basketButton;
    public void goToBasket(){
        click(basketButton);
    }

    @FindBy(id = "basket-item-count")
    private WebElement productCount;
    public void verifyProducts(){
        int expectedProductCount = 2;
        Assert.assertEquals(productCount,expectedProductCount,"You don't have two products on your basket");
    }
}
