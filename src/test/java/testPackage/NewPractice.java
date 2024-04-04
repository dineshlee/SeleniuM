package testPackage;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

	public class NewPractice {
	
		
		public static void main(String[] args) throws InterruptedException {
	        NewPractice practice = new NewPractice();
	        practice.All_in_one();
		}
		
		public void All_in_one() throws InterruptedException {
			
			System.setProperty("Webdriver.chrome.driver", "C:\\Users\\DELL\\eclipse-workspace\\Corejava\\ChromeDriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		driver.findElement(By.xpath("(//input[@class='radioButton']) [2]")).click();
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("India");
		
		List<WebElement> options = driver.findElements(By.xpath("//li[@class='ui-menu-item'] /div"));
		for(WebElement option : options)
		{
			if(option.getText().equalsIgnoreCase("India"))
			{
				option.click();
				break;
			}
		}
		
		WebElement selectdp = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));
		
		Select dp = new Select(selectdp);
		dp.selectByIndex(2);
		
		driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("check");
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//input[@id='displayed-text']")).sendKeys("Hi");
		driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id='displayed-text']")).isDisplayed());
		driver.findElement(By.xpath("//input[@id='show-textbox']")).click();
		System.out.println(driver.findElement(By.xpath("//input[@id='displayed-text']")).isDisplayed());
		
		
		Actions mouse = new Actions(driver);
		
		JavascriptExecutor scroll = (JavascriptExecutor)driver;
		
		long pageHeight = (long) scroll.executeScript("return document.body.scrollHeight");

        // Scroll to the middle of the webpage
        scroll.executeScript("window.scrollTo(0, " + pageHeight / 2 + ")");
        // Mouse hover
        mouse.moveToElement(driver.findElement(By.xpath("//button[@id='mousehover']"))).build().perform();
        driver.findElement(By.xpath("//a[text()='Top']")).click();
        NewPractice practice = new NewPractice();
        practice.mousetry(driver);
        Thread.sleep(2000);
        
		
		
	}
public void mousetry(WebDriver driver)
{
	driver.manage().window().maximize();
	driver.get("https://amazon.com");
	Actions mouse = new Actions(driver);
	mouse.moveToElement(driver.findElement(By.xpath("//span[@id='nav-link-accountList-nav-line-1']"))).build().perform();
	System.out.println(driver.findElement(By.xpath("(//div[@class='nav-title']) [2]")).getText());
	
	
}
}
