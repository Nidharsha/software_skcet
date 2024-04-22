package com.example.day6ex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day6exApplication {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.get("https://economictimes.indiatimes.com/mutual-funds");
		driver.manage().window().maximize();

		WebElement dropdown=driver.findElement(By.id("amcSelection"));
		Select dropdown_select=new Select(dropdown);
		dropdown_select.selectByValue("4");
		Thread.sleep(6000);

		WebElement dropdown1=driver.findElement(By.id("schemenm"));
		Select dropdown_select1=new Select(dropdown1);
		dropdown_select1.selectByVisibleText("Aditya Birla SL Active Debt Multi Manager FoF Direct-G");

		//Thread.sleep(5000);
		driver.findElement(By.id("getDetails")).click();


		SpringApplication.run(Day6exApplication.class, args);
	}

}
