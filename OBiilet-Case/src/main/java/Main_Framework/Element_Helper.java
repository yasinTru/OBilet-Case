package Main_Framework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element_Helper {
    WebDriver driver;
    public Element_Helper(WebDriver driver)
    {
        this.driver=driver;
      //  this.wait =new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    public WebElement findElement(By elementName)
    {
        return
                driver.findElement(elementName);
    }

    public void sendKey(By elementName, String text)
    {
        findElement(elementName).sendKeys(text);
    }

    public void clickElement(By elementName)
    {
        findElement(elementName).click();
    }
    public void checkElement(By elementName)
    {
        findElement(elementName).isDisplayed();
    }

}
