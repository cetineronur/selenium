package tests.day13;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExistTest {

    @Test
    public void test(){
        // projemizde pom.xml oldugunu test edin.
        String path= System.getProperty("user.dir")+"\\pom.xml";
        Assert.assertTrue(Files.exists(Paths.get(path)));

    }
}
