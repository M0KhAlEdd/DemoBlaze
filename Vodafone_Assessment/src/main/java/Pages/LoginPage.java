package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage
{
    public LoginPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(id = "loginusername")
    static WebElement LoginUsername;
    @FindBy(id = "loginpassword")
    static WebElement LoginPassword;
    @FindBy(css = "button[onclick=\"logIn()\"]")
    static WebElement LoginBtn;
    @FindBy(css = "//*[@id=\"logInModal\"]/div/div/div[3]/button[1]")
    static WebElement CancelLogin;
    @FindBy(css="a[id=\"nameofuser\"]")
    static WebElement WelcomeBtn;
    public void LoginWithValidData(String Username,String Password)
    {
        SendTextToTextElement(LoginUsername,Username);
        SendTextToTextElement(LoginPassword,Password);
        ButtonClick(LoginBtn);
    }
    public WebElement ValidateSuccessLogin()
    {
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(WelcomeBtn));
        return WelcomeBtn;
    }
}
