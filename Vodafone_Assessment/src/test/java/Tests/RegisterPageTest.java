package Tests;

import Data.LoadProperties;
import Pages.HomePage;
import Pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class RegisterPageTest extends BaseTest
{
    HomePage HomeObject;
    RegisterPage RegisterObject;
    String AlertMessage=LoadProperties.UserData.getProperty("SignUpAlertMessage");

    @Test(priority = 1)
    public void ValidateSignupLink()
    {
        HomeObject=new HomePage(driver);
        RegisterObject=new RegisterPage(driver);
        Assert.assertTrue(HomeObject.SignUpLinkDisplayAndEnable());
    }
    @Test(dependsOnMethods = "ValidateSignupLink")
    public void ValidateRegistration(){
        HomeObject.openRegisterPage();
        RegisterObject.RegisterwithValidData(UserName,Password);
        Assert.assertTrue(RegisterObject.AlertCheck().contains("Sign up successful"),AlertMessage);
        softassert.assertEquals(driver.getCurrentUrl(),"https://www.demoblaze.com/");
    }

}
