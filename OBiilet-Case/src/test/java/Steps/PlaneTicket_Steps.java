package Steps;
import Main_Framework.DriverSetup;

import Pages.PlaneTicketPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaneTicket_Steps {

    PlaneTicketPage planeTicketPage = new PlaneTicketPage(DriverSetup.getDriver());

    @When("Kullanici Ucak tab'ine tiklar")
    public void user_clicks_Plane_Tab()
    {
        planeTicketPage.click_Flight_Tab_Btn();
    }
    @Then("Kullanici Ucuz Ucak Bileti yazisini goruntuler")
    public void user_see_plane_text() {
        planeTicketPage.check_Flight_Txt();
    }

    @When("Kullanici Nereden kismi icin {string}, Nereye kismi icin {string}, Gidis Tarihi icin 28, Donus Tarihi icin 7 secimini yapar")
    public void user_selects_flight_datas(String departurePoint, String arrivePoint) throws InterruptedException{
        planeTicketPage.set_Flight_Datas(departurePoint, arrivePoint );

    }

    @And("Kullanici Ucak Bileti Bul butonuna tiklar")
    public void user_clicks_find_plane_ticket() {
        planeTicketPage.click_Find_Flight_Ticket_Btn();

    }

    @And("Kullanici ucus listesini goruntuler")
    public void user_see_flight_list() {
        planeTicketPage.check_Flight_List();
    }

    @When("Kullanici listedeki birinci ucusu secer, Gidis icin varsa Ecofly ucusunu secer yoksa ucusun kendisini secer")
    public void user_selects_1th_departure_flight() {
        planeTicketPage.set_Departure_Flight();
    }

    @And("Kullanici listedeki birinci ucusu secer, Donus icin varsa Ecofly ucusunu secer yoksa ucusun kendisini secer")
    public void user_selects_1th_arrive_flight() {
        planeTicketPage.set_Arrive_Flight();
    }

    @Then("Odeme sayfasinin acildigi goruntulenir")
    public void user_see_payment_page() {

        planeTicketPage.check_Payment_Page();

    }
}