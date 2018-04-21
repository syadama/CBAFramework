package com.cba.testscenario;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class SeleniumEC2Test {

	@Test
	public void runSeleniumEC2Test() throws Exception {
		// TODO Auto-generated constructor stub

		WebDriver driver;

		System.out.println("/***************************************/");
		System.out.println("Test Execution in EC2 Instance");

		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		 /*System.setProperty("webdriver.chrome.driver",
		 "/Users/srikanth/Documents/workspace/CBAFramework/src/main/resources/chromedriver");

		
		  ChromeOptions chromeOptions = new ChromeOptions();
		  chromeOptions.addArguments("--headless");
		  chromeOptions.addArguments("--no-sandbox"); 
		  driver = new ChromeDriver(chromeOptions);*/
		 

		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setCapability("headless", true);
		String Node = "http://52.15.172.63:4444/wd/hub";
		driver = new RemoteWebDriver(new URL(Node), cap);

		driver.get("https://google.com");
		Thread.sleep(1000);
		if (driver.getPageSource().contains("I'm Feeling Lucky")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		driver.quit();
		System.out.println("/***************************************/");
	}

}
