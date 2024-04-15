package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompleteCheckoutPage extends BasePage
{

    public CompleteCheckoutPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css="button.btn.btn-success")
    WebElement PlaceOrderBtn;
    @FindBy(id="name")
    WebElement NameText;
    @FindBy(id="country")
    WebElement CountryText;
    @FindBy(id="city")
    WebElement cityText;
    @FindBy(id="card")
    WebElement cardText;
    @FindBy(id="month")
    WebElement monthText;
    @FindBy(id="year")
    WebElement yearText;
    @FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
    WebElement PurchaseBtn;

    @FindBy(xpath = "/html/body/div[11]/h2")
    WebElement MessageSuccess;


    public void PlaceOrderClick()
    {
        ButtonClick(PlaceOrderBtn);
    }
    public void purchaseOrder(String Name, String Country, String City, String CreditCard, String Month, String Year)
    {
        SendTextToTextElement(NameText,Name);
        SendTextToTextElement(CountryText,Country);
        SendTextToTextElement(cityText,City);
        SendTextToTextElement(cityText,CreditCard);
        SendTextToTextElement(monthText,Month);
        SendTextToTextElement(yearText,Year);

    }
    public String ClickPurchase()
    {
        ButtonClick(PurchaseBtn);
        return MessageSuccess.getText();
    }
}
