package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
    public HomePage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(id = "signin2")
     WebElement SignUpLink;

    @FindBy(id = "login2")
     WebElement LoginLink;

    public boolean SignUpLinkDisplayAndEnable()
    {
        return SignUpLink.isDisplayed() && SignUpLink.isEnabled();
    }
    public boolean LoginLinkDisplayAndEnable()
    {
        return LoginLink.isDisplayed() && LoginLink.isEnabled();
    }
    public void openRegisterPage()
    {
        ButtonClick(SignUpLink);
    }
    public void openLoginPage()
    {
        ButtonClick(LoginLink);
    }
}
