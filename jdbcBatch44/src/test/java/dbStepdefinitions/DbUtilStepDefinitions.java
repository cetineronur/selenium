package dbStepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DbUtils;

import java.sql.SQLException;

public class DbUtilStepDefinitions {

    @Given("kullanici DBUtil ile HMC veri tabanina baglanir")
    public void kullanici_db_util_ile_hmc_veri_tabanina_baglanir() {
        DbUtils.getConnection();

    }
    @Given("kullanici DBUtil ile {string} tablosundaki {string} verilerini alir")
    public void kullanici_db_util_ile_tablosundaki_verilerini_alir(String table, String field) {
        //select field From table;
        String readQuery="select "+field+" FROM " +table;
        DbUtils.executeQuery(readQuery);

    }
    @Given("kullanici DBUtil ile {string} sutunundaki verileri okur")
    public void kullanici_db_util_ile_sutunundaki_verileri_okur(String field) throws SQLException {
        DbUtils.getResultset().first();

    }
    @Given("DBUtil ile tum {string} degerlerini sira numarasi ile yazdirir")
    public void db_util_ile_tum_degerlerini_sira_numarasi_ile_yazdirir(String field) throws Exception {

        int satirSayisi = DbUtils.getRowCount();
        DbUtils.getResultset().first();
        int count = 1;

        for(int i=1; i<satirSayisi;i++){
            System.out.println(i + ".ci satirdaki " + field+": " + DbUtils.getResultset().getString(field));
            DbUtils.getResultset().next();
            count++;
        }

    }
    @Then("DBUtill ile {int}. {string} in {int} oldugunu test eder")
    public void db_utill_ile_in_oldugunu_test_eder(Integer siraNO, String field, Integer expectedPrice) throws SQLException {

        DbUtils.getResultset().absolute(siraNO);
        double actualPrice = DbUtils.getResultset().getDouble(field);
        Assert.assertTrue(actualPrice==expectedPrice);
    }

     @Then("tHOTEL tablosunda IDHotel degeri {int} olan kaydin Email bilgisini {string} yapar")
    public void thotelTablosundaIDHotelDegeriOlanKaydinEmailBilgisiniYapar(int IDHotel, String yeniEmail) {

        //UPDATE Email from tHOTEL where IDHotel='1016';
         String updateQuery="UPDATE tHOTEL set Email='"+yeniEmail+"' where IDHotel='"+IDHotel+"';";
         DbUtils.executeQuery(updateQuery);
    }
}
