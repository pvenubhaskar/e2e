package e2e;


import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
//
//@RunWith(Suite.class)
//@Suite.SuiteClasses({ BaseTest.class })
////@RunWith(JUnit4.class)

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.log4testng.Logger;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseClass {
	    public static WebDriver driver;
	    public Logger logger = Logger.getLogger(BaseClass.class);
	    public static Properties prop = new Properties();
	    public static FileReader reader;


	    @BeforeClass
	    public static void setup() throws IOException {
	        System.out.println("Setup");
	        reader = new FileReader("src/test/resources/config.properties");
	        prop.load(reader);
	        String browser = prop.getProperty("browser");
	        reader.close();
	        //WebDriverManager.chromedriver().create();
	        ChromeOptions chromeOptions = new ChromeOptions();
	        chromeOptions.setBrowserVersion("144");
	        switch (browser.toLowerCase()) {
	            case "chrome":
	                driver = new ChromeDriver(chromeOptions);
	                driver.manage().window().maximize();
	                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	                driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	                break;
	            case "firefox":
	                driver = new FirefoxDriver();
	                driver.manage().window().maximize();
	                break;

	        }
	    }
	    @AfterClass
	    public static void tearDown(){
	    	
	        driver.quit();
	    }
}
