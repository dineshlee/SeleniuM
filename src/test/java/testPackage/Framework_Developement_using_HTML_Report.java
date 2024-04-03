package testPackage;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Framework_Developement_using_HTML_Report {
	
	@Test
	public void HTMLreports() throws InterruptedException, IOException {
		
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        sparkReporter.config().setReportName("Automation Report");
        sparkReporter.config().setDocumentTitle("Test Results");
        
        ExtentReports extend = new ExtentReports();
        extend.attachReporter(sparkReporter);
        extend.setSystemInfo("Tester", "Dinesh Selvam");
        extend.createTest("First HTML report");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.xpath("//input[@id='userEmail']")).sendKeys("dineshlee.xd@gmail.com");
		driver.findElement(By.xpath("//input[@id='userPassword']")).sendKeys("Dinesh@1994");
		driver.findElement(By.xpath("//input[@id='login']")).click();
		
		List<WebElement> allOptions = driver.findElements(By.xpath("//div[contains(@class, 'mb-3')]"));
		for(WebElement option : allOptions)
		{
			if(option.getText().contains("ZARA COAT 3"))
			{
				option.findElement(By.xpath("//button[contains(@class,'w-10')]")).click();
			}
			
			if(option.getText().contains("ADIDAS ORIGINAL"))
			{
				Thread.sleep(5000);
				option.findElement(By.xpath("(//button[contains(@class,'w-10')]) [2]")).click();
			}
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//button[contains(@class,'btn-custom')]) [3]")).click();
		Thread.sleep(5000);
		
		
		JavascriptExecutor scroll = (JavascriptExecutor)driver;
		
		long pageHeight = (long) scroll.executeScript("return document.body.scrollHeight");

        // Scroll to the middle of the webpage
        scroll.executeScript("window.scrollTo(0, " + pageHeight / 3 + ")");
		
        
        List<WebElement> checkout = driver.findElements(By.xpath("//button[contains(@class,'btn-primary')]"));
        for(WebElement co : checkout)
        {
        	if(co.getText().contains("Checkout"))
        	{
        		Thread.sleep(3000);
        		co.click();
        	}
        }
        
        WebElement dropdown = driver.findElement(By.xpath("(//select[contains(@class,'input')]) [1]"));
        Select opselect = new Select(dropdown);
        opselect.selectByVisibleText("11");
        
        Thread.sleep(1000);
        WebElement dropdown2 = driver.findElement(By.xpath("(//select[contains(@class,'input')]) [2]"));
        Select opselect2 = new Select(dropdown2);
        opselect2.selectByVisibleText("22");
        
        driver.findElement(By.xpath("(//input[@type='text']) [2]")).sendKeys("2024");
        driver.findElement(By.xpath("(//input[@type='text']) [3]")).sendKeys("credit card");
        driver.findElement(By.xpath("(//input[@type='text']) [4]")).sendKeys("Thankyou");
        driver.findElement(By.xpath("//button[contains(@class,'btn-primary')]")).click();
        Thread.sleep(5000);
        
        
        driver.findElement(By.xpath("(//input[contains(@class,'text-validated')]) [3]")).sendKeys("India");
        List<WebElement> dynamicDropdowns = driver.findElements(By.xpath("//section[contains(@class,'list-group')] /button /span"));
        for(WebElement dds : dynamicDropdowns)
        {
        	if(dds.getText().contains("India") && dds.getText().startsWith("India"))
        	{
        		dds.click();
        	}
        }
        
        driver.findElement(By.xpath("//a[contains(@class,'action__submit')]")).click();
        Thread.sleep(4000);
        String completed = driver.findElement(By.xpath("//*[@class='hero-primary']")).getText();
        System.out.println(completed + "downloaded your receipt");
        driver.findElement(By.xpath("(//button[contains(@class,'btn-primary')]) [1]")).click();
        
        File sShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sShot, new File("C:\\Users\\DELL\\eclipse-workspace\\SeleniuM\\screenshot\\completed.png"));
        driver.close();
        
        extend.flush();
	}

}
