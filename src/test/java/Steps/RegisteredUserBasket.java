package Steps;

import Base.Driver;
import Pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class RegisteredUserBasket {
    private WebDriver driver;

    HomePage homePage = new HomePage();

    @Given("a web browser is at the hepsiburada home page")
    public void a_web_browser_is_at_the_hepsiburada_home_page(){

        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hepsiburada.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @And("user login to the site")
    public void userLoginToTheSite() {
        homePage.login();
    }

    @And("verify that the user login successfully")
    public void verifyThatTheUserLoginSuccessfully() {
        homePage.verifyUserLogin();
    }

    @And("user search a spesific product")
    public void userSearchASpesificProduct() {
        homePage.searchAProduct();
    }

    @And("user add two product from two different seller")
    public void userAddTwoProductFromTwoDifferentSeller() throws InterruptedException {
        homePage.addToCart();
    }
}
