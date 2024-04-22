package com.example.demo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.util.FileUtil;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://magento.softwaretestingboard.com/");


		Thread.sleep(2000);
		driver.findElement(By.id("search")).sendKeys("Shoes");

		//tocheck the presence of shoe
		if(driver.findElement(By.xpath("//*[@id='maincontent']/div[1]/h1/span")).getText().contains("Shoes"))
		{
			System.out.println("Search for results : Shoes is present");
		}
		else
		{
			System.out.println("Search for results : Shoes is not present");
		}
		Thread.sleep(2000);
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		
		//Move image file to new destination
		String fileWithPath = "C:/Users/22it1/OneDrive/Desktop/testing/day 5 pah/demo/src/main/java/com/example/demo/asserts/eg.png";

		File DestFile=new File(fileWithPath);
		//Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='search_mini_form']/div[2]/button")).click();
		
		Thread.sleep(2000);
		Actions actions=new Actions(driver);
		
		WebElement men=driver.findElement(By.xpath("//*[@id='ui-id-5']/span[2]"));
		actions.moveToElement(men).build().perform();
		
		WebElement top=driver.findElement(By.xpath("//*[@id='ui-id-17']"));
		actions.moveToElement(top).build().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='ui-id-20']/span")).click();
		
		Thread.sleep(2000);
		driver.navigate().to("https://magento.softwaretestingboard.com/");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,600)", "");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div/div[3]/div[1]/div/a[2]/span[2]/span[2]")).click();
		
		JavascriptExecutor js1=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		js1.executeScript("window.scrollBy(0,400)", "");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='maincontent']/div[3]/div[1]/div[4]/ol/li[3]/div/a/span/span/img")).click();
		
		JavascriptExecutor js2=(JavascriptExecutor)driver;
		Thread.sleep(2000);
		js2.executeScript("window.scrollBy(0,500)", "");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='option-label-size-143-item-168']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='option-label-color-93-item-56']")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("qty")).clear();
		
		driver.findElement(By.id("qty")).sendKeys("4");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='product-addtocart-button']/span")).click();


		
		










		SpringApplication.run(DemoApplication.class, args);
	}

}
