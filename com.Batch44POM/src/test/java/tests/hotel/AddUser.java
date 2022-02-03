package tests.hotel;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HotelMyCampPage;

public class AddUser {

    HotelMyCampPage hotelMyCampPage =new HotelMyCampPage();
    @BeforeMethod
    public void loginHotel(){
        hotelMyCampPage.hotelMyCampLogin();

    }
}
