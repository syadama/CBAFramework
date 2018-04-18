package com.cba.samplepackage;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class SampleTestNGTest {
	private WebDriver driver;		
	
	@Test				
	public void testPageTitle() throws Exception {	
		
		//System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		System.setProperty("webdriver.chrome.driver", "/Users/srikanth/Documents/workspace/CBAFramework/src/main/resources/chromedriver");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--no-sandbox");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("http://demo.guru99.com/test/guru99home/");
		Thread.sleep(1000);
		String title = driver.getTitle();				 
		Assert.assertTrue(title.contains("Demo Guru99 Page"));
		driver.quit();
		
	}	

}
