package qa.amazon.bdd.base;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import qa.amazon.bdd.constant.FileName;
import qa.amazon.bdd.pageobject.Homepage;
import qa.amazon.bdd.pageobject.IphonePage;
import qa.amazon.bdd.pageobject.ResultPage;

import static qa.amazon.bdd.constant.Key.*;
import qa.amazon.bdd.util.ConfigUtil;
import java.time.Duration;

public class TestBaseClass {

    public static WebDriver driver; // or we can use protected type, otherwise it is default type
    ConfigUtil config;
    public WebDriverWait wait;
    public static JavascriptExecutor javascriptExecutor;
    
    public static Homepage homepage;
    public static ResultPage resultPage;
    public static IphonePage iphonePage;

    public void setUp() {
        config = new ConfigUtil(FileName.CONFIG_PROPERTIES);
        driver = initDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(config.getPropertyValue(URL));
        // How can we convert a String to Long type
        long pageLoadTime = Long.parseLong(config.getPropertyValue(PAGELOAD_WAIT));
        long explicitlyWait =	Long.parseLong(config.getPropertyValue(EXPLICIT_WAIT));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTime));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(explicitlyWait));
        wait = new WebDriverWait(driver, Duration.ofSeconds(explicitlyWait));
        javascriptExecutor = (JavascriptExecutor)driver;
        initClasses(driver);
    }

    public WebDriver initDriver () {
        String browserName = config.getPropertyValue(BROWSER);

        switch (browserName) {

            case "chrome":
                WebDriverManager.chromedriver().setup();
                
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                options.merge(capabilities);
                
                return new ChromeDriver(options);
                
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
        }
    }

    public void initClasses(WebDriver driver) {
    	homepage = new Homepage(driver);
    	resultPage = new ResultPage(driver);
    	iphonePage = new IphonePage(driver);
    }
    
    // After a test is done, what need to do
    public void tearUp(){
        driver.quit();
    }
}
