package Steps;

import Data.LoadProperties;
import Pages.CategoriesItemsPage;
import Pages.CompleteCheckoutPage;
import Pages.HomePage;
import Pages.LoginPage;
import Tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class CheckoutSteps extends BaseTest
{
    LoginPage LoginObject;
    WebDriver Driver;
    HomePage HomeObject;
    CompleteCheckoutPage CheckoutObject;
    CategoriesItemsPage ItemObject;
    String AlertMessage= LoadProperties.UserData.getProperty("AddToCartAlertMessage");
    String PurchaseSuccess=LoadProperties.UserData.getProperty("PurchaseSuccess");

    @Given("Login with a valid data {string},{string}")
    public void LoginWithValidData(String username,String Password)
    {
        WebDriverManager.chromedriver().setup();
        Driver=new ChromeDriver();
        HomeObject=new HomePage(Driver);
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Driver.navigate().to("https://www.demoblaze.com/");
        LoginObject=new LoginPage(Driver);
        HomeObject.openLoginPage();
        Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        LoginObject.LoginWithValidData(username,Password);
        Assert.assertEquals(LoginObject.ValidateSuccessLogin().getText(),"Welcome "+username);
    }
    @When("Click on the first element")
    public void clickOnTheFirstElement()
    {
        ItemObject=new CategoriesItemsPage(Driver);
        ItemObject.NavigateToFirstItem();
    }
    @Then("Add it to cart")
    public void addItToCart()
    {
        Assert.assertEquals(ItemObject.GetProductName(),ItemObject.Item);
        ItemObject.AddToCart();
        Assert.assertEquals(ItemObject.AlertCheck(),AlertMessage);

    }

    @Given("GO to cart")
    public void goToCart()
    {
        ItemObject.NavigateToCart();
        Assert.assertTrue(ItemObject.ValidateItemInCart());
    }


    @When("Click on place order")
    public void clickOnPlaceOrder()
    {
        CheckoutObject=new CompleteCheckoutPage(Driver);
        CheckoutObject.PlaceOrderClick();

    }
    @And("Fill the Data {string} , {string} , {string} , {string} , {string} , {string}")
    public void fillTheData(String Name, String Country, String City, String CreditCard, String Month, String Year)
    {
       CheckoutObject.purchaseOrder( Name,  Country,  City,  CreditCard,  Month,  Year);
    }


    @Then("Click Purchase")
    public void clickPurchase()
    {
        Assert.assertEquals(CheckoutObject.ClickPurchase(),PurchaseSuccess);
    }
}
