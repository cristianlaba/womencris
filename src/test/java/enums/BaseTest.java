package enums;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    private String ChromeDriverPath = "/Users/Inetum-1425/Desktop/chromedriver.exe";


    //Varialbes globales
    public WebDriver webDriver = getWebDriver(WebDriverType.CHROME);
    private WebDriverType webDriverType = WebDriverType.CHROME;


    public WebDriver getWebDriver(WebDriverType webDriverType){
        this.webDriverType = webDriverType;
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        switch (webDriverType){
            case CHROME :
                System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
                options.merge(desiredCapabilities);
                webDriver = new ChromeDriver(options);
                break;
        }//ends SWITCHx
        System.out.println("El webdriver tipo" + webDriverType + " se ha inicializado con exito");
        return webDriver;
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test en Calses BaseTest.java");
        webDriver = getWebDriver(WebDriverType.CHROME);

    }

    @AfterTest
    public void afterTest(){
        System.out.println("After test en clase BaseTest.javaß");
        webDriver.quit();
    }

}
