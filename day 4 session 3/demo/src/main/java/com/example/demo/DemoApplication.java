package com.example.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws InterruptedException
	{
		
		WebDriver driverchrome=new ChromeDriver();
		driverchrome.get("https://www.shoppersstop.com");
		driverchrome.findElement(By.id("profileImage")).click();

		Thread.sleep(100000);

		driverchrome.close();


		SpringApplication.run(DemoApplication.class, args);
	}

}
