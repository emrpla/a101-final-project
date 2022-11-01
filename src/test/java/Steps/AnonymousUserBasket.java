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

public class AnonymousUserBasket {

    private WebDriver driver;

    HomePage homePage = new HomePage();
    ProductPage productPage = new ProductPage();
    BasketPage basketPage = new BasketPage();

    @Given("a web browser is at the Hepsiburada home page")
    public void a_web_browser_is_at_the_Hepsiburada_home_page(){

        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hepsiburada.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }

    @And("user search a sample product")
    public void userSearchASampleProduct() {
        homePage.searchAProduct();
    }

    @And("user add two product from two different site")
    public void userAddTwoProductFromTwoDifferentSite() throws InterruptedException {
        productPage.addToCart();
    }

    @When("user clicks on my basket")
    public void userClicksOnMyBasket() {
        productPage.goToBasket();
    }

    @Then("verify that products added to the user's basket")
    public void verifyThatProductsAddedToTheUserSBasket() {
        basketPage.verifyProducts();
        //driver.close();
    }

}
