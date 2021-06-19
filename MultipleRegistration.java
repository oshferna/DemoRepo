package com.testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.Xls_Reader;

public class MultipleRegistration {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Xls_Reader reader=new Xls_Reader("C:\\Users\\MY PC\\eclipse-workspace\\DataDrivenFrameworkProject\\src\\com\\testdata\\excel.xlsx");
		int rowcount=reader.getRowCount("register");
		reader.addColumn("register", "status");
		for(int rownum=2;rownum<=rowcount;rownum++)
		{
		String FirstName=reader.getCellData("register", "firstname", rownum);
		System.out.println(FirstName);
		String LastName=reader.getCellData("register", "lastname", rownum);
		System.out.println(LastName);
		String Address1=reader.getCellData("register", "address1", rownum);
		System.out.println(Address1);
		String Address2=reader.getCellData("register", "address2", rownum);
		System.out.println(Address2);
		String City=reader.getCellData("register", "city", rownum);
		System.out.println(City);
		String State=reader.getCellData("register", "state", rownum);
		System.out.println(State);
		String Postcode=reader.getCellData("register", "postcode", rownum);
		System.out.println(Postcode);
		String Number=reader.getCellData("register", "number", rownum);
		System.out.println(Number);
		String Email=reader.getCellData("register", "email", rownum);
		System.out.println(Email);
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\MY PC\\eclipse-workspace\\Software\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		Properties prop = new Properties();
		FileInputStream ip=new FileInputStream("C:\\Users\\MY PC\\eclipse-workspace\\DataDrivenFrameworkProject\\src\\com\\excel\\propertyfile\\configuration.properties");
		prop.load(ip);
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='first_3']")).sendKeys(FirstName);
		driver.findElement(By.xpath("//input[@id='last_3']")).sendKeys(LastName);
		driver.findElement(By.xpath("//input[@id='input_4_addr_line1']")).sendKeys(Address1);
		
		driver.findElement(By.xpath("//input[@id='input_4_addr_line2']")).sendKeys(Address2);
		driver.findElement(By.xpath("//input[@id='input_4_city']")).sendKeys(City);
		driver.findElement(By.xpath("//input[@id='input_4_state']")).sendKeys(State);
		driver.findElement(By.xpath("//input[@id='input_4_postal']")).sendKeys(Postcode);
		driver.findElement(By.xpath("//input[@id='input_5_full']")).sendKeys(Number);
		driver.findElement(By.xpath("//input[@id='input_6']")).sendKeys(Email);
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("javascript:window.scrollBy(250,350)");
		driver.findElement(By.xpath("//button[@id='input_2']")).click();
		driver.close();
		
		reader.setCellData("register", "status", rownum, "Pass");
		
		
		

		}
	}

}
