package testPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import initializeBrowser.All_Browsers;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
public class Amazon extends All_Browsers{

	public static void main(String[] args) throws IOException {
		
//		ChromeDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
//		driver.get("https://www.amazon.com/");
		
		All_Browsers browser = new All_Browsers();
        browser.openBrowser();
        
		Actions mouse = new Actions(driver);
		
		
		// Github token  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
		
		
		mouse.moveToElement(driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"))).build().perform();
		WebElement tittle = driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"));
		System.out.println(tittle.getText());
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("honor");
		List<WebElement> AmazonOptions = driver.findElements(By.xpath("//div[@class='left-pane-results-container']"));
		for(WebElement option : AmazonOptions)
		{
			if(option.getText().equalsIgnoreCase("honor 90"))
			{
				option.click();
				break;
			}
			else
			{
					driver.findElement(By.xpath("//div[@class='left-pane-results-container'] /div /div /div[@aria-label='honor 90']")).click();
			}
			
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot, new File("C:\\Users\\DELL\\eclipse-workspace\\Corejava\\honor.png"));
		}
		
		
	}

}
