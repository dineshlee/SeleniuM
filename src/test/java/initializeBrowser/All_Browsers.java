package initializeBrowser;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

public class All_Browsers {
	
	public static WebDriver driver;
		@Test
		public WebDriver initializeAllBrowsers() throws IOException
		{
			
			Properties property = new Properties();
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"C:\\Users\\DELL\\eclipse-workspace\\SeleniuM\\src\\main\\java\\resources\\whichBrowser.properties");
			property.load(fis);
			String browserName = property.getProperty("browser");
			
			if(browserName.equalsIgnoreCase("chrome")) 
			{
			ChromeDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			}
			else if(browserName.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				WebDriver driver = new EdgeDriver();
			}
			else if(browserName.equalsIgnoreCase("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				WebDriver driver = new FirefoxDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
			return driver;
			
		}
	
		
		public void openBrowser() throws IOException
		{
			driver = initializeAllBrowsers();
			driver.get("https://www.amazon.com/");
		}
	
}
