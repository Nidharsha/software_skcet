package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) 
	{

		WebDriver driverchrome=new ChromeDriver();
		WebDriver driveredge=new EdgeDriver();
		WebDriver driverfirefox=new FirefoxDriver();

		driverchrome.get("https://www.google.com");
		driverchrome.close();

		driveredge.get("https://www.google.com");
		driveredge.close();

		driverfirefox.get("https://www.google.com");
		driverfirefox.close();

		SpringApplication.run(DemoApplication.class, args);
	}

}
