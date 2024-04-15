package Tests;

import Data.LoadProperties;
import Pages.CategoriesItemsPage;
import Pages.HomePage;
import Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CategoriesItemsTest extends BaseTest
{
    LoginPage LoginObject;
    HomePage HomeObject;
    CategoriesItemsPage ItemsObject;
    String UserLogin= LoadProperties.UserData.getProperty("UserNameLogin");
    String PasswordLogin=LoadProperties.UserData.getProperty("PasswordLogin");
    String AlertMessage=LoadProperties.UserData.getProperty("AddToCartAlertMessage");
    @Test(priority = 1)
    public void LoginWithVaildData()
    {
        HomeObject=new HomePage(driver);
        LoginObject=new LoginPage(driver);
        ItemsObject=new CategoriesItemsPage(driver);
        HomeObject.openLoginPage();
        LoginObject.LoginWithValidData(UserLogin,PasswordLogin);
        Assert.assertEquals(LoginObject.ValidateSuccessLogin().getText(),"Welcome "+UserLogin);
    }
    @Test(priority = 2,dependsOnMethods = "LoginWithVaildData")
    public void ValidateEveryCategoryhasItems()
    {
       Assert.assertTrue( ItemsObject.ValidateCategoriesItemsNotEmpty());
    }
    @Test(priority = 3)
    public void AddToCart()
    {
        ItemsObject.NavigateToFirstItem();
        Assert.assertEquals(ItemsObject.GetProductName(),ItemsObject.Item);
        ItemsObject.AddToCart();
       Assert.assertEquals(HomeObject.AlertCheck(),AlertMessage);
        ItemsObject.NavigateToCart();
        Assert.assertTrue(ItemsObject.ValidateItemInCart());
    }
}
