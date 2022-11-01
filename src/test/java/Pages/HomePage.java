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
        actions.click(searchBar).sendKeys("Nutella").sendKeys(Keys.ENTER).perform();
    }

}
