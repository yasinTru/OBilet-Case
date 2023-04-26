package Main_Framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
public class DriverSetup {

    static WebDriver driver;
    static Properties properties;

    public static WebDriver initialize_Driver(String browser)  {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled"); //removes the detection
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); //removes the banner
        properties = ConfigReader.getProperties();


        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Chrome Driver Running");
        } else if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            System.out.println("Firefox Driver Running");
        }

        else if(browser.equals("grid-chrome"))
        {

            try
            {
                WebDriverManager.chromedriver().setup();
                driver= new RemoteWebDriver(new URL("http://192.168.1.33:4444"), options);

            }
            catch (MalformedURLException e)
            {
                throw new RuntimeException(e);
            }


            System.out.println("Grid Chrome working");

        }

        else if(browser.equals("Firefox-Headless"))
        {
            FirefoxOptions firefoxOptions= new FirefoxOptions();
            firefoxOptions.addArguments("--headless");
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver(firefoxOptions);
            System.out.println("Firefox headless working");

        }

        else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("Chrome Driver Running");
        }
        String url = properties.getProperty("url");
        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
        int pageWait = Integer.parseInt(properties.getProperty("pageLoadTimeout"));
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(impWait, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(pageWait, TimeUnit.SECONDS);
        return getDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }


}