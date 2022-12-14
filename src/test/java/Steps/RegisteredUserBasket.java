package Steps;

import Base.Driver;
import Pages.BasketPage;
import Pages.HomePage;
import Pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class RegisteredUserBasket {
    private WebDriver driver;

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    BasketPage basketPage = new BasketPage();

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

    @And("user search a specific product")
    public void userSearchASpecificProduct() {
        homePage.searchAProduct();
    }

    @And("user add two product from two different seller")
    public void userAddTwoProductFromTwoDifferentSeller() throws InterruptedException {
        productPage.addToCart();
    }

    @When("user clicks on my basket button")
    public void userClicksOnMyBasketButton() {
        productPage.goToBasket();
    }

    @Then("verify that two products added to the user's basket")
    public void verifyThatTwoProductsAddedToTheUserSBasket() {
        basketPage.verifyProducts();
    }
}
