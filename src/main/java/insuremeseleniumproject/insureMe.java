package insuremeseleniumproject;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class insureMe {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("http://localhost:8081/contact.html");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("inputName")).sendKeys("Niladri Sankar Mondal");
		driver.findElement(By.id("inputNumber")).sendKeys("8431630203");
		driver.findElement(By.id("inputMail")).sendKeys("niladrimondal.mondal@gmail.com");
		driver.findElement(By.id("inputMessage")).sendKeys("Hello Insurer");
		driver.findElement(By.id("my-button")).click();
		
		String message = driver.findElement(By.id("response")).getText();
		if(message.equals("Message Sent")) {
			System.out.println("Script Executed Successfully");
		} else 
		{
			System.out.println("Script Failed");
		}
		
		
		
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File ("C:\\chromedriver\\test-reports\\scr.png");
		FileUtils.copyFile(screenShot, destFile);
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}
}
