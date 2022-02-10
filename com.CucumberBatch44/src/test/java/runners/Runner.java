package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue="stepdefinitions",
        tags = "@wip",
        dryRun = false
)
public class Runner {
    //Runner classinin body'sine hicbir kod yazmayacaz. bu class icin onemli olan kullanacagimiz 2 adet notasyon

}
