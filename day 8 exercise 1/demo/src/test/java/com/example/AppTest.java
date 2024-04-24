package com.example;



import java.io.FileInputStream;

import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class AppTest 
{
    public WebDriver driver;
    public XSSFWorkbook workbook;
    public String username;
    public String password;
    public Select account;
    @BeforeTest
    public void beforeTest() throws InterruptedException, IOException
    {
        driver = new ChromeDriver();
        
        FileInputStream fis = new FileInputStream("C:\\Users\\22it1\\OneDrive\\Desktop\\testing\\day 8 exercise 1\\demo\\src\\excel\\data1.xlsx");
        workbook = new XSSFWorkbook(fis);
        
        XSSFSheet sheet = workbook.getSheet("Data");
        
        username = sheet.getRow(1).getCell(0).getStringCellValue();
        password = sheet.getRow(1).getCell(1).getStringCellValue();
        
    }
    @Test
    public void TestCase1() throws InterruptedException
    {
        driver.get("http://dbankdemo.com/bank/login");
        Thread.sleep(6000);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(3000);
        
        driver.findElement(By.id("submit")).click();;
        Thread.sleep(3000);

        if(driver.getCurrentUrl().contains("home"))
        {
            System.out.println("Login Successful Redirected to HomePage");
        }

    }
    @Test
    public void TestCase2() throws InterruptedException
    {
        driver.get("http://dbankdemo.com/bank/login");
        Thread.sleep(6000);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(3000);
        
        driver.findElement(By.id("submit")).click();;
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//*[@id='deposit-menu-item']")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//*[@id='selectedAccount']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='selectedAccount']/option[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='amount']")).sendKeys("5000");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='right-panel']/div[2]/div/div/div/div/form/div[2]/button[1]")).click();

        // driver.findElement(By.xpath("//*[@id='transactionTable']/tbody/tr[1]/td[4]")).click();
        String check = driver.findElement(By.xpath("//*[@id='transactionTable']/tbody/tr[1]/td[4]")).getText();
        if(check.contains("5000"))
        {
            System.out.println("Amount Deposited");
        }

    }
    @Test
    public void Testcase3() throws InterruptedException
    {
        driver.get("http://dbankdemo.com/bank/login");
        Thread.sleep(6000);
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        Thread.sleep(3000);
        
        driver.findElement(By.id("submit")).click();
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//*[@id='withdraw-menu-item']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='selectedAccount']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='selectedAccount']/option[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='amount']")).sendKeys("3000");;
        Thread.sleep(3000);
        
        driver.findElement(By.xpath("//*[@id='right-panel']/div[2]/div/div/div/div/form/div[2]/button[1]")).click();
        String check = driver.findElement(By.xpath("//*[@id='transactionTable']/tbody/tr[1]/td[4]")).getText();
        if(check.contains("3000"))
        {
            System.out.println("Amount Withdrawed");
        }
        Thread.sleep(3000);
        
    }
    @AfterTest
    public void afterTest() throws IOException
    {
        workbook.close();
        driver.quit();
    }

}