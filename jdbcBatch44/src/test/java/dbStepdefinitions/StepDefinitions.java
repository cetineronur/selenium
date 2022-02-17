package dbStepdefinitions;

import io.cucumber.java.en.Given;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StepDefinitions {
    String url="jdbc:sqlserver://184.168.194.58:1433;databaseName=hotelmycamp ; user=techproed;password=P2s@rt65";
    String username="techproed";
    String password="P2s@rt65";
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("kullanici HMC veri tabanina baglanir")
    public void kullanici_hmc_veri_tabanina_baglanir() throws SQLException {

            connection= DriverManager.getConnection(url,username,password);
            statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

    }
    @Given("kullanici {string} tablosundaki {string} verilerini alir")
    public void kullanici_tablosundaki_verilerini_alir(String table, String field) throws SQLException {
        //query calistiriyoruz
        //SELECT Price FROM tHOTELROOM
        String readQuery="SELECT "+field+" FROM "+table;
        resultSet=statement.executeQuery(readQuery);
    }
    @Given("kullanici {string} sutunundaki verileri okur")
    public void kullanici_sutunundaki_verileri_okur(String field) throws SQLException {
       //resulset bizim su ana kadar kullandigimiz Set yapisinda degildir.
        //resulset iterator ile calisir.

        resultSet.first();// bu komut iterator'i ilk elemente goturur, gitti ise true doner.
        // iterator istenen konuma gidince artik elementi yazdirabiliriz
        System.out.println(resultSet.getString(field));

        //kaldigi yerden devam eder.
        while(resultSet.next()){
            System.out.println(resultSet.getString(field));
        }

        resultSet.last();
        System.out.println(resultSet.getRow());
        resultSet.absolute(0);
        List<Double> priceList = new ArrayList<>();

        while(resultSet.next()){
            priceList.add(resultSet.getDouble(field));
        }
        System.out.println(priceList);


    }
}
