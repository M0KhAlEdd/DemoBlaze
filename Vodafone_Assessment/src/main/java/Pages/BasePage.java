package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    protected  WebDriver driver=null;
    protected  JavascriptExecutor Js=null;
    protected  Select select=null;
    protected  Actions action;
    protected  Alert alert;
    public BasePage(WebDriver driver)
    {
        if(driver !=null)
        {
            this.driver =driver;
         PageFactory.initElements(driver,this);
        }
        else
        {
            System.out.println("Browser driver not Found");
        }
    }

    public void ButtonClick( WebElement Button)
    {
       Button.click();
    }

    public void SendTextToTextElement(WebElement TextElement, String Text)
    {
        if(TextElement !=null)
        {
            TextElement.sendKeys(Text);        }
        else
        {
            System.out.println("Text Element not Found");
        }
    }
    public void JsExecuter(String JsScript)
    {
        Js.executeScript(JsScript);
    }
    public String AlertCheck()
    {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        alert=wait.until(ExpectedConditions.alertIsPresent());
         alert = driver.switchTo().alert();
         String AlertMessage=alert.getText();
         alert.accept();
         driver.switchTo().defaultContent();

        return AlertMessage;
    }


}
