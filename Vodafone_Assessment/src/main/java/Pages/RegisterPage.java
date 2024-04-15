package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver)
    {
        super(driver);
    }
    @FindBy(id = "sign-username")
     WebElement SignUpUserNameText;
    @FindBy(id = "sign-password")
     WebElement SignUpPasswordText;
    @FindBy(css = "button[onclick=\"register()\"]")
     WebElement SignUpBtn;
    @FindBy(css = "//*[@id=\"signInModal\"]/div/div/div[3]/button[1] ")
     WebElement CancelSignUp;

    public void RegisterwithValidData(String Username,String Password)
    {
        SendTextToTextElement(SignUpUserNameText,Username);
        SendTextToTextElement(SignUpPasswordText,Password);
        ButtonClick(SignUpBtn);
    }

}
