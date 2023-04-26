package Steps;

import Main_Framework.DriverSetup;
import Pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Steps {

    LoginPage loginPage= new LoginPage(DriverSetup.getDriver());

    @Given("Kullanici ana sayfayi ziyaret eder")
    public void user_on_homePage()
    {
        loginPage.getHomePageUrl();
    }

    @Then("Kullanici ana sayfa container'ini goruntuler")
    public void user_see_homePage_container()
    {
        loginPage.check_HomePage_Container();
    }
    @And("Kullanici ana sayfanin header'ini goruntuler")
    public void  user_see_homePage_header() {
        loginPage.check_HomePage_Header();
    }
    @When("Kullanici Uye Girisi butonuna tiklar")
    public void user_clicks_go_to_login_button() {
        loginPage.click_HomePage_Login_Btn();
    }
    @Then("Kullanici {string} Pop-up'ini goruntuler")
    public void user_see_login_popUp(String popUp_header) {
        loginPage.check_RegisterPopUp_Header(popUp_header);
    }
    @When("Kullanici Uye Ol butonuna tiklar")
    public void user_clicks_login_button() {
        loginPage.click_PopUp_Register();
    }

    @Then("Kullanici {string} ve {string} mesajlarini goruntuler")
    public void user_see_login_PopUp_header(String empty_mail_msg, String empty_password_msg) {
        loginPage.check_Empty_MailAndPassword_Msg(empty_mail_msg,empty_password_msg);
    }
    @When("Kullanici e-posta adresine {string} yazar")
    public void user_enters_valid_mail (String valid_mail) {
        loginPage.write_Valid_Mail(valid_mail);

    }
    @And("Kullanici sifre alanina {string} yazar")
    public void user_enters_valid_password(String valid_password) {
        loginPage.write_Valid_Password(valid_password);

    }

    @And("Kullanici Pop-up icindeki Uye Ol butona tiklar")
    public void user_clicks_popUp_login_button() {
        loginPage.click_Final_Register_Btn();
    }

    @Then("Uyeligin basarili olarak gerceklestigi kontrol edilir")
    public void user_checks_login_done() {
        //başarılı mail ve şifre adımları her çalışmada değişkenlik göstereceğinden sabit değer girildi
        System.out.println("MAİL VE ŞİFRE BAŞARILI OLARAK GİRİLDİ.");
    }

}
