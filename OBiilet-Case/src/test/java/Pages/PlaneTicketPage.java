package Pages;
import Main_Framework.Element_Helper;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PlaneTicketPage {

    //Framework tanımlamarı
    WebDriver driver;
    Element_Helper elementHelper;

    //Web elementleri
   By plane_Tab_Btn= By.xpath("//a[@data-event-action='Flight']");
    By flight_Text= By.xpath("//span[normalize-space()='Ucuz Uçak Bileti']");
    By flight_Departure_Point= By.cssSelector("#origin-input");
    By flight_Arrive_Point= By.cssSelector("#destination-input");
    By flight_Departure_Input= By.cssSelector("#departure-input");
    By flight_Departure_Date= By.xpath("(//span[contains(text(),'28')])[1]");
    By flight_Arrive_Input= By.cssSelector("#return-input-placeholder");
    By flight_Arrive_Date= By.xpath("(//span[contains(text(),'7')])[4]");
    By flights_list= By.cssSelector("#outbound-journeys");
    By flight_1th_departure= By.xpath("(//div[@class='journey row'])[1]");

    By flight_1th_arrive= By.xpath("(//div[@class='features col'])[65]");
    By flights_ecoFly= By.cssSelector(".fly-content-container.EF");
    By flight_without_class= By.xpath("(//div[@class='features col'])[40]");
    By flight_Search_Btn= By.cssSelector("#search-button");
    By payment_Header_Label= By.cssSelector(".journey-contact-info-label");
    By payment_Payment_Label= By.cssSelector(".payment-label");

    //constructor
    public PlaneTicketPage(WebDriver driver)
    {
        this.driver=driver;
        this.elementHelper= new Element_Helper(driver);
    }

    //Sayfa fonksiyonları
    public void click_Flight_Tab_Btn()
    {
        elementHelper.clickElement(plane_Tab_Btn);
    }
    public void check_Flight_Txt()
    {
        elementHelper.checkElement(flight_Text);
    }
    public void set_Flight_Datas(String departurePoint, String arrivePoint) throws InterruptedException
    {
        //gidiş adımları
        elementHelper.findElement(flight_Departure_Point).click();
        elementHelper.findElement(flight_Departure_Point).sendKeys(departurePoint);
        Thread.sleep(2000);
        elementHelper.findElement(flight_Departure_Point).sendKeys(Keys.ENTER);
        //dönüş adımları
        elementHelper.findElement(flight_Arrive_Point).click();
        elementHelper.findElement(flight_Arrive_Point).sendKeys(arrivePoint);
        Thread.sleep(2000);
        elementHelper.findElement(flight_Arrive_Point).sendKeys(Keys.ENTER);

        //tarih seçimleri
        elementHelper.findElement(flight_Departure_Input).click();
        elementHelper.findElement(flight_Departure_Date).click();
        Thread.sleep(3000);
        elementHelper.findElement(flight_Arrive_Input).click();
        elementHelper.findElement(flight_Arrive_Date).click();
    }
    public void click_Find_Flight_Ticket_Btn()
    {
        elementHelper.clickElement(flight_Search_Btn);
    }
    public void check_Flight_List()
    {
        elementHelper.checkElement(flights_list);
    }
    public void set_Departure_Flight()
    {
        elementHelper.clickElement(flight_1th_departure);
        WebElement flights_List = driver.findElement(flights_ecoFly);

        if (flights_List.isDisplayed())
        {
           elementHelper.clickElement(flights_ecoFly);
        } else
        {
            elementHelper.clickElement(flight_without_class);
        }
    }
    public void  set_Arrive_Flight()
    {
        elementHelper.clickElement(flight_1th_arrive);

    }
    public void check_Payment_Page()
    {
        elementHelper.checkElement(payment_Payment_Label);
        elementHelper.checkElement(payment_Header_Label);
    }
}
