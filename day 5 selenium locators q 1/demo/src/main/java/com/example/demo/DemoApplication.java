package com.example.demo;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.get("https://www.demoblaze.com/");
		driver.findElement(By.linkText("Laptops")).click();

		Thread.sleep(1000);
		driver.findElement(By.linkText("MacBook air")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.linkText("Add to cart")).click();
		
		Thread.sleep(1000);
		driver.switchTo().alert().accept();
		
		Thread.sleep(3000);
		driver.findElement(By.linkText("Cart")).click();
		
		Thread.sleep(5000);
		List<WebElement> list=driver.findElements(By.tagName("td"));

		System.out.println(list.size());
		System.out.println("Price : "+list.get(1).getText());
		System.out.println("Price : "+list.get(2).getText());
	

	}

}
