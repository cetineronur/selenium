package tests.day17;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_YanlisKeyKullanimi {

    @Test
    public void test01(){

        Driver.getDriver().get(ConfigReader.getProperty("HMCurl"));
        // eger key olarak girdigimiz String configuration dosyasinda yoksa
        // ConfigReader.getProperty() o keyi bulamaz
        // ve nullpointerException firlatir

    }
}
