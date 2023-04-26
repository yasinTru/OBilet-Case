package Runner;

import Main_Framework.DriverSetup;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;


@CucumberOptions(
        features = {"src/test/java/Features"},
        glue = {"Steps", "Main_Framework"},
        tags = "",
        plugin = {
                "summary", "pretty", "html:Reports/CucumberReports/Reports.html",
                "json:Reports/CucumberReports/Report",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class TestRunner extends AbstractTestNGCucumberTests {
    static WebDriver driver = DriverSetup.getDriver();
}