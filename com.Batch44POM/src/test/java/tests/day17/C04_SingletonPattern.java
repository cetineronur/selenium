package tests.day17;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_SingletonPattern {

    @Test
    public void test01(){

        //singleton pattern : bir class'dan birden fazla obje uretilmesine
        // izin vermeyen bi rpattern olark kabul gormustur
        // driver class'ini driver uretmek uzere kullaniyoruz.
        // ancak driver class'inda driver isminde instance variable de var.
        // ve obje ureterek bu instance driver'a ulasabiliriz.

       // Driver driver = new Driver();

        // Singleton pattern kabul gormus bir pattern dir.
        // amac bir class dan obje uretilmemesini saglamaktir.
        // bunun icin singleton patternde koruyacaginiz class da
        // parametresiz constructor olustururuz. ve private yapariz.
    }
}
