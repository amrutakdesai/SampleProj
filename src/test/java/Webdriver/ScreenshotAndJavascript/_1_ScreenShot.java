package Webdriver.ScreenshotAndJavascript;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class _1_ScreenShot {

	WebDriver driver;
	WebDriverWait wait;
	String url="https://www.google.co.in";

	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		wait=new WebDriverWait(driver,15);

	}
	@Test
	public void printScreenShot()
	{
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("selenium");

		WebElement btn=driver.findElement(By.name("btnK"));
		btn.click();

		wait.until(ExpectedConditions.titleContains("selenium"));

		screenShotCapture(driver,"SeleniumResult");



	}
	@Test
	public void printScreenShot2()
	{
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("selenium");

		WebElement btn=driver.findElement(By.name("btnK"));
		btn.click();

		wait.until(ExpectedConditions.titleContains("git"));

		screenShotCapture(driver,"gitResult");



	}

	@Test
	public void printScreenShot1()
	{
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("Appium");

		WebElement btn=driver.findElement(By.name("btnK"));
		btn.click();

		wait.until(ExpectedConditions.titleContains("Appium"));

		screenShotCapture(driver,"AppiumResult");



	}
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
	public static void screenShotCapture(WebDriver driver,String fileName)
	{
//		// 1. Take Screenshot & store into a File
//		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//		// 2. Copy the captured screenshot into the desired destination path
//		try {
//
//			// 3. Transferring the screenshot by hard coded path (Must not be used) 
//			//FileUtils.copyFile(file, new File("C:\\Users\\Sarang\\eclipse-workspace\\WebDriverTopics\\src\\test\\java\\_7_ScreenShotCaptureNJavaScriptUtils\\_1_ScreenshotCapture\\screenshots\\" + fileNameToBe + ".jpg"));
//
//			// 3. Transferring the screenshot without hard coding (advisable to be used like this)
//			FileUtils.copyFile(file, new File( System.getProperty("user.dir") 
//					+ "/src/test/java/Webdriver\\_28_ScreenshotAndJavascript/screenshots/" + fileName + System.currentTimeMillis()+".jpg"));
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		try {
			FileUtils.copyFile(file,new File(System.getProperty("user/dir")+"/src/test/java/Webdriver\\_28_ScreenshotAndJavascript/screenshots/"+fileName + System.currentTimeMillis()+".jpg"));
			
		} 
		catch (IOException e) {

			e.printStackTrace();
		}
	}
}