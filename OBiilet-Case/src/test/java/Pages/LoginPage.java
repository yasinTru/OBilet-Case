package Pages;
import Main_Framework.Element_Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    //Framework tanımlamarı
    WebDriver driver;
    Element_Helper elementHelper;

    //Web elementleri
    By homePage_container=By.cssSelector("#search-container");
    By homePage_header= By.cssSelector("#header");
    By homePage_login_Btn= By.cssSelector(".login");
    By loginPopUp_Login_Header = By.xpath("//h2[contains(text(),'Üye Girişi')]");
    By loginPopUp_SignUp_to_Login= By.cssSelector(".sign-up.login-to-register");
    By loginPopUp_Register_Btn= By.cssSelector(".register.register-button");
    By loginPopUp_Email_Err= By.cssSelector("#email-error");
    By loginPopUp_Password_Err= By.cssSelector("#password-error");
    By mail_Input= By.cssSelector("input[placeholder='E-posta Adresi']");
    By password_Input= By.cssSelector("input[placeholder='Parola']");




        //constructor
        public LoginPage(WebDriver driver)
        {
            this.driver=driver;
          //  this.wait =new WebDriverWait(driver, Duration.ofSeconds(20));
            this.elementHelper= new Element_Helper(driver);
        }

        //Sayfa fonksiyonları
    public void getHomePageUrl()
    {
        String homePageUrl="Ucuz Otobüs Bileti Fiyatları, Otobüs Bileti Al - obilet.com";
        String currentUrl= driver.getTitle();
        Assert.assertEquals(homePageUrl,currentUrl);
        System.out.println(homePageUrl);
        System.out.println(currentUrl);
    }
    public void check_HomePage_Container()
    {
        elementHelper.checkElement(homePage_container);
    }

    public void check_HomePage_Header()
    {
        elementHelper.checkElement(homePage_header);
    }
    public void click_HomePage_Login_Btn()
    {
        elementHelper.clickElement(homePage_login_Btn);
    }
    public void check_RegisterPopUp_Header(String popUp_header)
    {
        elementHelper.findElement(loginPopUp_Login_Header).equals(popUp_header);
    }
    public void click_PopUp_Register()
    {
        elementHelper.clickElement(loginPopUp_SignUp_to_Login);
        elementHelper.clickElement(loginPopUp_Register_Btn);
    }
    public void check_Empty_MailAndPassword_Msg(String empty_mail_msg, String empty_password_msg)
    {
        elementHelper.findElement(loginPopUp_Email_Err).equals(empty_mail_msg);
        elementHelper.findElement(loginPopUp_Password_Err).equals(empty_password_msg);
    }
    public void write_Valid_Mail(String valid_mail)
    {
        elementHelper.findElement(mail_Input).sendKeys(valid_mail);
    }

    public void write_Valid_Password(String valid_password)
    {
        elementHelper.findElement(password_Input).sendKeys(valid_password);
    }
    public void click_Final_Register_Btn()
    {
        elementHelper.clickElement(loginPopUp_Register_Btn);
    }






}
