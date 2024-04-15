package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    LoginPage LoginObject;
    HomePage HomeObject;
    RegisterPage RegisterObject;

    @Test(priority = 2)
    public void ValidateLoginDisplay()
    {
        HomeObject=new HomePage(driver);
        LoginObject=new LoginPage(driver);
        Assert.assertTrue(HomeObject.LoginLinkDisplayAndEnable());
    }

    @Test(dependsOnMethods = "ValidateLoginDisplay")
    public void LoginWithVaildData()
    {
        HomeObject.openLoginPage();
        LoginObject.LoginWithValidData(UserName,Password);
        Assert.assertEquals(LoginObject.ValidateSuccessLogin().getText(),"Welcome "+UserName);
    }
}
