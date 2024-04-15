package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoriesItemsPage extends BasePage
{

    public CategoriesItemsPage(WebDriver driver)
    {
        super(driver);
    }
    public  String Item;
    @FindBy(linkText = "Phones")
    WebElement PhonesCat;
    @FindBy(linkText = "Laptops")
    WebElement LaptopsCat;
    @FindBy(linkText = "Monitors")
    WebElement MonitorsCat;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")
    WebElement FirstItem;
    @FindBy(xpath = "//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")
    WebElement ItemNAme;

    @FindBy(css="h2[class=\"name\"")
    WebElement ProductName;
    @FindBy(linkText = "Add to cart")
    WebElement AddToCartBtn;
    @FindBy(id="cartur")
    WebElement CartButton;
    public boolean ValidateCategoriesItemsNotEmpty()
    {
        List<WebElement> Categories=driver.findElements(By.id("a[id=\"itemc\"]"));
        for(WebElement Element: Categories)
        {
            ButtonClick(Element);
            List<WebElement> Items=driver.findElements(By.cssSelector("div[class=\"col-lg-4.col-md-6.mb-4\"]"));
            if(Items.isEmpty())
            {
                return false;
            }
        }
        return true;
    }
    public void NavigateToFirstItem()
    {
         Item=ItemNAme.getText();
        FirstItem.click();
    }
    public String GetProductName()
    {
        return ProductName.getText();
    }
    public void AddToCart()
    {
        ButtonClick(AddToCartBtn);
    }
    public void NavigateToCart()
    {
        ButtonClick(CartButton);
    }
    public boolean ValidateItemInCart()
    {
        List<WebElement> ItemsInCart=driver.findElements(By.tagName("td"));
        for(WebElement Element:ItemsInCart)
        {
            if(Element.getText().equals(Item))
            {
                return true;
            }
        }
        return false;
    }

}
