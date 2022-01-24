package tests.day08;

import org.testng.annotations.Test;

public class C01_Notains {


    @Test(priority = -9)
    public void youtubeTest(){

        System.out.println("Youtub testi calisti");

    }


    @Test (priority = 8)
    public void amazonTest(){
        System.out.println("amazon testi calisti");


    }


    @Test (priority = 5)
    public void bestbuyTest(){
        System.out.println("bestbuy testi calisti");


    }

}
