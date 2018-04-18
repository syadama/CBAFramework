package com.cba.samplepackage;

import java.io.File;
import java.util.Collections;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SampleTest {

	public static void main(String[] args) throws InterruptedException {
		
	/*	System.out.println("Hi There!!!!");
		
		InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile( new File( "/CBAFramework/pom.xml" ));
        request.setGoals( Collections.singletonList( "install" ));
        Invoker invoker = new DefaultInvoker();
       System.out.println("Maven_Home is " + System.getenv());
        
        System.out.println("Maven_Home is " + System.getenv("MAVEN_HOME"));
        invoker.setMavenHome(new File(System.getenv("MAVEN_HOME")));
        try {
            invoker.execute( request );
        } catch (MavenInvocationException e) {
            e.printStackTrace();
        } */
		
		System.out.println("/***************************************/");
		System.out.println("Java jar with Maven Dependencies");
		
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		//System.setProperty("webdriver.chrome.driver", "/Users/srikanth/Documents/workspace/CBAFramework/src/main/resources/chromedriver");
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		chromeOptions.addArguments("--no-sandbox");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://google.com");
		Thread.sleep(1000);
		if (driver.getPageSource().contains("I'm Feeling Lucky")) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
		driver.quit();
	}
/*	public class MainOne {
    public static void main(String[] args) {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile( new File( "pom.xml" ));
        request.setGoals( Collections.singletonList( "install" ));
        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(System.getenv("MAVEN_HOME")));
        try {
            invoker.execute( request );
        } catch (MavenInvocationException e) {
            e.printStackTrace();
        } 
    } 
}*/

}
